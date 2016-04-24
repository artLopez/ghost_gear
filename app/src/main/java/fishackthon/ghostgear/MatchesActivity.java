package fishackthon.ghostgear;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import android.util.Log;
import android.view.View;
import android.widget.*;

import fishackthon.ghostgear.API.APIService;
import retrofit2.Callback;
/**
 * Created by Algernon on 4/23/16.
 */
public class MatchesActivity extends AppCompatActivity {
    private GridView imageGrid;
    private ArrayList<CodeID> bitmapList;
    String path;

    String first_name = "Daniel";
    String last_name = "Diaz";
    String email = "lol@lol.com";
    String phone = "1234567890";
    String role = "Boss";
    String latitude = "36.6188";
    String longitude = "-121.902";
    String color = "White";
    String meshSize = "1.7";
    String twineSize = "0.3";
    String numberStrands = "3";
    String netCode = "WT29";
    String netWidth = "5";
    String netHeight = "5";
    String comments = "Lol";
    String animalDescriptions = "[{code: 3, condition: 'Alive', length_size: 2}]";

    SharedPreferences pref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matches_activity);
        Intent i = getIntent();
        Record mRecord = (Record) i.getSerializableExtra("mRecord");

        ArrayList<String> codes = i.getStringArrayListExtra("lol");
        this.bitmapList = new ArrayList<CodeID>();


        try {
            for (String code : codes) {
                String lowerCode = code.toLowerCase();
                int id = getResources().getIdentifier(lowerCode, "drawable", getPackageName());
                this.bitmapList.add(new CodeID(code, String.valueOf(id)));
            }

            this.imageGrid = (GridView) findViewById(R.id.gridview);
            this.imageGrid.setAdapter(new ImageAdapter(this, this.bitmapList));

        } catch (Exception e1) {
            e1.printStackTrace();
        }


        final Button hitIT = (Button) findViewById(R.id.hitIt);



    }
    class CodeID {
        String code = "";
        String ID = "";

        CodeID(String code, String ID) {
            this.code = code;
            this.ID = ID;
        }
    }
}
