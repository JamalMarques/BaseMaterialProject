package com.jamal.materialtestproject.Adapters;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.R;


import java.util.List;

/**
 * Created by yamil.marques on 6/11/15.
 */
public class SmartphonesAdapter extends RecyclerView.Adapter<SmartphonesAdapter.SmartphonesViewHolder>{

    private List<SmartPhone> smartPhonesList;
    private int lastPosition = -1;
    private Context context;

    public SmartphonesAdapter(List<SmartPhone> smartPhones,Context context){
        this.smartPhonesList = smartPhones;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return smartPhonesList.size();
    }

    @Override
    public SmartphonesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout,viewGroup, false);
        return new SmartphonesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SmartphonesViewHolder smartphonesViewHolder, final int position) {
        SmartPhone smartPhone = smartPhonesList.get(position);
        smartphonesViewHolder.tvModel.setText(smartPhone.getModel());
        smartphonesViewHolder.tvValue.setText("$"+smartPhone.getValue());
        smartphonesViewHolder.tvOS.setText(smartPhone.getOperativeSystem());

        smartphonesViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Pos: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        setAnimation(smartphonesViewHolder.main_view, position);
    }


    public static class SmartphonesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected TextView tvModel,tvValue,tvOS;
        protected View main_view;
        protected View.OnClickListener mListener;

        public SmartphonesViewHolder(View v) {
            super(v);
            tvModel = (TextView)v.findViewById(R.id.tv_text1);
            tvOS = (TextView)v.findViewById(R.id.tv_text2);
            tvValue = (TextView)v.findViewById(R.id.tv_text3);
            main_view = (View)v.findViewById(R.id.main_view);

            v.setOnClickListener(this);
        }

        public void setOnClickListener(View.OnClickListener mListener){
            this.mListener = mListener;
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v);
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
