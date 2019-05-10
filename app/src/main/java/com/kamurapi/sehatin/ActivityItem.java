package com.kamurapi.sehatin;

import android.graphics.drawable.Drawable;

public class ActivityItem {


    private Drawable image;
    private String name,type,calorie,time;

    public ActivityItem(Drawable image, String name, String type, String calorie, String time) {
        this.image = image;
        this.name = name;
        this.type = type;
        this.calorie = calorie;
        this.time = time;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
