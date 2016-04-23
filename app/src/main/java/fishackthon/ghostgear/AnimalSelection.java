package fishackthon.ghostgear;

import android.content.Intent;
import android.provider.MediaStore;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.TextView;

public class AnimalSelection extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton yesButton, noButton;
    private Button nextButton;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_selection);

        radioGroup = (RadioGroup) findViewById(R.id.foundGroup);
        yesButton = (RadioButton) findViewById(R.id.yesButton);
        noButton = (RadioButton) findViewById(R.id.noButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yesButton.isChecked()){
                    final Intent animalIntent = new Intent(AnimalSelection.this, SpeciesSelection.class);
                    AnimalSelection.this.startActivity(animalIntent);
                    AnimalSelection.this.finish();
                }
                else{
                    final Intent animalIntent = new Intent(AnimalSelection.this, SpeciesSelection.class);
                    AnimalSelection.this.startActivity(animalIntent);
                    AnimalSelection.this.finish();
                }

            }
        });
    }
}
