/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.SessionCount;

/**
 *
 * @author roslm
 */
public interface SessionCountDao {
    public boolean insert(SessionCount sc);
    public SessionCount getsessioncount(int id);
    public int getCount();
    public String getDate();
    public boolean resetCount(int id);
    public boolean updateCount(SessionCount sc);
    
}
