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
 * @author roslm
 */
@Entity
public class LikeCounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int itemid;
    private int userid;
    private String date;

    public LikeCounts() {
    }

    public LikeCounts(int itemid, int userid, String date) {
        this.itemid = itemid;
        this.userid = userid;
        this.date = date;
    }

    public LikeCounts(int id, int itemid, int userid, String date) {
        this.id = id;
        this.itemid = itemid;
        this.userid = userid;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
