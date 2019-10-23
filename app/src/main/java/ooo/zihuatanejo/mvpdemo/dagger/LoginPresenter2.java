package ooo.zihuatanejo.mvpdemo.dagger;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

 class LoginPresenter2 {
    private ICommonView view;

    @Inject
     LoginPresenter2(ICommonView view) {
        this.view = view;
    }

     void login(User user) {
        Context mContext = view.getContext();
        Toast.makeText(mContext, "login...", Toast.LENGTH_SHORT).show();
    }
}
