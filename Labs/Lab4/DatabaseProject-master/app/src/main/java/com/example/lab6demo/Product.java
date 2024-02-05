package com.example.lab6demo;

public class Product {
    private int _id;
    private String _productname;
    private int _sku;

    public Product() {
    }
    public Product(int id, String productname, int sku) {
        _id = id;
        _productname = productname;
        _sku = sku;
    }
    public Product(String productname, int sku) {
        _productname = productname;
        _sku = sku;
    }

    public void setID(int id) {
        _id = id;
    }
    public int getID() {
        return _id;
    }
    public void setProductName(String productname) {
        _productname = productname;
    }
    public String getProductName() {
        return _productname;
    }
    public void setSku(int sku) {
        _sku = sku;
    }
    public int getSku() {
        return _sku;
    }

}