package com.jamal.materialtestproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jamal.materialtestproject.Activities.DeviceDetailActivity;
import com.jamal.materialtestproject.Adapters.SmartphonesAdapter;
import com.jamal.materialtestproject.Listeners.RecyclerViewListener;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;

import java.util.ArrayList;

public class ExampleFragment extends BaseFragment {

    public static final String TAG = "ExampleFragment";
    private FloatingActionButton floatingButton;
    private RecyclerView recyclerView;
    private ArrayList<SmartPhone> smartPhonesList;


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

        smartPhonesList = generateDummyData();
        final SmartphonesAdapter adapter = new SmartphonesAdapter(smartPhonesList,getActivity());
        adapter.setRecyclerListener(new RecyclerViewListener() {
            @Override
            public void recyclerViewItemClicked(View v, int position) {
                Intent intent = new Intent(getActivity(), DeviceDetailActivity.class);
                intent.putExtra(Constants.JSON_DEVICE,new Gson().toJson(smartPhonesList.get(position)));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(getActivity(),"ON MOVE!",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                adapter.removeItem(position);
                //Toast.makeText(getActivity(),"swiped!",Toast.LENGTH_SHORT).show();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }

    private ArrayList<SmartPhone> generateDummyData(){
        SmartPhone as1 = new SmartPhone("Nexus 6",500.00,"5.1.1 Lollipop", Constants.OS_ANDROID);
        SmartPhone as2 = new SmartPhone("Nexus 5",500.00,"5.1.1 Lollipop",Constants.OS_ANDROID);
        SmartPhone as3 = new SmartPhone("Nexus 4",500.00,"5.1.1 Lollipop",Constants.OS_ANDROID);
        SmartPhone as4 = new SmartPhone("Iphone 6 plus",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as5 = new SmartPhone("Iphone 6",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as6 = new SmartPhone("Iphone 5s",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as7 = new SmartPhone("Iphone 5",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as8 = new SmartPhone("Nexus 4s",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as9 = new SmartPhone("Nexus 4",500.00,"iOS 8",Constants.OS_IOS);
        SmartPhone as10 = new SmartPhone("Galaxy s6 edge",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as11 = new SmartPhone("Galaxy s6",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as12 = new SmartPhone("Galaxy s5",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as13 = new SmartPhone("Galaxy s4",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as14 = new SmartPhone("Moto X 2gen",500.00,"5.1 Lollipop",Constants.OS_ANDROID);
        SmartPhone as15 = new SmartPhone("Moto X",500.00,"4.4 Kitkat",Constants.OS_ANDROID);
        SmartPhone as16 = new SmartPhone("Moto G 2gen",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as17 = new SmartPhone("Sony Z4",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as18 = new SmartPhone("HTC One M9",500.00,"5.0 Lollipop",Constants.OS_ANDROID);
        SmartPhone as19 = new SmartPhone("Nexus 7",500.00,"5.1.1 Lollipop",Constants.OS_ANDROID);
        SmartPhone as20 = new SmartPhone("Nexus 9",500.00,"5.1.1 Lollipop",Constants.OS_ANDROID);
        ArrayList<SmartPhone> list = new ArrayList<>();
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
