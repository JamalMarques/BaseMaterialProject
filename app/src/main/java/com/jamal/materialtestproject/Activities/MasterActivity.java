package com.jamal.materialtestproject.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yamil.marques on 6/17/15.
 */
public abstract class MasterActivity extends AppCompatActivity {
    public abstract void changeFragment(Fragment fragment,String tag,boolean addToBackStack);
}
