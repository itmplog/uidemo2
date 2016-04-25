package top.itmp.uidemo2.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import top.itmp.uidemo2.base.BaseActivity;

import top.itmp.uidemo2.R;

public class MainActivity extends BaseActivity {

    private SlidingPaneLayout mSlidingPaneLayout;
    private ListView mListView;
    private FrameLayout mFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingPaneLayout = (SlidingPaneLayout)findViewById(R.id.sliding_pane_layout);
        mListView = (ListView)findViewById(R.id.left_pane);
        mFrameLayout = (FrameLayout)findViewById(R.id.context);

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
    }
}
