package fishackthon.ghostgear;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by Algernon on 4/23/16.
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "http://107.170.37.93:3000/";

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
