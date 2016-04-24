package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

/**
 * Created by Algernon on 4/24/16.
 */
public class Animals {

    @Expose
    String code;
    @Expose
    String condition;
    @Expose
    String length_size;

    public Animals(String c, String cond, String length_size) {
        this.code = c;
        this.condition = cond;
        this.length_size = length_size;
    }
}
