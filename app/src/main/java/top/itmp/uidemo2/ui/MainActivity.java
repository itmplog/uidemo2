package top.itmp.uidemo2.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import top.itmp.uidemo2.base.BaseActivity;

import top.itmp.uidemo2.R;
import top.itmp.uidemo2.utils.Dummy;

public class MainActivity extends BaseActivity {

    private SlidingPaneLayout mSlidingPaneLayout;
    private ListView mListView;
    private FrameLayout mFrameLayout;
    private ViewPager mViewPager;
    private PagerTitleStrip mPagerTitleStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingPaneLayout = (SlidingPaneLayout)findViewById(R.id.sliding_pane_layout);
        mListView = (ListView)findViewById(R.id.left_pane);
        //mFrameLayout = (FrameLayout)findViewById(R.id.context);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mPagerTitleStrip = (PagerTitleStrip)findViewById(R.id.titles);

        mSlidingPaneLayout.setSliderFadeColor(ContextCompat.getColor(this, R.color.translucent));
        mSlidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelOpened(View panel) {

            }

            @Override
            public void onPanelClosed(View panel) {

            }
        });

        mListView.setAdapter(new SimpleAdapter(this, Dummy.dummyListMap("dummy"), android.R.layout.simple_list_item_1,
                new String[]{"dummy"}, new int[]{android.R.id.text1}));
    }
}
