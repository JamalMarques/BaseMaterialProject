package com.jamal.materialtestproject.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jamal.materialtestproject.Models.SmartPhone;
import com.jamal.materialtestproject.Others.Constants;
import com.jamal.materialtestproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jamal on 6/28/15.
 */
public class SmartphonesListAdapter extends ArrayAdapter<SmartPhone> {


    public SmartphonesListAdapter(Context context, int resource, List<SmartPhone> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        SmartphonesViewHolder holder;

        if(rootView == null){
            holder = new SmartphonesViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = layoutInflater.inflate(R.layout.card_layout,parent,false);
            holder.tvModel = (TextView)rootView.findViewById(R.id.tv_text1);
            holder.tvOS = (TextView)rootView.findViewById(R.id.tv_text2);
            holder.tvValue = (TextView)rootView.findViewById(R.id.tv_text3);
            holder.main_view = (View)rootView.findViewById(R.id.main_view);
            holder.img = (ImageView)rootView.findViewById(R.id.img);
            holder.cardView = (CardView)rootView.findViewById(R.id.card_view);
            rootView.setTag(holder);
        }else{
            holder = (SmartphonesViewHolder)rootView.getTag();
        }

        holder.tvModel.setText(getItem(position).getModel());
        holder.tvOS.setText(getItem(position).getOperativeSystem());
        holder.tvValue.setText("$"+getItem(position).getValue().toString());
        int resource;
        switch (getItem(position).getOS()){
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
        Picasso.with(getContext()).load(resource)
                .into(holder.img);

        return rootView;
    }

    public static class SmartphonesViewHolder{

        public TextView tvModel,tvValue,tvOS;
        public View main_view;
        public ImageView img;
        public CardView cardView;
    }
}
