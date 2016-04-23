package fishackthon.ghostgear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import java.util.ArrayList;

public class SpeciesSelection extends AppCompatActivity {
    private Spinner speciesSelection;
    private static final String[]species = {"Select an species...","Crab","Fish","Sea Lion", "Turtle"};
    private ListView animalList;
    private ArrayList<String> speciesAdded;
    ArrayAdapter<String> speciesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_selection);

        speciesSelection = (Spinner) findViewById(R.id.speciesSelection);
        animalList = (ListView) findViewById(R.id.speciesList);
        speciesAdded = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                ( SpeciesSelection.this, android.R.layout.simple_spinner_item, species );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesSelection.setAdapter(adapter);
        speciesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, speciesAdded);
        animalList.setAdapter( speciesAdapter );

        speciesAdded.add(speciesSelection.getSelectedItem().toString());
        speciesAdapter.notifyDataSetChanged();

        speciesSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }

}



