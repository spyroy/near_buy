package com.example.near_buy;

public class ModelProduct {
    private String productId,productName,productPrice,productQuantity,timeTemp,uid;

    public ModelProduct(){}

    public ModelProduct(String productId, String productName, String productPrice, String productQuantity, String timeTemp, String uid) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.timeTemp = timeTemp;
        this.uid = uid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String gettimeTemp() {
        return timeTemp;
    }


    public void settimeTemp(String timestamp) {
        this.timeTemp = timestamp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
