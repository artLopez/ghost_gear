package fishackthon.ghostgear;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brian on 4/23/16.
 */

public class Record implements Serializable{
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String number;
    protected String role;
    protected String latitude;
    protected String longitude;
    protected File imageFile;
    protected String color;
    protected String animalDescriptions;
    protected String meshSize;
    protected String twineSize;
    protected String numberStrands;
    protected String netWidth;
    protected String netHeight;
    protected String netCode;
    protected String comments;
    protected HashMap<String,ArrayList<String>> animalsOnNet;

    public Record() {
        firstName = "";
        lastName = "";
        email = "";
        number = "";
        role = "";
        latitude = "";
        longitude = "";
        imageFile = null;
        color = "";
        animalDescriptions = "";
        meshSize = "";
        twineSize = "";
        numberStrands = "";
        netCode = "";
        netWidth = "";
        netHeight = "";
        comments = "";
    }

    public Record setMeasurements(String mMeshSize, String mTwineSize, String mNumberStrands, String mNetWidth, String mNetHeight){
        meshSize = mMeshSize;
        twineSize = mTwineSize;
        numberStrands = mNumberStrands;
        netWidth = mNetWidth;
        netHeight = mNetHeight;
        return this;
    }

    public Record setComments(String mComments){
        comments = mComments;
        return this;
    }

    public Record setNetCode(String mNetCode){
        netCode = mNetCode;
        return this;
    }

    public Record setColor(String mColor){
        color = mColor;
        return this;
    }

    public Record setCoordinates (String mlatitude, String mlongitude) {
        latitude = mlatitude;
        longitude = mlongitude;
        return this;
    }

    public Record setImage(File imgFile) {
        imageFile = imgFile;

        return this;
    }
}
