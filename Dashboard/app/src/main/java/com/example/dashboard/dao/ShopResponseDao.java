package com.example.dashboard.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dashboard.model.ShopResponse;

import java.util.List;

@Dao
public interface ShopResponseDao {


    @Query("SELECT * FROM shopResponse")
    ShopResponse getShopResponseList();

    @Insert
    void insert(ShopResponse shopResponse);

//    @Delete
//    void delete(Task task);
//
//    @Update
//    void update(Task task);
}
