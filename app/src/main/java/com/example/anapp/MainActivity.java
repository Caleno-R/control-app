package com.example.anapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout layoutLimit,layoutAppBlocker,layoutLocation,layoutBedBlocker;
    private RelativeLayout layoutAppLog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        layoutLimit= findViewById(R.id.layout_usage);
        layoutAppBlocker=findViewById(R.id.layout_appBlocker);
        layoutLocation=findViewById(R.id.layout_childLocation);
        layoutBedBlocker=findViewById(R.id.layout_bedBlocker);
        layoutAppLog=findViewById(R.id.layout_appLog);
        layoutLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UsageLimitActivity.class);
                startActivity(i);
            }
        });
        layoutAppBlocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AppBlockerActivity.class);
                startActivity(i);
            }
        });
        layoutBedBlocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,BedBlockerActivity.class);
                startActivity(i);
            }
        });
        layoutLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ChildLocationActivity.class);
                startActivity(i);
            }
        });
        layoutAppLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AppLogActivity.class);
                startActivity(i);
            }
        });




        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_children:
               Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
                break;

            case R.id.nav_parent:
                //Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
               // startActivity(intent);
                break;
            case R.id.nav_account:
                //Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                // startActivity(intent);
                break;
            case R.id.nav_help:
                //Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                // startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}