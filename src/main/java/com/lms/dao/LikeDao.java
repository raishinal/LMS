/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.LikeCounts;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface LikeDao {
    public boolean insert(LikeCounts lc);
    public LikeCounts select(int id);
    public boolean checkuser(int itemid, int userid);
    
}
