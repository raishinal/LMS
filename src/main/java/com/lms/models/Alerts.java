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
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String cause;
    private String detail;
    private String date;
    private int relatedid;

    public Alerts() {
    }

    public Alerts(String title, String cause, String detail, String date, int relatedid) {
        this.title = title;
        this.cause = cause;
        this.detail = detail;
        this.date = date;
        this.relatedid = relatedid;
    }

    public Alerts(int id, String title, String cause, String detail, String date, int relatedid) {
        this.id = id;
        this.title = title;
        this.cause = cause;
        this.detail = detail;
        this.date = date;
        this.relatedid = relatedid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRelatedid() {
        return relatedid;
    }

    public void setRelatedid(int relatedid) {
        this.relatedid = relatedid;
    }

   

}
