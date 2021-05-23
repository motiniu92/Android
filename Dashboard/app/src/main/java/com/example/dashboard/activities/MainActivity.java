package com.example.dashboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.dashboard.R;
import com.example.dashboard.fragments.Home;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction home = getSupportFragmentManager().beginTransaction();
        home.replace(R.id.fragment_container, new Home());
        home.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeId:
                // title.setText("Plumbing");
                startActivity(new Intent(MainActivity.this, HomeAcitivity.class));
                break;

//            case R.id.electricalId:
//                //title.setText("Electrical");
//                startActivity(new Intent(DashboardActivity.this, ShopActivity.class));
//                break;
//
//            case R.id.toolsId:
//                // title.setText("Tools");
//                startActivity(new Intent(DashboardActivity.this, ShopDetailsActivity.class));
//                break;
//
//            case R.id.sandCementAndAggregateId:
//                //title.setText("Sand, Cement & Aggregate");
//                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
//                break;
//
//            case R.id.fixingsId:
//                // title.setText("Fixings");
//                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
//                break;
//
//            case R.id.settingsId:
//                // title.setText("Settings");
//                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
//                break;
//
//            case R.id.loginId:
//                // title.setText("Login");
//                startActivity(new Intent(DashboardActivity.this, RegisterActivity.class));
//                break;
        }
        //drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}