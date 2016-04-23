package fishackthon.ghostgear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpeciesSelection extends AppCompatActivity {
    private Button addButton;
    private Spinner speciesSelection;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_selection);
    }
}
