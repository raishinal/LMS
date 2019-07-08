/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.CartDao;
import com.lms.models.Cart;
import com.lms.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class CartServiceImpl implements CartService{
    
    @Autowired
    private CartDao cartDao;

    @Override
    public boolean addCart(Cart c) {
       return cartDao.insert(c);
    }

    @Override
    public List<Cart> findAllCart() {
        return cartDao.selectAll();
    }

    @Override
    public List<Cart> findCartById(int id) {
        return cartDao.selectById(id);
    }

    @Override
    public boolean deleteCart(int id) {
       return cartDao.delete(id);
    }

    @Override
    public List<Cart> findCartByUsername(String user) {
        return cartDao.selectByUsername(user);
    }

    @Override
    public List<Cart> findCartByDate(String date) {
        return cartDao.selectByDate(date);
    }

    @Override
    public List<Cart> findCartByRetailer(int id) {
       return cartDao.selectByRetailer(id);
    }
    
}
