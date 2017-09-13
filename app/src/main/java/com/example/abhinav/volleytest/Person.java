package com.example.abhinav.volleytest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhinav on 9/13/2017.
 */

public class Person {

    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("phone")
    Phone phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
