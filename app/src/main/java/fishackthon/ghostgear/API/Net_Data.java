package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

/**
 * Created by Algernon on 4/24/16.
 */
public class Net_Data {

    @Expose
    private String color;

    @Expose
    private String comments;

    @Expose
    private String estimate_net_length;

    @Expose
    private String estimate_net_width;

    @Expose
    private String mesh_size;

    @Expose
    private String net_code;

    @Expose
    private String twine_size;

    public Net_Data(String c, String comments, String enl, String enw, String mz, String nc, String ts) {
        color = c;
        this.comments = comments;
        estimate_net_length = enl;
        estimate_net_width = enw;
        mesh_size = mz;
        net_code = nc;
        twine_size = ts;
    }

}
