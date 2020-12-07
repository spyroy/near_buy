package com.example.near_buy;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class user {
    private String name;
    private String email;
    private String address;
    private int phone;
    private  String type ;
    private List<ContactsContract.CommonDataKinds.Relation> items = new ArrayList<>();

    public user(){
    }

    //send data at register
    public user(String name,String email,String address,int phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = "User";

    }

    //retrieve info from database
    public user(String name, String email,String address,int phone, List<ContactsContract.CommonDataKinds.Relation> items){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
