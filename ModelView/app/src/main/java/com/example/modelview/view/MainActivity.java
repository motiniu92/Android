package com.example.modelview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.modelview.R;
import com.example.modelview.adapters.ShopAdapter;
import com.example.modelview.model.Shop;
import com.example.modelview.view_model.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView my_recycler_view;
    private LinearLayoutManager layoutManager;
    private ShopAdapter adapter;
    private ArrayList<Shop> shopArrayList = new ArrayList<>();
    ShopViewModel shopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getShopData();
    }

    private void initialization() {

        my_recycler_view = (RecyclerView) findViewById(R.id.shopListRecyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);

        adapter = new ShopAdapter(MainActivity.this, shopArrayList);
        my_recycler_view.setAdapter(adapter);
        shopViewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
    }


    private void getShopData() {
        shopViewModel.getShopResponseLiveData().observe(this, shopResponse -> {
            if (shopResponse != null) {

                List<Shop> shops = shopResponse.getData();
                shopArrayList.addAll(shops);
                adapter.notifyDataSetChanged();
            }
        });
    }
}