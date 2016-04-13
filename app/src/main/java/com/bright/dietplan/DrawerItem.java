package com.bright.dietplan;

/**
 * Created by Luis on 05/04/2016.
 */
public class DrawerItem {

    private String title;
    private int white_icon;

    public DrawerItem(String title,int white_icon){
        this.title = title;
        this.white_icon = white_icon;
    }

    public String getTitle(){
        return this.title;
    }
    public int getWhite_icon(){
        return white_icon;
    }
    public void setTitle(String title){
        this.title = title;
    }

}