package com.jamal.materialtestproject.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.R;

/**
 * Created by yamil.marques on 6/16/15.
 */
public class ExampleDetailFragment extends BaseFragment {

    public static final String TAG = "ExampleDetailFragment";

    @Override
    public String getFragmentTag() {
        return TAG;
    }

    public ExampleDetailFragment getInstance(SmartPhone smartPhone){
        ExampleDetailFragment frag = new ExampleDetailFragment();
        Bundle bun = new Bundle();
        //TODO convert to JSON
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_example_detail,container,false);

        return rootView;
    }
}
