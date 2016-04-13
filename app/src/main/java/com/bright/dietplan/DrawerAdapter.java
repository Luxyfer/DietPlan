package com.bright.dietplan;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 05/04/2016.
 */
public class DrawerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DrawerItem> navDrawerItems;
    private int pos = -1;

    public DrawerAdapter(Context context, ArrayList<DrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.drawer_layout, null);

        RelativeLayout layout = (RelativeLayout)convertView.findViewById(R.id.DR_Layout);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.DR_TNome);
        txtTitle.setTextColor(ContextCompat.getColor(context, R.color.white_color));
        txtTitle.setText(navDrawerItems.get(position).getTitle());

        ImageView img = (ImageView)convertView.findViewById(R.id.DR_Image);
        img.setImageResource(navDrawerItems.get(position).getWhite_icon());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity", "Test akjdsakj");
            }
        });

        if(position == pos)
            layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        else
            layout.setBackgroundResource(R.drawable.list);

        return convertView;
    }
    public void setPosition(int pos){
        this.pos = pos - 1;
    }
}