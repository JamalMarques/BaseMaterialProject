package com.jamal.materialtestproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by Jamal on 8/20/15.
 */
public class CustomPageFragment extends Fragment {

    public static CustomPageFragment getInstance(String title, String text, int drawableId){
        CustomPageFragment frag = new CustomPageFragment();
        Bundle bun = new Bundle();
        bun.putString(Constants.TITLE,title);
        bun.putString(Constants.TEXT,text);
        bun.putInt(Constants.DRAWABLEID, drawableId);
        frag.setArguments(bun);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_page_frag_layout,container,false);

        String title = getArguments().getString(Constants.TITLE);
        String text = getArguments().getString(Constants.TEXT);
        int drawableId = getArguments().getInt(Constants.DRAWABLEID);

        TextView tvTitle = (TextView)view.findViewById(R.id.title);
        TextView tvText = (TextView)view.findViewById(R.id.text);
        ImageView imgView = (ImageView)view.findViewById(R.id.img);
        tvTitle.setText(title);
        tvText.setText(text);
        Picasso.with(getActivity()).load(drawableId).into(imgView);

        return view;
    }
}
