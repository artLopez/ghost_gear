package fishackthon.ghostgear;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import fishackthon.ghostgear.API.Animals;
import fishackthon.ghostgear.API.Payload;


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

    protected class AsyncTaskRunner extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            Payload payload = new Payload("23.43", "-121.23", "50.23", "65.23",
                    "White", "#Fishhackthon", "1", "2", "3", "WT23", "5",
                    "1234567890", "lol@lol.com", "Daniel", "Diaz", "Engineer");
            Animals a = new Animals("a", "Good", "10");
            payload.placeAnimals(a);
            Gson gson = new Gson();
            Type type = new TypeToken<Payload>() {}.getType();
            String json = gson.toJson(payload, type);
            Log.v("HTTP", json);

            final OkHttpClient client = new OkHttpClient();

            RequestBody  r = new MultipartBuilder()
                    .type(MultipartBuilder.FORM)
                    .addPart(
                            Headers.of("Content-Disposition", "form-data; name=\"payload\""),
                            RequestBody.create(null, json)
                    )
                    .build();

            com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                    .url("http://172.20.10.2:3000/ghostgear")
                    .post(r)
                    .build();

            try{
                Response response = client.newCall(request).execute();
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            } catch (IOException e) {
                Log.v("HTTP", "FAILED");
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int roll = values[0];

        }
    }

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

        hitIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTaskRunner().execute("");
        }
    });

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
