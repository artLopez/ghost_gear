package fishackthon.ghostgear.API;

import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by Algernon on 4/23/16.
 */
public interface APIService {

    @Multipart
    @POST("/")
    void createPayload(@Part("Payload") Payload payload, retrofit.Callback<Payload> cb);

}

