package com.jamal.materialtestproject.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.jamal.materialtestproject.Adapters.SmartphonesAdapter;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ExampleFragment extends BaseFragment {

    public static final String TAG = "ExampleFragment";
    private FloatingActionButton floatingButton;
    private RecyclerView recyclerView;


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

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLM = new LinearLayoutManager(getActivity());
        linearLM.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLM);

        SmartphonesAdapter adapter = new SmartphonesAdapter(generateDummyData(),getActivity());
        recyclerView.setAdapter(adapter);


        return view;
    }

    private List<SmartPhone> generateDummyData(){
        SmartPhone as1 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as2 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as3 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as4 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as5 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as6 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as7 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as8 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as9 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as10 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as11 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as12 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as13 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as14 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as15 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as16 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as17 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as18 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as19 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        SmartPhone as20 = new SmartPhone("Nexus 6",500.00,"5.0 Lollipop");
        List<SmartPhone> list = new ArrayList<>();
        list.add(as1);
        list.add(as2);
        list.add(as3);
        list.add(as4);
        list.add(as5);
        list.add(as6);
        list.add(as7);
        list.add(as8);
        list.add(as9);
        list.add(as10);
        list.add(as11);
        list.add(as12);
        list.add(as13);
        list.add(as14);
        list.add(as15);
        list.add(as16);
        list.add(as17);
        list.add(as18);
        list.add(as19);
        list.add(as20);
        return list;
    }

}
