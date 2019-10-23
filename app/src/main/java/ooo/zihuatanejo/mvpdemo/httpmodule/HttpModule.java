package ooo.zihuatanejo.mvpdemo.httpmodule;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class HttpModule {
    @Provides
    OkHttpClient provideOkHttpClient() {
        Log.d("HttpModule", "HttpModule: ");
        return new OkHttpClient().newBuilder().build();
    }
}
