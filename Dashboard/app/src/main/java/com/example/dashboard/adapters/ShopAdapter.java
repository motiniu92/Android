package com.example.dashboard.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dashboard.R;
import com.example.dashboard.database.ShopResponseDatabase;
import com.example.dashboard.model.Shop;
import com.example.dashboard.model.ShopResponse;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context context;
    private List<Shop> shopResponses;
    private LayoutInflater mInflater;
    private ShopResponseDatabase shopResponseDatabase;


    // data is passed into the constructor
    public ShopAdapter(Context context, List<Shop> shopResponses) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.shopResponses = shopResponses;
        notifyDataSetChanged();

    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_offers_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shop shop=shopResponses.get(position);

        try {


            shopResponseDatabase = ShopResponseDatabase.getInstance(context);

            holder.titleTV.setText(shop.getShopName());
            holder.locationTV.setText(shop.getDistance() + " Miles");
            Log.e("SADAP", "Shop Name adapter ..." + shop.getShopName());
            holder.textiId.setText("Shop Id : "+shop.getShopId());

            Picasso.with(context).load(shop.getThumbnail()).placeholder(R.drawable.image1).into(holder.imageView);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {

        return shopResponses.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView titleTV, locationTV, textiId;



        ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTV = itemView.findViewById(R.id.titleTV);
            locationTV = itemView.findViewById(R.id.locationTV);
            textiId = itemView.findViewById(R.id.textiId);

        }



        //Picasso.with(context).load(shop.getThumbnail()).placeholder(R.drawable.shop_search2).into(featureIV);
        //Picasso.with(context).load(AppConfig.IMG_URL + shop.getLogo()).placeholder(R.mipmap.ic_launcher).into(logoCIV);





    }


}