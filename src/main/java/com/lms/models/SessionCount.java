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
public class SessionCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int count;
    private String field;
    private String date;

    public SessionCount() {
    }

    public SessionCount(int count, String field, String date) {
        this.count = count;
        this.field = field;
        this.date = date;
    }

    public SessionCount(int id, int count, String field, String date) {
        this.id = id;
        this.count = count;
        this.field = field;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    

}
