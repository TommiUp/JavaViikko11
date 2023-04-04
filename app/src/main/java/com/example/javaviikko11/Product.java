package com.example.javaviikko11;

import java.io.Serializable;

public class Product implements Serializable {
    private static int idCounter = 0;
    protected String productName;
    protected String productNotes;
    protected int id;

    public Product(String productName, String productNotes) {
        this.productName = productName;
        this.productNotes = productNotes;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNotes() {
        return productNotes;
    }

    public void setProductNotes(String productNotes) {
        this.productNotes = productNotes;
    }
}
