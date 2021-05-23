package com.example.dashboard.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "shop")
public class Shop  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "shop_id")
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;

    @ColumnInfo(name = "shop_name")
    @SerializedName("shop_name")
    @Expose
    private String shopName;

    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @ColumnInfo(name = "logo")
    @SerializedName("logo")
    @Expose
    private String logo;

    @ColumnInfo(name = "distance")
    @SerializedName("distance")
    @Expose
    private String distance;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    @Expose
    private Integer rating;

    @ColumnInfo(name = "totalReviews")
    @SerializedName("totalReviews")
    @Expose
    private Integer totalReviews;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Shop(int id, Integer shopId, String shopName, String thumbnail, String logo, String distance, Integer rating, Integer totalReviews) {
        this.id = id;
        this.shopId = shopId;
        this.shopName = shopName;
        this.thumbnail = thumbnail;
        this.logo = logo;
        this.distance = distance;
        this.rating = rating;
        this.totalReviews = totalReviews;
    }
}
