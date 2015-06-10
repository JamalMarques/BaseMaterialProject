package com.jamal.materialtestproject.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamal.materialtestproject.R;

public class ExampleFragment extends BaseFragment {

    public static final String TAG = "ExampleFragment";
    private FloatingActionButton floatingButton;


    public String getFragmentTag(){
        return TAG;
    }

    public static ExampleFragment getInstance(){
        ExampleFragment frag = new ExampleFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);

        //Do stuffs
        floatingButton = (FloatingActionButton)view.findViewById(R.id.floating_button);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.snackbar_example), Snackbar.LENGTH_SHORT)
                        .setAction("Action1", null)
                        .setAction("Action2", null).show();
            }
        });

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("hellohello");

        return view;
    }

}
