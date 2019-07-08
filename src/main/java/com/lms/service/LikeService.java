/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;

import com.lms.models.LikeCounts;

/**
 *
 * @author roslm
 */
public interface LikeService {
 public boolean addItem(LikeCounts ls);

    public LikeCounts findItemById(int id);
    public boolean checkUserItem(int itemid,int userid);
}
