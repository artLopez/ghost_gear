package fishackthon.ghostgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;

public class SpeciesSelection extends AppCompatActivity {
    private Button addButton;
    private Spinner speciesSelection;
    private static final String[]species = {"Crab","Fish","Sea Lion", "Turtle"};
    private ListView animalList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_selection);

        addButton = (Button) findViewById(R.id.addButton);
        speciesSelection = (Spinner) findViewById(R.id.speciesSelection);
        animalList = (ListView) findViewById(R.id.speciesList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                ( SpeciesSelection.this, android.R.layout.simple_spinner_item, species );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesSelection.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =  speciesSelection.getSelectedItem().toString();



            }
        });
    }
}

