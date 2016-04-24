package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

/**
 * Created by Algernon on 4/23/16.
 */
public class ReportedLocation {
    @Expose
    private String lat;

    @Expose
    private String lng;

    public ReportedLocation(String lat, String lon) {
        this.lat = lat;
        this.lng = lon;
    }
}
