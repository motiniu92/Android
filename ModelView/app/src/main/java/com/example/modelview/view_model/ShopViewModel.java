package com.example.modelview.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.modelview.model.ShopResponse;
import com.example.modelview.repository.ShopRepository;

public class ShopViewModel extends AndroidViewModel {

    private ShopRepository shopRepository;
    private LiveData<ShopResponse> shopResponseLiveData;

    public ShopViewModel(@NonNull Application application) {
        super(application);

        shopRepository = new ShopRepository();
        this.shopResponseLiveData = shopRepository.getShopDetails();
    }




    public LiveData<ShopResponse> getShopResponseLiveData() {
        return shopResponseLiveData;
    }
}
