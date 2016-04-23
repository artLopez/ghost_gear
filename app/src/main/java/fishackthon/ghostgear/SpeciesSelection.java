package fishackthon.ghostgear;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class SpeciesSelection extends AppCompatActivity  {
    private Spinner speciesSelection;
    private static final String[]species = {"Select a species...","Crab","Fish","Sea Lion", "Turtle"};
    private ListView animalList;
    private ArrayList<String> speciesAdded;
    ArrayAdapter<String> speciesAdapter;
    private AlertDialog.Builder speciesStatus;
    private RadioGroup radioGroup;
    private RadioButton aliveButton, deadButton;
    private Button okButton, cancelButton;
    private TextView question;
    private boolean userSelect = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_selection);

        speciesSelection = (Spinner) findViewById(R.id.speciesSelection);
        animalList = (ListView) findViewById(R.id.speciesList);
        speciesAdded = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                ( SpeciesSelection.this, android.R.layout.simple_spinner_item, species ){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                    return false;
                else
                    return true;
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0)
                    tv.setTextColor(Color.GRAY);
                else
                    tv.setTextColor(Color.BLACK);

                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesSelection.setAdapter(adapter);
        speciesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, speciesAdded);
        animalList.setAdapter( speciesAdapter );

        speciesSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position != 0){
                    speciesStatusDialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

    }
    private void speciesStatusDialog() {
        String species = speciesSelection.getSelectedItem().toString();

        final Dialog speciesStatusDialog = new Dialog(this);
        speciesStatusDialog.setContentView(R.layout.species_custom);
        speciesStatusDialog.setTitle("Current Status of ");

        radioGroup = (RadioGroup) speciesStatusDialog.findViewById(R.id.statusRadioGroup);
        aliveButton = (RadioButton) speciesStatusDialog.findViewById(R.id.aliveButton);
        deadButton = (RadioButton) speciesStatusDialog.findViewById(R.id.deadButton);
        okButton = (Button) speciesStatusDialog.findViewById(R.id.okButton);
        cancelButton = (Button) speciesStatusDialog.findViewById(R.id.cancelButton);
        question = (TextView) speciesStatusDialog.findViewById(R.id.questionView);

        question.setText("What is the current status of " + species + "?");

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speciesAdded.add(speciesSelection.getSelectedItem().toString());
                speciesAdapter.notifyDataSetChanged();
                speciesStatusDialog.dismiss();
            }
        });

        speciesStatusDialog.show();
    }

}





