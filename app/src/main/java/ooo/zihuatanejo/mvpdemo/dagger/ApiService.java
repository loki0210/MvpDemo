package ooo.zihuatanejo.mvpdemo.dagger;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiService {
    private static MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    OkHttpClient okHttpClient;

    @Inject
    ApiService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void register() {
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url("")
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
