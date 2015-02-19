package com.example.mstavskiy.p002dayoflife;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.mstavskiy.tabsswipe.adapter.TabsPagerAdapter;

public class MainActivity extends FragmentActivity  {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Fragment1", "Fragment2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(new TabListener<>(this,"Tab 1", Fragment1.class));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(new TabListener<>(this,"Tab 2", Fragment2.class));
        actionBar.addTab(tab2);

        if (savedInstanceState != null) {
            int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
            getActionBar().setSelectedNavigationItem(savedIndex);
        }


   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(new TabListener<Fragment1>(this,"Tab 1", Fragment1.class));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(new TabListener<Fragment2>(this,"Tab 2", Fragment2.class));
        actionBar.addTab(tab2);

        if (savedInstanceState != null) {
            int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
            getActionBar().setSelectedNavigationItem(savedIndex);
        }

    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SAVED_INDEX", getActionBar().getSelectedNavigationIndex());

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    }
}