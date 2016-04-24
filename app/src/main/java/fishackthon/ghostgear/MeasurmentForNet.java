package fishackthon.ghostgear;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MeasurmentForNet extends AppCompatActivity {
    private EditText meshEdit, twineView, netHeight, netWidth, strandsEdit;
    private FloatingActionButton nextButton;
    private Record mRecord;
    private boolean complete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurment_for_net);

        meshEdit = (EditText) findViewById(R.id.meshEdit);
        twineView = (EditText) findViewById(R.id.twineView);
        netHeight = (EditText) findViewById(R.id.netHeight);
        netWidth = (EditText) findViewById(R.id.netWidth);
        strandsEdit = (EditText) findViewById(R.id.strandsEdit);
        nextButton = (FloatingActionButton) findViewById(R.id.nextButton);

        mRecord = (Record) getIntent().getSerializableExtra("mRecord");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complete = true;
                if(TextUtils.isEmpty(meshEdit.getText().toString())) {
                    meshEdit.setError("Cannot leave blank");
                    complete = false;
                }
                if(TextUtils.isEmpty(twineView.getText().toString())) {
                    twineView.setError("Cannot leave blank");
                    complete = false;
                }
                if(TextUtils.isEmpty(netHeight.getText().toString())) {
                    netHeight.setError("Cannot leave blank");
                    complete = false;
                }
                if(TextUtils.isEmpty( netWidth.getText().toString())) {
                    netWidth.setError("Cannot leave blank");
                    complete = false;
                }
                if(TextUtils.isEmpty(strandsEdit.getText().toString())) {
                    strandsEdit.setError("Cannot leave blank");
                    complete = false;
                }
                if(complete)
                    setDataToRecord();
            }
        });
    }
    public void setDataToRecord(){
        String meshSize = meshEdit.getText().toString();
        String twinSize = twineView.getText().toString();
        String numStrands = strandsEdit.getText().toString();
        String netWidths = netWidth.getText().toString();
        String netHeights = netHeight.getText().toString();
        mRecord.setMeasurements(meshSize,twinSize,numStrands,netWidths,netHeights);
        Intent intent = new Intent(this, ImageAdapter.class);
        intent.putExtra("mRecord", mRecord);
        startActivity(intent);
    }
}