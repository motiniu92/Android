package com.example.attendancesystem.ForApi;


import com.example.attendancesystem.Models.AttendanceResponse;
import com.example.attendancesystem.Models.UserAttendanceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    // http://128.199.215.102:4040/api/attendanceRequest

    @POST("/api/attendanceRequest")
    Call<UserAttendanceModel> getUserRegistrationAndAttendance(
            @Query("uid") String uid,
            @Query("name") String name,
            @Query("latitude") String latitude,
            @Query("longitude") String longitude,
            @Query("request_id") String request_id


    );


    // http://128.199.215.102:4040/api/stores
    @GET("/api/stores")
    Call<AttendanceResponse> getUserAttendanceListValue();




    // Ending the class
}
