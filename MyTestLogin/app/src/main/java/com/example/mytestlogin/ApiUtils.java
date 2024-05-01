package com.example.mytestlogin;

public class ApiUtils {
    public static final String BASE_URL = "https://babsaye.com/api/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
