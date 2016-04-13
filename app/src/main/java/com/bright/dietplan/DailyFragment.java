package com.bright.dietplan;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Luis on 09/04/2016.
 */
public class DailyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_daily, container, false);



        TabsPagerAdapter adapter = new TabsPagerAdapter(getFragmentManager());
        ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(30);

        return rootView;
    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DayFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 61;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            DateFormat dateFormat = new SimpleDateFormat("dd / MM / yyyy");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, - 30 + position);
            if(position == 29)
                return getResources().getString(R.string.D_Yesterday);
            if(position == 30)
                return getResources().getString(R.string.D_Today);
            if(position == 31)
                return getResources().getString(R.string.D_Tomorrow);
            return dateFormat.format(cal.getTime());
        }
    }




}
