package com.jamal.materialtestproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.view.WindowInsets;
import android.widget.TextView;

public class MainActivity extends Activity {

    private GridViewPager pager;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                //mTextView = (TextView) stub.findViewById(R.id.text);
                pager = (GridViewPager)stub.findViewById(R.id.gridViewPager);
                pager.setAdapter(new SimpleGridPageAdapter(getApplicationContext(),fragmentManager));
            }
        });
    }

}
