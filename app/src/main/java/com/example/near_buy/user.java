package com.example.near_buy;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class user {
    private String name,email;
    private int Have_business;
    private List<ContactsContract.CommonDataKinds.Relation> items = new ArrayList<>();

    public user(){
    }

    //send data at register
    public user(String name,String email){
        this.name = name;
        this.email = email;
        Have_business = 0;
    }

    //retrieve info from database
    public user(String name, String email, List<ContactsContract.CommonDataKinds.Relation> items){
        this.name = name;
        this.email = email;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContactsContract.CommonDataKinds.Relation> getItems() {
        return items;
    }

    public void setItems(List<ContactsContract.CommonDataKinds.Relation> items) {
        this.items = items;
    }
}
