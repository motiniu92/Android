package com.example.loginapplication.forApi;

import com.example.loginapplication.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("login_api.php")
    Call<List<Users>> login(@Query("login_success") String login_success,
                            @Query("customer_id") String customer_id);
}
