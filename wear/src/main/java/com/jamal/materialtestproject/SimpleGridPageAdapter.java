package com.jamal.materialtestproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.FragmentGridPagerAdapter;

/**
 * Created by Jamal on 8/20/15.
 */
public class SimpleGridPageAdapter extends FragmentGridPagerAdapter {

    public SimpleGridPageAdapter(FragmentManager fm) {
        super(fm);
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
