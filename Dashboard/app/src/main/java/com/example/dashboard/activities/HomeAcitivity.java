package com.example.dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dashboard.ForApi.ApiInterface;
import com.example.dashboard.R;
import com.example.dashboard.Utils.AppConfig;
import com.example.dashboard.adapters.ShopAdapter;
import com.example.dashboard.database.ShopResponseDatabase;
import com.example.dashboard.model.Shop;
import com.example.dashboard.model.ShopResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAcitivity extends AppCompatActivity {
    private ApiInterface api;
    private ShopResponse shopResponses;
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private ShopResponseDatabase shopResponseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);

        initViews();
        getShopData();


    }
    private ShopResponse shopResponses1;

    private void getShopData() {

        if (isNetworkConnected()){
            Call<ShopResponse> call = api.getShopDetails();
            call.enqueue(new Callback<ShopResponse>() {
                @Override
                public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                    Log.e("SDHA", "Shop Data ..." + response.body().getData().size());
                    try {
                        //mCallback.onShopLoaded(response.body().getData().get(0));
                        shopResponses1 = response.body();
                        Log.e("SDHA", "Shop Name ..." + response.body().getData().get(0).getShopName());
                        shopResponseDatabase.shopResponseDao().insert(shopResponses1);

                        shopResponses = shopResponseDatabase.shopResponseDao().getShopResponseList();

                        shopResponses.getData().clear();
                        shopResponses.setData(shopResponseDatabase.shopResponseDao().getShopResponseList().getData());
                        //Log.e("SDHA", "Save data in database ..." + response.body().getData().get(0).getShopName());
                        Log.e("SDHA", "Save data in database ..." + shopResponses.getData().get(0).getShopName());

                        shopAdapter = new ShopAdapter(getApplicationContext(), shopResponses.getData());

                        shopAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(shopAdapter);

                    } catch (Exception e) {
                        Log.e("Exception", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<ShopResponse> call, Throwable t) {
                    //  mCallback.onShopLoadError();
                    t.printStackTrace();
                }
            });
        }else {
            if (shopResponseDatabase.shopResponseDao().getShopResponseList()!=null){
                shopResponses = shopResponseDatabase.shopResponseDao().getShopResponseList();

                shopResponses.getData().clear();
                shopResponses.setData(shopResponseDatabase.shopResponseDao().getShopResponseList().getData());
                Log.e("SDHA", "size ..." + shopResponses.getData().size());

                shopAdapter = new ShopAdapter(getApplicationContext(), shopResponses.getData());
                shopAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(shopAdapter);
            }else {
                Log.e("SDHA", "data not available ..." + "no data found");

            }

        }


    }

    private void initViews() {
        //shopResponses = new ArrayList<>();
        api = AppConfig.getUserService();
        recyclerView = findViewById(R.id.bestOffersRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        //manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        shopResponseDatabase = ShopResponseDatabase.getInstance(this);
        //shopResponses = shopResponseDatabase.shopResponseDao().getShopResponseList();







    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}