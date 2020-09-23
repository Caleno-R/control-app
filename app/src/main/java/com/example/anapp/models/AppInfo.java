package com.example.anapp.models;

public class AppInfo {
    private String appName;
    private int image;
    public  AppInfo(){

    }

    public AppInfo(String appName, int image) {
        this.appName = appName;
        this.image = image;
    }

    public String getappName() {
        return appName;
    }


    public int getImage() {
        return image;
    }
}
