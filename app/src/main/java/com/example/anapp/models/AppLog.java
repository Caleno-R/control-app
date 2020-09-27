package com.example.anapp.models;

public class AppLog {
    private String appName;
    private int image;
    private String appTime;
    public  AppLog(){

    }

    public AppLog(String appName,String appTime, int image) {
        this.appName = appName;
        this.appTime = appTime;
        this.image = image;
    }

    public String getAppTime() {
        return appTime;
    }

    public String getappName() {
        return appName;
    }


    public int getImage() {
        return image;
    }
}
