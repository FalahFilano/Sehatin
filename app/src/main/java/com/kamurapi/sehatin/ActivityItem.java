package com.kamurapi.sehatin;

import android.graphics.drawable.Drawable;

public class ActivityItem {


    private Drawable image;
    private String id;
    private String name,type,calorie,time,description,tips;

    public ActivityItem(String id, Drawable image, String name, String type, String calorie, String time, String description, String tips) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.type = type;
        this.calorie = calorie;
        this.time = time;
        this.description = description;
        this.tips = tips;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
