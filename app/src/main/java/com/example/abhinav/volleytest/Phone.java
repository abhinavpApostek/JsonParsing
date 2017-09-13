package com.example.abhinav.volleytest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhinav on 9/13/2017.
 */

public class Phone {

    @SerializedName("home")
    String home;
    @SerializedName("mobile")
    String mobile;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
