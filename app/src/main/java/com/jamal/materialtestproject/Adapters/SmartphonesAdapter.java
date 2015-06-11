package com.jamal.materialtestproject.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by yamil.marques on 6/11/15.
 */
public class SmartphonesAdapter extends RecyclerView.Adapter<SmartphonesAdapter.SmartphonesViewHolder> {

    private List<SmartPhone> smartPhonesList;

    public SmartphonesAdapter(List<SmartPhone> smartPhones){
        this.smartPhonesList = smartPhones;
    }

    @Override
    public int getItemCount() {
        return smartPhonesList.size();
    }

    @Override
    public SmartphonesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_layout,viewGroup, false);
        return new SmartphonesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SmartphonesViewHolder smartphonesViewHolder, int i) {
        SmartPhone smartPhone = smartPhonesList.get(i);
        smartphonesViewHolder.tvModel.setText(smartPhone.getModel());
        smartphonesViewHolder.tvValue.setText("$"+smartPhone.getValue());
        smartphonesViewHolder.tvOS.setText(smartPhone.getOperativeSystem());
    }

    public static class SmartphonesViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvModel,tvValue,tvOS;

        public SmartphonesViewHolder(View v) {
            super(v);
            tvModel = (TextView)v.findViewById(R.id.tv_text1);
            tvOS = (TextView)v.findViewById(R.id.tv_text2);
            tvValue = (TextView)v.findViewById(R.id.tv_text3);
        }
    }

}
