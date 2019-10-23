package ooo.zihuatanejo.mvpdemo.dagger;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.MediaType;
import ooo.zihuatanejo.mvpdemo.R;
import ooo.zihuatanejo.mvpdemo.ano.Release;
import ooo.zihuatanejo.mvpdemo.ano.Test;
import ooo.zihuatanejo.mvpdemo.httpmodule.HttpModule;

public class LoginActivity extends AppCompatActivity implements ICommonView {

    private boolean is_dev = true;
    @Inject
    LoginPresenter2 presenter2;
    @Test
    @Inject
    ApiService apiService_dev;
    @Release
    @Inject
    ApiService apiService_release;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerCommonComponent.builder()
                .commonModule(new CommonModule(this))
                .httpModule(new HttpModule())
                .build()
                .inject(this);

        Log.d("MainActivity", "onCreate: apiService_dev" + apiService_dev);
        Log.d("MainActivity", "onCreate: apiService_release" + apiService_release);
       /* if (is_dev) {
            apiService_dev.register();
        } else {
            apiService_release.register();
        }*/


    }

    @Override
    public Context getContext() {
        return this;
    }


    public void login2(View view) {
        presenter2.login(new User());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
