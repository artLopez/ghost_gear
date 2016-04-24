package fishackthon.ghostgear;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by brian on 4/23/16.
 */
public class ColorActivity  extends AppCompatActivity implements View.OnClickListener {

    private Record mRecord;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mRecord = (Record) getIntent().getSerializableExtra("mRecord");
        color = "";
        final FloatingActionButton whiteB = (FloatingActionButton) findViewById(R.id.whiteB);
        final FloatingActionButton greyB = (FloatingActionButton) findViewById(R.id.greyB);
        final FloatingActionButton blueB = (FloatingActionButton) findViewById(R.id.blueB);
        final FloatingActionButton blackB = (FloatingActionButton) findViewById(R.id.blackB);
        final FloatingActionButton brownB = (FloatingActionButton) findViewById(R.id.brownB);
        final FloatingActionButton greenB = (FloatingActionButton) findViewById(R.id.greenB);
        final FloatingActionButton redB = (FloatingActionButton) findViewById(R.id.redB);
        final FloatingActionButton nextButton = (FloatingActionButton) findViewById(R.id.nextButton);


        whiteB.setOnClickListener(this);
        greyB.setOnClickListener(this);
        blueB.setOnClickListener(this);
        blackB.setOnClickListener(this);
        brownB.setOnClickListener(this);
        greenB.setOnClickListener(this);
        redB.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.whiteB:
                color = "white";
                break;

            case R.id.greyB:
                color = "grey";
                break;

            case R.id.blueB:
                color = "blue";
                break;

            case R.id.blackB:
                color = "black";
                break;

            case R.id.brownB:
                color = "brown";
                break;

            case R.id.greenB:
                color = "green";
                break;

            case R.id.redB:
                color = "red";
                break;

            case R.id.nextButton:
                mRecord.setColor(color);
                Log.v("next", "nextButton");
                Intent intent = new Intent(this, AnimalSelection.class);
                intent.putExtra("mRecord", mRecord);
                startActivity(intent);
                break;
            default:
                break;
        }
        Log.v("color", color);
    }

}
