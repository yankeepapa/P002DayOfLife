package com.example.mstavskiy.p002dayoflife;



import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.example.mstavskiy.tabsswipe.adapter.TabsPagerAdapter;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    private ViewPager mViewPager; // Глобальные переменные нужно писать с префиксом m
    private TabsPagerAdapter mAdapter;
    private ActionBar mActionBar;
    private final String FRAGMENT_1 = "Main";
    private final String FRAGMENT_2 = "List";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initilization
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mActionBar = getSupportActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);
        mActionBar.setHomeButtonEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = mActionBar.newTab();
        tab1.setText(FRAGMENT_1);
        tab1.setTabListener(this);
        mActionBar.addTab(tab1);

        ActionBar.Tab tab2 = mActionBar.newTab();
        tab2.setText(FRAGMENT_2);
        tab2.setTabListener(this);
        mActionBar.addTab(tab2);



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