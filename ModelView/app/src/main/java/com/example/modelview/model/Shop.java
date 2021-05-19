package com.example.modelview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shop {

    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("rating")
    @Expose
    private Integer rating;
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

    public Shop(Integer shopId, String shopName, String thumbnail, String logo, String distance, Integer rating, Integer totalReviews) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.thumbnail = thumbnail;
        this.logo = logo;
        this.distance = distance;
        this.rating = rating;
        this.totalReviews = totalReviews;
    }

}
