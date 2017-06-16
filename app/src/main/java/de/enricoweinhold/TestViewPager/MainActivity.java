package de.enricoweinhold.TestViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

    /**
     * The number of page to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * View to contain the dots
     */
    private ViewGroup mDotsLayout;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDotsLayout = (ViewGroup) findViewById(R.id.dots);

        drawDots(0);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                drawDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * Adds dots to the Linearlayout according to the position of the ViewPager
     */
    private void drawDots(int position){
        mDotsLayout.removeAllViews();
        for (int i = 0; i < NUM_PAGES; i++){
            if (i == position) {
                ImageView dotDark = new ImageView(this);
                dotDark.setImageResource(R.drawable.dot_dark);
                dotDark.setPadding(2,0,0,0);
                mDotsLayout.addView(dotDark);
            } else {
                ImageView dotLight = new ImageView(this);
                dotLight.setImageResource(R.drawable.dot_light);
                dotLight.setPadding(2,0,0,0);
                mDotsLayout.addView(dotLight);
            }
        }
    }

    /**
     * A simple pager adapter that represents 5 SlideFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SlideFragment slideFragment = new SlideFragment();

            //put the position of the adapter as page number to the argument
            Bundle bundle = new Bundle();
            bundle.putInt("PAGENUMBER", position);
            slideFragment.setArguments(bundle);

            return slideFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
