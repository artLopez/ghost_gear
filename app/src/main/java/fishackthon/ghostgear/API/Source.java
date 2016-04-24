package fishackthon.ghostgear.API;

import com.google.gson.annotations.Expose;

/**
 * Created by Algernon on 4/24/16.
 */
public class Source {
    @Expose
    String contact_number;

    @Expose
    String email;

    @Expose
    String first_name;

    @Expose
    String last_name;

    @Expose
    String role;

    public Source(String cn, String e, String fn, String ln, String r) {
        contact_number = cn;
        email = e;
        first_name = fn;
        last_name = ln;
        role = r;
    }
}
