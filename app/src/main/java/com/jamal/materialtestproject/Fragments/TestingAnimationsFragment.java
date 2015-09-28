package com.jamal.materialtestproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamal.materialtestproject.R;

/**
 * Created by Jamal on 9/20/15.
 */
public class TestingAnimationsFragment extends BaseFragment {

    @Override
    public String getFragmentTag() {
        return "TestingAnimationsFragment";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_testing_animations, container, false);

        return view;
    }
}
