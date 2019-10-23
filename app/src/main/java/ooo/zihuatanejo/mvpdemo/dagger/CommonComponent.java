package ooo.zihuatanejo.mvpdemo.dagger;

import dagger.Component;
import ooo.zihuatanejo.mvpdemo.httpmodule.HttpModule;

@ActivityScope
@Component(modules = {CommonModule.class,HttpModule.class})
public interface CommonComponent {

    void inject(LoginActivity activity);

}
