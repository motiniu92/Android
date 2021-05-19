package com.example.modelview.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.modelview.ForApi.ApiInterface;
import com.example.modelview.Utils.AppConfig;
import com.example.modelview.model.ShopResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopRepository {

    private static final String TAG = ShopRepository.class.getSimpleName();
    private ApiInterface apiInterface;

    public ShopRepository() {
        apiInterface = AppConfig.getUserService();
    }

    public LiveData<ShopResponse> getShopDetails(){
        final MutableLiveData<ShopResponse> data = new MutableLiveData<>();
        apiInterface.getShopDetails()
                .enqueue(new Callback<ShopResponse>() {


                    @Override
                    public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                        Log.e(TAG, "onResponse response : " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.e(TAG, "shop total result : " + response.body().getData());
                            Log.e(TAG, "shop size : " + response.body().getData().size());
                            Log.e(TAG, "shop name : " + response.body().getData().get(0).getShopName());
                        }
                    }

                    @Override
                    public void onFailure(Call<ShopResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
