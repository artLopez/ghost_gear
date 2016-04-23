package fishackthon.ghostgear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import android.widget.*;

/**
 * Created by Algernon on 4/23/16.
 */
public class MatchesActivity extends AppCompatActivity {
    private GridView imageGrid;
    private ArrayList<Bitmap> bitmapList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matches_activity);

        try{
            int id = getResources().getIdentifier("basketball", "drawable", getPackageName());
            Bitmap bit = BitmapFactory.decodeResource(this.getResources(), id);
            this.imageGrid = (GridView) findViewById(R.id.gridview);
            this.bitmapList = new ArrayList<Bitmap>();
            this.bitmapList.add(bit);

            this.imageGrid.setAdapter(new ImageAdapter(this, this.bitmapList));

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
