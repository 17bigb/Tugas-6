package com.example.contactactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContactModel {

    private String name, number, group, instagram;

    public ContactModel(String name, String number, String group) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}