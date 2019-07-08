/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.Cart;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface CartDao {

    public boolean insert(Cart c);

    public List<Cart> selectAll();

    public List<Cart> selectById(int id);

    public List<Cart> selectByUsername(String user);
    public List<Cart> selectByRetailer(int id);
    public List<Cart> selectByDate(String date);

    public boolean delete(int id);
}
