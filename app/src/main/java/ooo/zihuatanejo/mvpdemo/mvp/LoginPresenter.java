package ooo.zihuatanejo.mvpdemo.mvp;

import okhttp3.ResponseBody;
import ooo.zihuatanejo.mvpdemo.mvp.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel loginModel;


    public LoginPresenter() {
        this.loginModel = new LoginModel();
    }


    public void login(String username, String password) {
        this.loginModel.login(username, password, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (getView() != null) {
                    getView().onLoginResult(response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
