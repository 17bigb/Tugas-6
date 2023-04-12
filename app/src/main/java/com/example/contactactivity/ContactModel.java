package com.example.contactactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContactModel {

    private String nim,name, number, group;

    public ContactModel(String NIM, String name, String number, String group) {
        this.name = name;
        this.number = number;
        this.nim = NIM;
        this.group = group;

    }

    public String getNim(){
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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