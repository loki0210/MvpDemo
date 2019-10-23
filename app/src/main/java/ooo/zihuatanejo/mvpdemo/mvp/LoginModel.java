package ooo.zihuatanejo.mvpdemo.mvp;

import okhttp3.ResponseBody;
import ooo.zihuatanejo.mvpdemo.http.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

 class LoginModel {
    private static final String URL_LOGIN = "http://192.168.99.176:8080";

     void login(String username, String password, Callback<ResponseBody> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_LOGIN) //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Login login = retrofit.create(Login.class);
        Call<ResponseBody> bodyCall = login.LoginToLocal(username, password);
        bodyCall.enqueue(callback);


    }
}
