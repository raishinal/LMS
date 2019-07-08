/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */
@Entity
public class Items implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int category;
    private String tags;
    private String description;
    private double price;
    private int stock;
    @Transient
    private MultipartFile image;
    private String imageName;
    private String posted_date;
    private int retailer;
    private int likecounts;

    public Items() {
    }

    public Items(String name, int category, String tags, String description, double price, int stock, MultipartFile image, String imageName, String posted_date, int retailer, int likecounts) {
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.imageName = imageName;
        this.posted_date = posted_date;
        this.retailer = retailer;
        this.likecounts = likecounts;
    }

    public Items(int id, String name, int category, String tags, String description, double price, int stock, MultipartFile image, String imageName, String posted_date, int retailer, int likecounts) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.imageName = imageName;
        this.posted_date = posted_date;
        this.retailer = retailer;
        this.likecounts = likecounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public int getRetailer() {
        return retailer;
    }

    public void setRetailer(int retailer) {
        this.retailer = retailer;
    }

    public int getLikecounts() {
        return likecounts;
    }

    public void setLikecounts(int likecounts) {
        this.likecounts = likecounts;
    }

   


}
