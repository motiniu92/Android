package com.example.dashboard.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dashboard.dao.ShopResponseDao;
import com.example.dashboard.model.ShopResponse;

@Database(entities = {ShopResponse.class}, version = 1)
public abstract class ShopResponseDatabase extends RoomDatabase {
    private static final String DB_NAME = "shopres_db";
    private static ShopResponseDatabase instance;

    public static synchronized ShopResponseDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ShopResponseDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract ShopResponseDao shopResponseDao();


//    AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
//            AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();

}
