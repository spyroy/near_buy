package com.example.near_buy;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private  String name;
    private String email;
    private String store;
    private String address;
    private String store_address;
    private  int Have_business, phone, store_phone;
    private List<ContactsContract.CommonDataKinds.Relation> products = new ArrayList<>();

    public Manager(){
    }

    //send data at register
    public Manager(String name,String email,String address,int phone, int have_business){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Have_business = 1;
    }

    //retrieve info from database
    public Manager(String name, String email, String store, List<ContactsContract.CommonDataKinds.Relation> products, String store_address, int store_phone){
        this.name = name;
        this.email = email;
        this.store = store;
        this.store_address = store_address;
        this.store_phone = store_phone;
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

    public void setProducts(List<ContactsContract.CommonDataKinds.Relation> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public int getHave_business() {
        return Have_business;
    }

    public void setHave_business(int have_business) {
        Have_business = have_business;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(int store_phone) {
        this.store_phone = store_phone;
    }
}