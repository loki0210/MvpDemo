package ooo.zihuatanejo.mvpdemo.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Login {
    @POST("/login")
    @FormUrlEncoded
    Call<ResponseBody> LoginToLocal(@Field("name") String name, @Field("password") String password);
}
