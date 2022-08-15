package com.example.attendancesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.attendancesystem.Adapterrs.AttendanceAdapter;
import com.example.attendancesystem.ForApi.ApiInterface;
import com.example.attendancesystem.Models.AttendanceResponse;
import com.example.attendancesystem.Utils.ApiUtils;
import com.example.attendancesystem.Utils.NetworkUtility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    private ImageView backIV;
    private RecyclerView attendanceRecyclerview;
    private ApiInterface api;
    private AttendanceResponse attendanceResponseList;
    private AttendanceAdapter attendanceAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list);

        initViews();
        getUserAttendanceListData();

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this, MainActivity.class));
            }
        });


    }

    private void getUserAttendanceListData() {
        if (NetworkUtility.isNetworkAvailable(getApplication())) {


            Call<AttendanceResponse> call = api.getUserAttendanceListValue();
            call.enqueue(new Callback<AttendanceResponse>() {
                @Override
                public void onResponse(@NonNull Call<AttendanceResponse> call, @NonNull Response<AttendanceResponse> response) {
                    if (response.isSuccessful()) {

                        try {


                            if (response.body() == null) {
                                Log.e("TAG", "geting Data One..." + attendanceResponseList.getData().size());
                            } else {
                                attendanceResponseList = response.body();
                                Log.e("ATL", "geting Attendance list Data Size..." + attendanceResponseList.getData().size());
                                Log.e("ATL", "Gets User List Name : " + attendanceResponseList.getData().get(0).getName());


                                attendanceAdapter = new AttendanceAdapter(ListActivity.this, attendanceResponseList);
                                attendanceRecyclerview.setAdapter(attendanceAdapter);
                                attendanceAdapter.notifyDataSetChanged();


                            }

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    } else {

                        Toast.makeText(ListActivity.this, getString(R.string.dataResponse), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<AttendanceResponse> call, @NonNull Throwable t) {

                }
            });

        } else {
            Toast.makeText(ListActivity.this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();
        }
// end method

    }

    private void initViews() {
        attendanceRecyclerview = findViewById(R.id.listRecyclerview);
        api = ApiUtils.getUserService();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        attendanceRecyclerview.setLayoutManager(manager);
        attendanceRecyclerview.setHasFixedSize(true);


        backIV = findViewById(R.id.BackIV);

    }
}