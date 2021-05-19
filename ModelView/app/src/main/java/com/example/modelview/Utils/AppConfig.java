package com.example.modelview.Utils;


import com.example.modelview.ForApi.ApiClient;
import com.example.modelview.ForApi.ApiInterface;

public class AppConfig {

    public static String BASE_URL = "https://building.cwprojects.xyz/api/v1/";
    public static String IMG_URL = "https://building.cwprojects.xyz/public/";
    public static String ASSET_URL = "https://building.cwprojects.xyz/public/";


    public static ApiInterface getUserService() {
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
