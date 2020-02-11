package com.example.loginapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.loginapplication.R;
import com.example.loginapplication.forApi.ApiInterface;
import com.example.loginapplication.model.Users;
import com.example.loginapplication.utils.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText userNameET, passwordET;
    private Button loginBtn;
    private ApiInterface apiInterface;
    private List<Users> usersList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ProgressBar progressBar;
    private int login_id, cust_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        final String userName = userNameET.getText().toString();
        String password = passwordET.getText().toString();
        progressBar.setVisibility(View.VISIBLE);


        if (TextUtils.isEmpty(userName)) {
            userNameET.setError("Enter email or userName");
            progressBar.setVisibility(View.GONE);

        } else if (TextUtils.isEmpty(password)) {
            passwordET.setError("Enter password");
            progressBar.setVisibility(View.GONE);
        } else {
            Call<List<Users>> call = apiInterface.login(userName, password);
            call.enqueue(new Callback<List<Users>>() {
                @Override
                public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                    if (response.isSuccessful()) {
                        usersList = response.body();
                        login_id = (usersList.get(0)).getLogin_success();

                        if (login_id == 1) {
                            cust_id = (usersList.get(0)).getCustomer_id();
                            sharedPreferences = getSharedPreferences("Customer_Id", MODE_PRIVATE);
                            editor = sharedPreferences.edit();
                            editor.putInt("cust_id", cust_id);
                            editor.apply();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong Email and password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Users>> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


    private void init() {
        imageView = findViewById(R.id.imageViewId);
        userNameET = findViewById(R.id.userNameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        apiInterface = ApiUtils.getUserService();
        usersList = new ArrayList<>();
        progressBar = findViewById(R.id.progressBar);

    }
}
