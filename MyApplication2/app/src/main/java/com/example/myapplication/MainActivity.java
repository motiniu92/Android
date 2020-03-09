package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button displayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnection();

//        displayBtn = findViewById(R.id.displayBtn);
//        displayBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(findViewById(R.id.rootLayout),R.string.offline_message,Snackbar.LENGTH_LONG).show();
//            }
//        });

    }



    public void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                //Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(R.id.rootLayout), R.string.WifiMode_message, Snackbar.LENGTH_LONG).show();
            } else {
                //Toast.makeText(this, "Data Network Enabled", Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(R.id.rootLayout), R.string.dataNetworkMode_message, Snackbar.LENGTH_LONG).show();
            }

        } else {
            // Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            Snackbar.make(findViewById(R.id.rootLayout), R.string.offline_message, Snackbar.LENGTH_LONG).show();
        }
    }
}
