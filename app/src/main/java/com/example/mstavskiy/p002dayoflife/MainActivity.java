package com.example.mstavskiy.p002dayoflife;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.example.mstavskiy.tabsswipe.adapter.TabsPagerAdapter;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    private ViewPager mViewPager; // Глобальные переменные нужно писать с префиксом m
    private TabsPagerAdapter mAdapter;
    private ActionBar mActionBar;
    private ActionBar.Tab mTab1;
    private ActionBar.Tab mTab2;
    private final String FRAGMENT_1 = "Fragment 1";
    private final String FRAGMENT_2 = "Fragment 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initilization
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mActionBar = getSupportActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mTab1.select();
                        break;
                    case 1:
                        mTab2.select();
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mActionBar.setHomeButtonEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mTab1 = mActionBar.newTab();
        mTab1.setText(FRAGMENT_1);
        mTab1.setTabListener(this);
        mActionBar.addTab(mTab1);

        mTab2 = mActionBar.newTab();
        mTab2.setText(FRAGMENT_2);
        mTab2.setTabListener(this);
        mActionBar.addTab(mTab2);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        switch ((String)tab.getText()){
            case FRAGMENT_1:
                mViewPager.setCurrentItem(0);
                break;
            case FRAGMENT_2:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


}