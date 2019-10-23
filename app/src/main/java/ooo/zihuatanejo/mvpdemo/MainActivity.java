package ooo.zihuatanejo.mvpdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import okhttp3.ResponseBody;
import ooo.zihuatanejo.mvpdemo.http.Login;
import ooo.zihuatanejo.mvpdemo.mvp.LoginPresenter;
import ooo.zihuatanejo.mvpdemo.mvp.LoginView;
import ooo.zihuatanejo.mvpdemo.mvp.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{
    public static String TAG = "MainActivity666";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void toLogin() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.99.176:8080/") //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Login request = retrofit.create(Login.class);
      /*  Call<ResponseBody> bodyCall = request.LoginToLocal("loki", "loki");
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, call.toString(), Toast.LENGTH_SHORT).show();

            }
        });*/
    }


    public void login(View view) {
        getPresenter().login("loki", "loki");
    }

    @Override
    public void onLoginResult(String result) {
        Log.i(TAG, "onLoginResult: " + result);
        Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
    }



    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }
}
