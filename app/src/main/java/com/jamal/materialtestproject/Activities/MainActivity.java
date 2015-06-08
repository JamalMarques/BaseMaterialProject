package com.jamal.materialtestproject.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jamal.materialtestproject.Fragments.BaseFragment;
import com.jamal.materialtestproject.Fragments.ExampleFragment;
import com.jamal.materialtestproject.R;

/*
* Stuffs to do
* Set title method on the fragments (toolbar title)
* Generate a dinamic base textStyle (Normal text and style for title and white text)
* 
*/


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    //Drawer stuffs
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        navView = (NavigationView)findViewById(R.id.navigation_view);
        if(navView != null){
            setUpDrawContent(navView);
        }

        ExampleFragment exFragment = ExampleFragment.getInstance();
        changeFragment(exFragment, exFragment.getFragmentTag());

    }

    private void setUpDrawContent(NavigationView navView){
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.button2bar:
                Intent intent = new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(Fragment frag,String tag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameMainLayout, frag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

}