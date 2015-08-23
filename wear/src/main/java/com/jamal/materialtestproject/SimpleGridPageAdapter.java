package com.jamal.materialtestproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;
import android.util.Log;
import android.util.LruCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamal on 8/20/15.
 */
public class SimpleGridPageAdapter extends FragmentGridPagerAdapter {

    private static final int TRANSITION_DURATION_MILLIS = 100;

    private final Context context;
    private List<Row> rows;
    static final int[] BG_IMAGES = new int[]{
            R.drawable.background_1,
            R.drawable.background_2,
            R.drawable.background_3,
            R.drawable.background_4,
            R.drawable.background_5
    };
    private ColorDrawable defaultBg;
    private ColorDrawable clearBg;


    //Backgrounds---------------------
    LruCache<Integer, Drawable> rowBackgrounds = new LruCache<Integer, Drawable>(3) {
        @Override
        protected Drawable create(final Integer row) {
            int resid = BG_IMAGES[row % BG_IMAGES.length];
            new DrawableLoadingTask(context) {
                @Override
                protected void onPostExecute(Drawable result) {
                    TransitionDrawable background = new TransitionDrawable(new Drawable[]{ defaultBg, result});
                    rowBackgrounds.put(row, background);
                    background.startTransition(TRANSITION_DURATION_MILLIS);
                }
            }.execute(resid);
            return defaultBg;
        }
    };

    LruCache<Point, Drawable> pageBackgrounds = new LruCache<Point, Drawable>(3){
        @Override
        protected Drawable create(final Point page) {
            int resid;
            switch (page.y){
                case 1:
                    resid = BG_IMAGES[1];
                    break;
                case 2:
                    resid = BG_IMAGES[2];
                    break;
                case 3:
                    resid = BG_IMAGES[3];
                    break;
                case 4:
                    resid = BG_IMAGES[4];
                    break;
                default:
                    resid = BG_IMAGES[0];
                    break;
            }
            new DrawableLoadingTask(context){
                @Override
                protected void onPostExecute(Drawable result) {
                    TransitionDrawable background = new TransitionDrawable(new Drawable[]{clearBg,result});
                    pageBackgrounds.put(page,background);
                    notifyPageBackgroundChanged( page.y, page.x);
                    background.startTransition(TRANSITION_DURATION_MILLIS);
                }
            }.execute(resid);

            return GridPagerAdapter.BACKGROUND_NONE;
        }
    };
    //Backgrounds----------------------





    public SimpleGridPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

        defaultBg = new ColorDrawable(context.getResources().getColor(R.color.dark_grey));
        clearBg = new ColorDrawable(context.getResources().getColor(android.R.color.transparent));

        rows = new ArrayList<Row>();
        rows.add(new Row(createCardFragment("First card","This is the text of the first card")));
        rows.add(new Row(CustomPageFragment.getInstance("Second card", "This is a custom page used in the app", R.mipmap.ic_launcher)));
        rows.add(new Row(CustomPageFragment.getInstance("Third card", "This is a custom page used in the app", R.mipmap.ic_launcher),
                         CustomPageFragment.getInstance("Page details","Here we can put the page details that is contained in a new page. This will be showed swipong to left == Here we can put the page details that is contained in a new page. This will be showed swipong to left Here we can put the page details that is contained in a new page. This will be showed swipong to left Here we can put the page details that is contained in a new page. This will be showed swipong to left",R.mipmap.ic_launcher)));
    }


    @Override
    public Fragment getFragment(int row, int col) {
        Row adapterRow = rows.get(row);
        return adapterRow.getColumn(col);
    }

    @Override
    public Drawable getBackgroundForRow(int row) {
        return rowBackgrounds.get(row);
    }

    @Override
    public Drawable getBackgroundForPage(int row, int column) {
        return pageBackgrounds.get(new Point(column,row));
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount(int rowNum) {
        return rows.get(rowNum).getColumnCount();
    }


    private class Row{
        final List<Fragment> columns = new ArrayList<Fragment>();

        public Row(Fragment... fragments){
            for (Fragment f : fragments){
                columns.add(f);
            }
        }

        public Fragment getColumn(int position){
            return columns.get(position);
        }

        public int getColumnCount(){
            return columns.size();
        }
    }

    private Fragment createCardFragment(String title,String text){
        CardFragment fragment = CardFragment.create(title,text);
        //its possible to add some other stuffs here TODO
        return fragment;
    }

    public class DrawableLoadingTask extends AsyncTask<Integer, Void, Drawable>{
        private static final String TAG = "Loader";
        private Context context;

        public DrawableLoadingTask(Context context){
            this.context = context;
        }

        @Override
        protected Drawable doInBackground(Integer... params) {
            Log.d(TAG, "Loading asset 0x" + Integer.toHexString(params[0]));
            return context.getResources().getDrawable(params[0]);
        }
    }

}
