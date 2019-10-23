package ooo.zihuatanejo.mvpdemo.dagger;

import android.util.Log;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import ooo.zihuatanejo.mvpdemo.ano.Release;
import ooo.zihuatanejo.mvpdemo.ano.Test;
import ooo.zihuatanejo.mvpdemo.httpmodule.HttpModule;

@Module(includes = HttpModule.class)
class CommonModule {
    private ICommonView iCommonView;

    CommonModule(ICommonView view) {
        this.iCommonView = view;
    }

    @Provides
    @ActivityScope
    ICommonView provideIcommonView() {
        return this.iCommonView;
    }

    @Test
    @Provides
    ApiService provideApiService(OkHttpClient client) {
        ApiService apiService = new ApiService(client);
        Log.i("CommonModule----dev", "dev" + apiService);
        return apiService;
    }

    @Release
    @Provides
    ApiService provideApiServiceRelease(OkHttpClient client) {
        ApiService apiService = new ApiService(client);
        Log.i("CommonModule----release", "release" + apiService);
        return apiService;
    }
}
