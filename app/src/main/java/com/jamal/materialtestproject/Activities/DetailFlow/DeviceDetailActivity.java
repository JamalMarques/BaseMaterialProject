package com.jamal.materialtestproject.Activities.DetailFlow;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jamal.materialtestproject.Activities.MasterActivity;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;
import com.squareup.picasso.Picasso;

public class DeviceDetailActivity extends MasterActivity {

    protected Toolbar toolbar;
    protected FrameLayout frameLayout;
    protected SmartPhone smartPhone;
    protected ImageView imageView;
    protected int imgResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent().getExtras().getString(Constants.JSON_DEVICE) != null){
            String json = getIntent().getExtras().getString(Constants.JSON_DEVICE);
            smartPhone = new Gson().fromJson(json,SmartPhone.class);
        }

        imageView = (ImageView)findViewById(R.id.imageView);
        switch (smartPhone.getOS()){
            case Constants.OS_ANDROID:
                imgResource = R.drawable.ic_android_1;
                break;
            case Constants.OS_IOS:
                imgResource = R.drawable.ic_apple_logo;
                break;
            case Constants.OS_WINDOWS_MOBILE:
                imgResource = R.drawable.ic_android_1;
                break;
            default:
                imgResource = R.drawable.ic_android_1;
                break;
        }

        ViewCompat.setTransitionName(imageView,getString(R.string.transition_1));
        //Picasso.with(this).load(resource).fit().into(imageView);
        loadImage();
        
    }

    private void loadImage(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()) {
            loadThumbnailImage();
        } else {
            loadFullSizeImage();
        }
    }

    private void loadThumbnailImage(){
        Picasso.with(this)
                .load(imgResource)
                .noFade()
                .into(imageView);
    }

    private void loadFullSizeImage(){
        Picasso.with(this)
                .load(imgResource)
                .noFade()
                .noPlaceholder()
                .into(imageView);
    }

    private boolean addTransitionListener(){
        final Transition transition = getWindow().getSharedElementEnterTransition();
        if (transition != null) {
            // There is an entering shared element transition so add a listener to it
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionEnd(Transition transition) {
                    // As the transition has ended, we can now load the full-size image
                    loadFullSizeImage();
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }
                @Override
                public void onTransitionStart(Transition transition) {
                    // No-op
                }
                @Override
                public void onTransitionCancel(Transition transition) {
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }
                @Override
                public void onTransitionPause(Transition transition) {
                    // No-op
                }
                @Override
                public void onTransitionResume(Transition transition) {
                    // No-op
                }
            });
            return true;
        }
        // If we reach here then we have not added a listener
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
