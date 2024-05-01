package com.example.mytestlogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("login?")
    Call<ResponseBody> userLogin(@Field("phone") String phone,
                                 @Field("password") String password);
}
