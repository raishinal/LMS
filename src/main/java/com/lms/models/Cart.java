/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Raishin
 */
@Entity
public class Cart {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String username;
    private int productid;
    private int quantity;
    private double price;
    private String productname;
    private int retailer;
    private String orderdate;
    private String productimage;

    public Cart(int id, String username, int productid, int quantity, double price, String productname, int retailer, String orderdate, String productimage) {
        this.id = id;
        this.username = username;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.productname = productname;
        this.retailer = retailer;
        this.orderdate = orderdate;
        this.productimage = productimage;
    }

    public Cart(String username, int productid, int quantity, double price, String productname, int retailer, String orderdate, String productimage) {
        this.username = username;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.productname = productname;
        this.retailer = retailer;
        this.orderdate = orderdate;
        this.productimage = productimage;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getRetailer() {
        return retailer;
    }

    public void setRetailer(int retailer) {
        this.retailer = retailer;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

   

}
