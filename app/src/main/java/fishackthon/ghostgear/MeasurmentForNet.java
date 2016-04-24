package fishackthon.ghostgear;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MeasurmentForNet extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private EditText meshEdit, twineView, netHeight, netWidth, strandsEdit;
    private Button nextButton;
    private Record mRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurment_for_net);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*
        meshEdit = (EditText) findViewById(R.id.meshEdit);
        twineView = (EditText) findViewById(R.id.twineView);
        netHeight = (EditText) findViewById(R.id.netHeight);
        netWidth = (EditText) findViewById(R.id.netWidth);
        strandsEdit = (EditText) findViewById(R.id.strandsEdit);
        nextButton = (Button) findViewById(R.id.nextButton);
        mRecord = (Record) getIntent().getSerializableExtra("mRecord");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(meshEdit.getText().toString())) {
                    meshEdit.setError("Cannot leave blank");
                }
                if(TextUtils.isEmpty(twineView.getText().toString())) {
                    twineView.setError("Cannot leave blank");
                }
                if(TextUtils.isEmpty(netHeight.getText().toString())) {
                    netHeight.setError("Cannot leave blank");
                }
                if(TextUtils.isEmpty( netWidth.getText().toString())) {
                    netWidth.setError("Cannot leave blank");
                }
                if(TextUtils.isEmpty(strandsEdit.getText().toString())) {
                    strandsEdit.setError("Cannot leave blank");
                }
            }
        }); */


    }
    public void setDataToRecord(){
        int meshSize   = Integer.parseInt( meshEdit.getText().toString());
        int twinSize   = Integer.parseInt( twineView.getText().toString());;
        int numStrands = Integer.parseInt( strandsEdit.getText().toString());;
        int netWidths   = Integer.parseInt( netWidth.getText().toString());;
        int netHeights  = Integer.parseInt( netHeight.getText().toString());;

        //mRecord.setMeasurements(meshSize,twinSize,numStrands,netWidths,netHeights);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}