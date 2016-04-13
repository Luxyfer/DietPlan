package com.bright.dietplan;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager fragmentManager;

    // nav d
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray Icons;
    private ArrayList<DrawerItem> navDrawerItems;
    private DrawerAdapter adapter;
    private LayoutInflater inflater;
    private Toolbar toolbar;

    //utils
    int pos = -1;
    boolean back = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();
        mTitle = mDrawerTitle = getTitle();


        //Define home como pag principal
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        Icons = getResources().obtainTypedArray(R.array.icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawerList = (ListView) findViewById(R.id.navList_main);
        View header = inflater.inflate(R.layout.drawer_header_layout, mDrawerList, false);
        mDrawerList.addHeaderView(header);
        mDrawerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        navDrawerItems = new ArrayList<>();
        // Home
        navDrawerItems.add(new DrawerItem(navMenuTitles[0], Icons.getResourceId(0, -1)));
        // Timer
        navDrawerItems.add(new DrawerItem(navMenuTitles[1], Icons.getResourceId(1, -1)));
        //Routine
        navDrawerItems.add(new DrawerItem(navMenuTitles[2], Icons.getResourceId(2, -1)));
        //List
        navDrawerItems.add(new DrawerItem(navMenuTitles[3], Icons.getResourceId(3, -1)));
        //Profile
        navDrawerItems.add(new DrawerItem(navMenuTitles[4], Icons.getResourceId(4, -1)));
        //Tag
        // Recycle the typed array
        Icons.recycle();

        // setting the nav drawer list adapter
        adapter = new DrawerAdapter(this, navDrawerItems);
        //Activar home na drawer
        adapter.setPosition(1);
        mDrawerList.setAdapter(adapter);


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (pos != position)
                    adapter.setPosition(position);
                displayView(position);
                pos = position;
            }
        });

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.drawer_open,R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList.setSelection(0);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        /*MenuItem x = menu.findItem(R.id.action_add);
        if(x != null)
            x.setVisible(!drawerOpen);*/
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     */
    private void displayView(int position) {
        // update the main content by replacing fragmentsrl.setBackgroundResource(R.color.colorPrimaryDark);
        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new DailyFragment();
                break;
            case 3:
                fragment = new ProgressFragment();
                break;
            case 4:
                fragment = new RecipesFragment();
                break;
            case 5:
                fragment = new User();
                break;
            default:
                break;
        }

        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position - 1]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(mDrawerList);
            return;
        }
        if(back){
            super.onBackPressed();
            return;
        }
        back = true;
        Toast.makeText(this, getResources().getString(R.string.pressBack), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                back=false;
            }
        }, 2000);


    }
}
