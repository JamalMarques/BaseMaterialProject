package com.jamal.materialtestproject.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jamal.materialtestproject.Activities.MasterActivity;
import com.jamal.materialtestproject.Adapters.SmartphonesAdapter;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;

import java.lang.reflect.Type;

public class DeviceDetailActivity extends MasterActivity {

    private SmartPhone device;
    private Button button1,buttonTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        if(getIntent().getExtras() != null) {
            if(getIntent().getExtras().getString(Constants.JSON_DEVICE) != null) {
                String smartphoneJson = getIntent().getExtras().getString(Constants.JSON_DEVICE);
                Gson gson = new Gson();
                Type type = new TypeToken<SmartPhone>(){}.getType();
                device = (SmartPhone) gson.fromJson(smartphoneJson,type);
            }
        }

        button1 = (Button)findViewById(R.id.button);
        buttonTouch = (Button)findViewById(R.id.touchit);
        buttonTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= 21) {

                    if(button1.getVisibility() == View.INVISIBLE) {
                        // get the center for the clipping circle
                        int cx = (button1.getLeft() + button1.getRight()) / 2;
                        int cy = (button1.getTop() + button1.getBottom()) / 2;
                        // get the final radius for the clipping circle
                        int finalRadius = Math.max(button1.getWidth(), button1.getHeight());

                        // create the animator for this view (the start radius is zero)
                        Animator anim = ViewAnimationUtils.createCircularReveal(button1, cx, cy, 0, finalRadius);
                        // make the view visible and start the animation
                        button1.setVisibility(View.VISIBLE);
                        anim.start();
                    }else {
                        // get the center for the clipping circle
                        int cx = (button1.getLeft() + button1.getRight()) / 2;
                        int cy = (button1.getTop() + button1.getBottom()) / 2;
                        // get the initial radius for the clipping circle
                        int initialRadius = button1.getWidth();
                        // create the animation (the final radius is zero)
                        Animator anim = ViewAnimationUtils.createCircularReveal(button1, cx, cy, initialRadius, 0);
                        // make the view invisible when the animation is done
                        anim.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                button1.setVisibility(View.INVISIBLE);
                            }
                        });
                        // start the animation
                        anim.start();
                    }

                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeFragment(Fragment fragment, String tag, boolean addToBackStack) {

    }
}