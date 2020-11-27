package com.example.near_buy;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private  String name,email,store;
    private List<ContactsContract.CommonDataKinds.Relation> products = new ArrayList<>();

    public Manager(){
    }

    //send data at register
    public Manager(String name,String email){
        this.name = name;
        this.email = email;
    }

    //retrieve info from database
    public Manager(String name, String email, String store, List<ContactsContract.CommonDataKinds.Relation> products){
        this.name = name;
        this.email = email;
        this.store = store;
        this.products = products;
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

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public List<ContactsContract.CommonDataKinds.Relation> getProducts() {
        return products;
    }

    public void setName(List<ContactsContract.CommonDataKinds.Relation> products) {
        this.products = products;
    }
}