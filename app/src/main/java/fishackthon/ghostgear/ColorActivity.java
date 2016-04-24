package fishackthon.ghostgear;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

/**
 * Created by brian on 4/23/16.
 */
public class ColorActivity  extends AppCompatActivity implements View.OnClickListener {

    private Record mRecord;
    private String color, prevColor;
    private FloatingActionButton whiteB, greyB, blueB,
            blackB, brownB, greenB, redB, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mRecord = (Record) getIntent().getSerializableExtra("mRecord");
        color = "";
        prevColor = "white";
        whiteB = (FloatingActionButton) findViewById(R.id.whiteB);
        greyB = (FloatingActionButton) findViewById(R.id.greyB);
        blueB = (FloatingActionButton) findViewById(R.id.blueB);
        blackB = (FloatingActionButton) findViewById(R.id.blackB);
        brownB = (FloatingActionButton) findViewById(R.id.brownB);
        greenB = (FloatingActionButton) findViewById(R.id.greenB);
        redB = (FloatingActionButton) findViewById(R.id.redB);
        nextButton = (FloatingActionButton) findViewById(R.id.nextButton);


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
        prevColor = color;
        removeImage();
        switch (v.getId()) {
            case R.id.whiteB:
                whiteB.setImageResource(R.drawable.checkmark);
                color = "white";
                break;

            case R.id.greyB:
                greyB.setImageResource(R.drawable.checkmark);
                color = "grey";
                break;

            case R.id.blueB:
                blueB.setImageResource(R.drawable.checkmark);
                color = "blue";
                break;

            case R.id.blackB:
                blackB.setImageResource(R.drawable.checkmark);
                color = "black";
                break;

            case R.id.brownB:
                brownB.setImageResource(R.drawable.checkmark);
                color = "brown";
                break;

            case R.id.greenB:
                greenB.setImageResource(R.drawable.checkmark);
                color = "green";
                break;

            case R.id.redB:
                redB.setImageResource(R.drawable.checkmark);
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
        Log.v("color",color );

    }

    public void removeImage(){
        Log.v("prevColor", prevColor);
        switch(prevColor){
            case "white":
                whiteB.setImageResource(R.drawable.clear);
                break;

            case "grey":
                greyB.setImageResource(R.drawable.clear);
                break;

            case "blue":
                blueB.setImageResource(R.drawable.clear);
                break;

            case "black":
                blackB.setImageResource(R.drawable.clear);
                break;

            case "brown":
                brownB.setImageResource(R.drawable.clear);
                break;

            case "green":
                greenB.setImageResource(R.drawable.clear);
                break;

            case "red":
                redB.setImageResource(R.drawable.clear);
                break;

            default:
                break;
        }
    }

}
