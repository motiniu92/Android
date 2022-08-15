package com.example.attendancesystem.Utils;


import com.example.attendancesystem.ForApi.ApiInterface;
import com.example.attendancesystem.ForApi.RetrofitClient;

public class ApiUtils {

    public static final String BASE_URL = "http://128.199.215.102:4040";



    public static ApiInterface getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }




}
