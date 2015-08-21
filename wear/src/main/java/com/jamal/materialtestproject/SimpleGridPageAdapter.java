package com.jamal.materialtestproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.support.wearable.view.FragmentGridPagerAdapter;

import java.util.List;

/**
 * Created by Jamal on 8/20/15.
 */
public class SimpleGridPageAdapter extends FragmentGridPagerAdapter {

    private static final int TRANSITION_DURATION_MILLIS = 100;

    private final Context context;
    private List<Keyboard.Row> mRows;

    public SimpleGridPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getFragment(int i, int i1) {
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount(int i) {
        return 0;
    }
}
