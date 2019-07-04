/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.models;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author stim
 */
@Entity
@Table(name="User_Details")
public class UserDetails {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="usr_dtl_id")
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private long phone;
    private LocalDate dob;
    private String country;
    private String interest;
    private String address;
    private String startdate;
    @Transient
    private MultipartFile image;
    private String imageName;
  
    private int active;
    private String userName;

    
    private String password;
    
    @Transient
    private String userType;
    
    
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetails")
   private UserRole userRole;

    public UserDetails() {
    }

    public UserDetails(String firstname, String lastname, String email, long phone, LocalDate dob, String country, String interest, String address,String startdate, MultipartFile image, String imageName, String userName, String password, String userType,int active, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.country = country;
        this.interest = interest;
        this.address = address;
        this.startdate=startdate;
        this.image = image;
        this.imageName = imageName;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.active = active;
        this.userRole = userRole;
    }

    public UserDetails(int id, String firstname, String lastname, String email, long phone, LocalDate dob, String country, String interest, String address,String startdate, MultipartFile image, String imageName, String userName, String password, String userType, int active, UserRole userRole) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.country = country;
        this.interest = interest;
        this.address = address;
        this.startdate=startdate;
        this.image = image;
        this.imageName = imageName;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.active = active;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

  
   
    
}
