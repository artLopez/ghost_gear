package fishackthon.ghostgear;

import java.util.Date;

/**
 * Created by brian on 4/23/16.
 */


public class Record {
    protected String mNotes;
    protected double mLatitude;
    protected double mLongitude;
    protected Date mDate;
    protected String mTime;
    protected String mImagePath;

    public Record() {

    }

    public Record setCoordinates (double latitude, double longitude) {
        mLatitude = latitude;
        mLongitude = longitude;
        return this;
    }

    public Record setDate (Date date) {
        mDate = date;
        return this;
    }

    public Record setCurrentDate () {
        mDate = new Date(System.currentTimeMillis());
        return this;
    }

    public Record setImage(String imagePath) {
        mImagePath = imagePath;

        return this;
    }
}
