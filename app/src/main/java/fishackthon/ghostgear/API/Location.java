package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

/**
 * Created by Algernon on 4/23/16.
 */
public class Location {
    @Expose
    private String detail;


    @Expose
    private OriginalLocation orginating_location;
    @Expose ReportedLocation reported_location;

    public Location(String ogLat, String ogLon, String repLat, String repLong) {
        orginating_location = new OriginalLocation(ogLat, ogLon);
        reported_location = new ReportedLocation(repLat, repLong);
        this.detail = "Hello from Android!";
    }


    public void setDescription(String desc) {
        this.detail = desc;
    }



}
