package com.example.mstavskiy.p002dayoflife;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabListener<T extends Fragment>
        implements ActionBar.TabListener {
    private final Activity activity;
    private final String tag;
    private final Class<T> cls;

    public TabListener(Activity parentActivity, String tag, Class<T> cls) {
        this.activity = parentActivity;
        this.tag = tag;
        this.cls = cls;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction transaction) {
        Fragment fragment = activity.getFragmentManager().findFragmentByTag(tag);


        if (fragment == null) {
            fragment = Fragment.instantiate (activity, cls.getName());
            transaction.add(android.R.id.content, fragment, tag);


        } else
        {
            transaction.attach(fragment);

        }
    }

    @Override
    public void onTabUnselected (ActionBar.Tab tab, FragmentTransaction transaction){
        Fragment fragment = activity.getFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.detach(fragment);

        }
    }

    @Override
    public void onTabReselected (Tab tab, FragmentTransaction transaction){}
}
