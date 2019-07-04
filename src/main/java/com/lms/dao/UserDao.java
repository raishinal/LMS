/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.UserDetails;
import com.lms.models.UserRole;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface UserDao {

    boolean insert(UserDetails ud);

    public List<UserDetails> selectAll();

    public List<UserRole> selectAllUserrole();
    
    public List<UserDetails> selectAllByDate(String date);

    public UserDetails selectById(int id);

    public UserDetails selectByUsername(String user);

    public boolean delete(int id);
    public boolean update(UserDetails ud);
}
