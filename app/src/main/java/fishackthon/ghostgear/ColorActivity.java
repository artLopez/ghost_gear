package fishackthon.ghostgear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by brian on 4/23/16.
 */
public class ColorActivity  extends AppCompatActivity {

    private Record mRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mRecord = (Record) getIntent().getSerializableExtra("mRecord");

        Log.d("lat", Double.toString(mRecord.mLatitude));
        Log.d("lon", Double.toString(mRecord.mLongitude));
    }
}
