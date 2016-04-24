package fishackthon.ghostgear;


import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Created by Algernon on 4/23/16.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://172.28.1.197:3000";

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("HTTP"))
            .setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
