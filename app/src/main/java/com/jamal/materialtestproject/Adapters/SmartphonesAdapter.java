package com.jamal.materialtestproject.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jamal.materialtestproject.Listeners.RecyclerViewListener;
import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by yamil.marques on 6/11/15.
 */
public class SmartphonesAdapter extends RecyclerView.Adapter<SmartphonesAdapter.SmartphonesViewHolder>{

    private List<SmartPhone> smartPhonesList;
    private int lastPosition = -1;
    private Context context;
    private RecyclerViewListener listener;

    public SmartphonesAdapter(List<SmartPhone> smartPhones,Context context){
        this.smartPhonesList = smartPhones;
        this.context = context;
    }

    public void setRecyclerListener(RecyclerViewListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return smartPhonesList.size();
    }

    @Override
    public SmartphonesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout,viewGroup, false);
        return new SmartphonesViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(SmartphonesViewHolder smartphonesViewHolder, final int position) {
        final SmartPhone smartPhone = smartPhonesList.get(position);
        smartphonesViewHolder.tvModel.setText(smartPhone.getModel());
        smartphonesViewHolder.tvValue.setText("$"+smartPhone.getValue());
        smartphonesViewHolder.tvOS.setText(smartPhone.getOperativeSystem());
        int resource;
        switch (smartPhone.getOS()){
            case Constants.OS_ANDROID:
                resource = R.drawable.ic_android_1;
                break;
            case Constants.OS_IOS:
                resource = R.drawable.ic_apple_logo;
                break;
            case Constants.OS_WINDOWS_MOBILE:
                resource = R.drawable.ic_android_1;
                break;
            default:
                resource = R.drawable.ic_android_1;
                break;
        }
        Picasso.with(context).load(resource)
                             .into(smartphonesViewHolder.img);

        setAnimation(smartphonesViewHolder.cardView, position);
    }


    public static class SmartphonesViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvModel,tvValue,tvOS;
        protected View main_view;
        protected ImageView img;
        protected CardView cardView;

        public SmartphonesViewHolder(View v, final RecyclerViewListener rListener) {
            super(v);
            tvModel = (TextView)v.findViewById(R.id.tv_text1);
            tvOS = (TextView)v.findViewById(R.id.tv_text2);
            tvValue = (TextView)v.findViewById(R.id.tv_text3);
            main_view = (View)v.findViewById(R.id.main_view);
            img = (ImageView)v.findViewById(R.id.img);
            cardView = (CardView)v.findViewById(R.id.card_view);

            if(rListener != null) {
                main_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rListener.recyclerViewItemClicked(v, getLayoutPosition());
                    }
                });
            }
        }
    }


    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left); //slide_in_left
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
