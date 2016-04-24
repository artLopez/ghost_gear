package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;

/**
 * Created by Algernon on 4/23/16.
 */
public class Payload {

    @Expose
    private Location location;

    @Expose
    private Net_Data net_data;

    @Expose
    private Source source;

    @Expose
    private String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    private Animals[] wildlife_data = new Animals[10];

    private int counter = 0;

    public Payload(String ogLat, String ogLong, String repLat, String repLong,
                   String color, String comments, String enl, String enw, String ms,
                   String nc, String ts, String cn, String e, String fn, String ln,
                   String role) {
        location = new Location(ogLat, ogLong, repLat, repLong);
        net_data = new Net_Data(color, comments, enl, enw, ms, nc, ts);
        source = new Source(cn, e, fn, ln, role);
    }

    public void placeAnimals(Animals a) {
        if (counter == wildlife_data.length) {
            return;
        }
        wildlife_data[counter] = a;
        counter++;
    }
}

