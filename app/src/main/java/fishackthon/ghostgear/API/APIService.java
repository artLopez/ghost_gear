package fishackthon.ghostgear.API;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Algernon on 4/23/16.
 */
public interface APIService {
    public static final String BASE_URL = "http://localhost:2455/";

    @Multipart
    @POST("/record")
    void upload(@Part("image")TypedFile file,
                @Part("first_name") String firstName,
                @Part("last_name") String lastName,
                @Part("email") String email,
                @Part("number") String number,
                @Part("role") String role,
                @Part("latitude") String latitude,
                @Part("longitude") String longitude,
                @Part("color") String color,
                @Part("mesh_size") String meshSize,
                @Part("twine_size") String twineSize,
                @Part("net_code") String netCode,
                @Part("net_width") String netWidth,
                @Part("net_height") String netHeight,
                @Part("comments") String comments,
                @Part("animals") String animalsExists,
                @Part("animal_description") String animalDescriptions,
                Callback<String> cb);
}
