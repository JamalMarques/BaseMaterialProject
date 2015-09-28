package com.jamal.materialtestproject.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;

public class DeviceDetailActivity2 extends MasterActivity {

    private Toolbar toolbar;
    private SmartPhone device;
    private ImageView imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail2);

        if(getIntent().getExtras() != null) {
            if(getIntent().getExtras().getString(Constants.JSON_DEVICE) != null) {
                String smartphoneJson = getIntent().getExtras().getString(Constants.JSON_DEVICE);
                Gson gson = new Gson();
                Type type = new TypeToken<SmartPhone>(){}.getType();
                device = (SmartPhone) gson.fromJson(smartphoneJson,type);
            }
        }

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imag = (ImageView)findViewById(R.id.img);
        int resource;
        if(device.getOS() == Constants.OS_ANDROID){
            resource = R.drawable.ic_android_1;
        }else{
            resource = R.drawable.ic_apple_logo;
        }
        Picasso.with(this).load(resource).into(imag);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_device_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeFragment(Fragment fragment, String tag, boolean addToBackStack) {

    }
}
