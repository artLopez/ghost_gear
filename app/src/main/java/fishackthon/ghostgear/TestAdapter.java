package fishackthon.ghostgear;

/**
 * Created by Algernon on 4/23/16.
 */
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TestAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;
    private int plusMinusMesh = 1;
    private double plusMinusTwine = 0.5;

    public TestAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public TestAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public TestAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList<String> getMatches(String mesh, String twine, String color, int numStrands)
    {
        ArrayList<String> netIDS = new ArrayList<>(10);
        String minRangeTwine = String.valueOf(Double.parseDouble(twine) - plusMinusTwine);
        String maxRangeTwine = String.valueOf(Double.parseDouble(twine) + plusMinusTwine);
        String minRangeMesh = String.valueOf(Double.parseDouble(mesh) - plusMinusMesh);
        String maxRangeMesh = String.valueOf(Double.parseDouble(mesh) + plusMinusMesh);
        try
        {
            String sql ="SELECT netID FROM Nets numStrands = ? AND color = ? AND mesh BETWEEN ? AND ? AND twine BETWEEN ? AND ?";

            Cursor mCur = mDb.rawQuery(sql, new String[] {String.valueOf(numStrands), color, minRangeMesh, maxRangeMesh, minRangeTwine, maxRangeTwine});
            if (mCur!=null)
            {
                if (mCur.moveToFirst()) {
                    while (mCur.isAfterLast()) {
                        String netID = mCur.getString(mCur.getColumnIndex("netID"));
                        netIDS.add(netID);
                        mCur.moveToNext();
                    }
                }
            }
            return netIDS;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

}