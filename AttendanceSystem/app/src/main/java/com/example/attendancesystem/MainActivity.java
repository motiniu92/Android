package com.example.attendancesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendancesystem.ForApi.ApiInterface;
import com.example.attendancesystem.Models.UserAttendanceModel;
import com.example.attendancesystem.Utils.ApiUtils;
import com.example.attendancesystem.Utils.NetworkUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView nameTV, userIdTV, showListTV;
    private EditText nameET, userIdET;
    private Button btnSubmit;
    private ApiInterface api;
    private String latitude, longitude;
    private String uid, name, request_id;
    private UserAttendanceModel userAttendanceModel;
    public static final int MY_PERMISSION_REQUEST_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initViews();

        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);

            }else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            }
        }else {
            LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            try{
                latitude = String.valueOf(location.getLatitude());
                longitude = String.valueOf(location.getLongitude());

            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "NOT FOUND, TURN ON GPS", Toast.LENGTH_SHORT).show();
            }
        }



        showListTV.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        });


        btnSubmit.setOnClickListener(view -> {
            userAttendanceAndRegistration();
        });
    }

    private void userAttendanceAndRegistration() {

        uid = userIdET.getText().toString().trim();
        name = nameET.getText().toString().trim();


        if (name.equals("")) {
            nameET.requestFocus();
            Toast.makeText(MainActivity.this, "Name is required!", Toast.LENGTH_LONG).show();

        } else if (uid.equals("")) {
            userIdET.requestFocus();
            Toast.makeText(MainActivity.this, "UserId is required!", Toast.LENGTH_LONG).show();


        } else {

            if (NetworkUtility.isNetworkAvailable(getApplication())) {

                Call<UserAttendanceModel> call = api.getUserRegistrationAndAttendance(uid, name, latitude, longitude, request_id);
                call.enqueue(new Callback<UserAttendanceModel>() {
                    @Override
                    public void onResponse(@NonNull Call<UserAttendanceModel> call, @NonNull Response<UserAttendanceModel> response) {

                        if (response.isSuccessful()) {

                            try {

                                userAttendanceModel = response.body();
                                assert userAttendanceModel != null;
                                String status = userAttendanceModel.getStatus();

                                if (status.equals("200")) {
                                    Log.e("REG", "geting userRegistration Response ..." + userAttendanceModel.getName());

                                } else {

                                    Toast.makeText(MainActivity.this, userAttendanceModel.getMessage(), Toast.LENGTH_LONG).show();
                                }

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, getString(R.string.dataResponse), Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<UserAttendanceModel> call, @NonNull Throwable t) {
                        // Toast.makeText(MainActivity.this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();

                    }
                });


            } else {
                Toast.makeText(MainActivity.this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();
            }

        }


    }

    private void initViews() {
        nameTV = findViewById(R.id.nameTV);
        userIdTV = findViewById(R.id.userIdTV);
        nameET = findViewById(R.id.nameET);
        userIdET = findViewById(R.id.userIdET);
        btnSubmit = findViewById(R.id.btnSubmit);
        showListTV = findViewById(R.id.showListTV);
        api = ApiUtils.getUserService();

    }
}