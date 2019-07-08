/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.LikeDao;
import com.lms.models.LikeCounts;
import com.lms.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class LikeServiceImpl implements LikeService{
    
    @Autowired
    LikeDao likeDao;

    @Override
    public boolean addItem(LikeCounts ls) {
        return likeDao.insert(ls);
    }

    @Override
    public LikeCounts findItemById(int id) {
        return likeDao.select(id);
    }

    @Override
    public boolean checkUserItem(int itemid, int userid) {
        return likeDao.checkuser(itemid, userid);
    }
    
}
