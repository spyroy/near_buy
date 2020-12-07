package com.example.near_buy;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private  String name;
    private String email;
    private String store_name;
    private String store_address;
    private  int  phone, store_phone;
    private List<ContactsContract.CommonDataKinds.Relation> products = new ArrayList<>();
    private  String type ;

    public Manager(){
    }

    //send data at register
    public Manager(String name,String store,String email,String address,int phone){
        this.name = name;
        this.store_name=store;
        this.email = email;
        this.store_address = address;
        this.phone = phone;
        this.type = "Seller";

    }

    //retrieve info from database
    public Manager(String name, String email, String store, List<ContactsContract.CommonDataKinds.Relation> products, String store_address, int store_phone){
        this.name = name;
        this.email = email;
        this.store_name = store;
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
        return store_name;
    }

    public void setStore(String store) {
        this.store_name = store;
    }

    public List<ContactsContract.CommonDataKinds.Relation> getProducts() {
        return products;
    }

    public void setProducts(List<ContactsContract.CommonDataKinds.Relation> products) {
        this.products = products;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
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