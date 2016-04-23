package fishackthon.ghostgear;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int MEDIA_TYPE_IMAGE = 1;
    protected Context mContext;
    private int IMAGE_REQUEST = 1;
    private GPSTracker gps;
    private ImageView mImageView;
    private String mImagePath;
    private Double mLatitude;
    private Double mLongitude;
    private String mNotes;
    private File imgFile;
    private Record mRecord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Start", "Called");
        Context c = getApplicationContext();
        if (c == null) {
            Log.v("Start", "Null");
        }
        DatabaseAdapter mDbHelper = new DatabaseAdapter(getApplicationContext());
        mDbHelper.open();


        // Twine 0.3, Mesh1.7
        final ArrayList<String> lol = mDbHelper.getMatches("0.5", "9.5", -1, "White");

        mDbHelper.close();

        final Button cameraBT = (Button) findViewById(R.id.cameraButton);

        cameraBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOpenCamera();
              //  Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            }
        });


    }

    public void onOpenCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, IMAGE_REQUEST);
    }

    public void getPictureTaken(){
        // Find the last picture
        String[] projection = new String[]{
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.MIME_TYPE
        };
        final Cursor cursor = getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null,
                        null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

        if (cursor.moveToFirst()) {
            //mImageView = (ImageView) findViewById(R.id.imageView);
            mImagePath = cursor.getString(1);
            String imageLocation = cursor.getString(1);
            imgFile = new File(imageLocation);
            Bitmap imgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(imgBitmap, (int) (imgBitmap.getWidth() * 0.8), (int) (imgBitmap.getHeight() * 0.8), true);

            //mImageView.setImageBitmap(resizedBitmap);
        }

        getLocation();
    }

    public void getLocation(){
        mRecord = new Record();
        gps = new GPSTracker(this);
        gps.getLocation();
        if(!gps.canGetLocation()){
            gps.showSettingsAlert();
        }
        else {
           //while(mLatitude == null) {
                mLatitude = gps.getLatitude();
                mLongitude = gps.getLongitude();
            //}
        }

        Log.v("GPS", Double.toString(mLatitude));
        Log.v("GPS", Double.toString(mLongitude));
        mRecord.setCoordinates(mLatitude, mLongitude);

        Intent intent = new Intent(this, ColorActivity.class);
        intent.putExtra("mRecord", mRecord);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == IMAGE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                getPictureTaken();
            }
        }
    }
}
