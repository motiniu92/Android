package com.example.loginapplication.utils;

import com.example.loginapplication.forApi.ApiInterface;
import com.example.loginapplication.forApi.RetrofitClient;

public class ApiUtils {

    public static final String BASE_URL = "https://zhomprass.com/app1/api/";

 public static ApiInterface getUserService(){
     return RetrofitClient.getRetrofit(BASE_URL).create(ApiInterface.class);

 }
}
