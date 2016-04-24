package fishackthon.ghostgear;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SpeciesSelection extends AppCompatActivity  {
    private Spinner speciesSelection;
    private ListView animalList;
    private TextView question;
    private ArrayList<ItemData> speciesAdded;
    private ArrayList<ItemData> aniList;
    private ArrayAdapter<ItemData> speciesAdapter;
    private SpinnerAdapter adapter;
    private AlertDialog.Builder speciesStatus;
    private RadioGroup radioGroup;
    private RadioButton aliveButton, deadButton;
    private Button okButton, cancelButton, nextButton;
    private HashMap<String, ArrayList<String>> animals = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_selection);

        nextButton = (Button) findViewById(R.id.nextButton);
        aniList = new ArrayList<>();
        aniList.add(new ItemData("Select a species...", R.mipmap.ic_launcher));
        aniList.add(new ItemData("Crab", R.drawable.crab));
        aniList.add(new ItemData("Fish", R.drawable.fish));
        aniList.add(new ItemData("Sea lion", R.drawable.sealion));
        aniList.add(new ItemData("Turtle", R.drawable.turtle));
        // Spinner
        speciesSelection = (Spinner) findViewById(R.id.speciesSpinner);
        adapter = new SpinnerAdapter(this, R.layout.spinner_layout,R.id.text, aniList);
        speciesSelection.setAdapter(adapter);
        // ListView
        speciesAdded = new ArrayList<>();
        animalList = (ListView) findViewById(R.id.speciesList);
        speciesAdapter = new MyListAdapter();
        animalList.setAdapter( speciesAdapter );

        speciesSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position != 0)
                    speciesStatusDialog(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final Intent animalIntent = new Intent(SpeciesSelection.this, MeasurmentForNet.class);
                    SpeciesSelection.this.startActivity(animalIntent);
                    SpeciesSelection.this.finish();

            }
        });
    }

    private void speciesStatusDialog(int position) {
        final String species = adapter.list.get(position).getText();

        final Dialog speciesStatusDialog = new Dialog(this);
        speciesStatusDialog.setContentView(R.layout.species_custom);
        speciesStatusDialog.setTitle("Current Status of ");

        radioGroup   = (RadioGroup)  speciesStatusDialog.findViewById(R.id.statusRadioGroup);
        aliveButton  = (RadioButton) speciesStatusDialog.findViewById(R.id.aliveButton);
        deadButton   = (RadioButton) speciesStatusDialog.findViewById(R.id.deadButton);
        okButton     = (Button)   speciesStatusDialog.findViewById(R.id.okButton);
        cancelButton = (Button)   speciesStatusDialog.findViewById(R.id.cancelButton);
        question     = (TextView) speciesStatusDialog.findViewById(R.id.questionView);

        question.setText("What is the current status of " + species + "?");

        okButton.setOnClickListener(new View.OnClickListener() {
            String status = null;

            @Override
            public void onClick(View v) {

                if(aliveButton.isChecked()){
                    status = aliveButton.getText().toString();
                }
                else{
                    status = deadButton.getText().toString();
                }

                speciesAdded.add(new ItemData(species, getImage(species) , status));
                speciesAdapter.notifyDataSetChanged();
                speciesStatusDialog.dismiss();
            }
        });
        speciesStatusDialog.show();
    }
    private class MyListAdapter extends ArrayAdapter<ItemData>{
        public MyListAdapter(){
            super(SpeciesSelection.this,R.layout.item_data_layout, speciesAdded);
        }

        @Override
        public View getView (int position, View convertView,ViewGroup parent ){
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_data_layout,parent,false );
            }
            ItemData currentItem = speciesAdded.get(position);
            ImageView currentImage = (ImageView) itemView.findViewById(R.id.item_image);
            currentImage.setImageResource(currentItem.getImageId());

            TextView speciesView = (TextView) itemView.findViewById(R.id.item_txtMake);
            speciesView.setText(currentItem.getText());

            TextView statusView = (TextView) itemView.findViewById(R.id.item_statusView);
            statusView.setText(currentItem.getAnimalStatus());

            return itemView;
        }
    }
    public int getImage(String species){
        switch(species){
            case "Crab":
                return R.drawable.crab;
            case "Fish":
                return R.drawable.fish;
            case "Sea lion":
                return R.drawable.sealion;
            case "Turtle":
                return R.drawable.turtle;
            default:
                return -1;
        }
    }
    public void addToAnimalHashMap(String animal, String status){
        if(animals.containsKey(animal)){
            animals.get(animal).add(status);
        }else
        {
            animals.put(animal, new ArrayList<>(Arrays.asList(status)));
        }

    }
}
