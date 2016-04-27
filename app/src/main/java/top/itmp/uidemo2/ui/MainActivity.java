package top.itmp.uidemo2.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import top.itmp.uidemo2.base.BaseActivity;

import top.itmp.uidemo2.R;
import top.itmp.uidemo2.utils.Dummy;
import top.itmp.uidemo2.views.PagerEnabledSlidingPaneLayout;

public class MainActivity extends BaseActivity {

    private PagerEnabledSlidingPaneLayout mPagerEnabledSlidingPaneLayout;
    private ListView mListView;
    private ViewPager mViewPager;
    private PagerTitleStrip mPagerTitleStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPagerEnabledSlidingPaneLayout = (PagerEnabledSlidingPaneLayout)findViewById(R.id.sliding_pane_layout);
        mListView = (ListView)findViewById(R.id.left_pane);
        //mFrameLayout = (FrameLayout)findViewById(R.id.context);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mPagerTitleStrip = (PagerTitleStrip)findViewById(R.id.titles);

        mPagerEnabledSlidingPaneLayout.setSliderFadeColor(ContextCompat.getColor(this, R.color.translucent));

        mListView.setAdapter(new SimpleAdapter(this, Dummy.dummyListMap("dummy"), android.R.layout.simple_list_item_1,
                new String[]{"dummy"}, new int[]{android.R.id.text1}));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        ColorPagerAdapter  colorPagerAdapter = new ColorPagerAdapter();
        colorPagerAdapter.add("Red", Color.RED);
        colorPagerAdapter.add("Green", Color.GREEN);
        colorPagerAdapter.add("Blue", Color.BLUE);
        mViewPager.setAdapter(colorPagerAdapter);
    }

    private static class ColorPagerAdapter extends PagerAdapter {
        private ArrayList<Pair<String, Integer>> mEntries = new ArrayList<>();

        public void add(String title, int color) {
            mEntries.add(new Pair(title, color));
        }

        @Override
        public int getCount() {
            return mEntries.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final View view = new View(container.getContext());
            view.setBackgroundColor(mEntries.get(position).second);

            // Unlike ListView adapters, the ViewPager adapter is responsible
            // for adding the view to the container.
            container.addView(view);

            return new ViewHolder(view, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // The adapter is also responsible for removing the view.
            container.removeView(((ViewHolder) object).view);
        }

        @Override
        public int getItemPosition(Object object) {
            return ((ViewHolder) object).position;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return ((ViewHolder) object).view == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mEntries.get(position).first;
        }

        private static class ViewHolder {
            final View view;
            final int position;

            public ViewHolder(View view, int position) {
                this.view = view;
                this.position = position;
            }
        }
    }
}
