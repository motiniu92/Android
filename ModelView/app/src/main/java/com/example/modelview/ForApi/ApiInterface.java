package com.example.modelview.ForApi;

import com.example.modelview.model.ShopResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

//    @GET("shops/search-location/51.658891/-0.399413/0")
//    Call<List<ShopResponse>> getShopDetails();

    @GET("shops/search-location/51.658891/-0.399413/0")
    Call<ShopResponse> getShopDetails();
}
