package com.example.dashboard.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import retrofit2.Converter;

@Entity (tableName = "shopResponse")
public class ShopResponse  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "data")
    @TypeConverters(ShopTypeConverter.class)
    private List<Shop> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Shop> getData() {
        return data;
    }

    public void setData(List<Shop> data) {
        this.data = data;
    }

    public ShopResponse(int id, List<Shop> data) {
        this.id = id;
        this.data = data;
    }

    //    @SerializedName("data")
//    @Expose
//    private List<Shop> data = null;
//
//    public List<Shop> getData() {
//
//        return data;
//    }
//
//    public void setData(List<Shop> data)
//    {
//        this.data = data;
//    }
}
