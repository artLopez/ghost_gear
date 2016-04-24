package fishackthon.ghostgear;

/**
 * Created by Algernon on 4/23/16.
 */
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.apache.commons.io.IOUtils;

public class DatabaseAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private DataBaseHelper mDbHelper;
    private int plusMinusMesh = 1;
    private double plusMinusTwine = 0.5;
    private DecimalFormat df = new DecimalFormat("#.##");

    public DatabaseAdapter(Context context)
    {
        if (context == null) {
            Log.v("Context", "is null");
        }
        this.mContext = context;

    }

    public void close() throws SQLException{
        mDbHelper.close();
    }

    public DatabaseAdapter open() throws SQLException
    {

            if (this.mContext != null) {
                Log.v(TAG, "NULL");
            }
            mDbHelper = new DataBaseHelper(this.mContext);

            try{
                mDbHelper.createDataBase();
            } catch(IOException e) {
                e.printStackTrace();
            }

            try{
                mDbHelper.openDataBase();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return this;
    }


    public ArrayList<String> getMatches(String twine, String mesh, int numStrands, String color)
    {
        ArrayList<String> netIDS = new ArrayList<>(10);
        String minRangeTwine = df.format(Double.parseDouble(twine) - plusMinusTwine);
        String maxRangeTwine = df.format(Double.parseDouble(twine) + plusMinusTwine);
        String minRangeMesh = df.format(Double.parseDouble(mesh) - plusMinusMesh);
        String maxRangeMesh = df.format(Double.parseDouble(mesh) + plusMinusMesh);

        Log.v("DB", "minRangeTwine: " + minRangeTwine);
        Log.v("DB", "maxRangeTwine: " + maxRangeTwine);
        Log.v("DB", "minRangeMesh: " + minRangeMesh);
        Log.v("DB", "maxRangeMesh: " + maxRangeMesh);
        Log.v("DB", "color: " + color);
        Log.v("DB", "strands: " + String.valueOf(numStrands));

        try
        {
            String sql ="SELECT NETCODE FROM net_kit where strands=? and color=? LIMIT 5";


            Cursor mCur = mDbHelper.myDataBase.rawQuery(sql, new String[] {String.valueOf(numStrands), color});

            if (mCur!=null)
            {
                Log.v("DB", "Cursor is not null");
                if (mCur.moveToFirst()) {
                    Log.v("DB", "Cursor move to first");
                    while (mCur.moveToNext()) {
                        String netID = mCur.getString(mCur.getColumnIndex("NETCODE"));
                        Log.v("DB", netID);
                        netIDS.add(netID);
                    }
                }
            }
            Log.v("DB", String.valueOf(netIDS.size()));
            return netIDS;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

}