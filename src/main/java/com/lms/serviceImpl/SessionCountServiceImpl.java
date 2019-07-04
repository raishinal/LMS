/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.SessionCountDao;
import com.lms.models.SessionCount;
import com.lms.service.SessionCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class SessionCountServiceImpl implements SessionCountService{

    @Autowired 
            SessionCountDao sessionCountDao;
    
    @Override
    public boolean save(SessionCount sc) {
        return sessionCountDao.insert(sc);
    }

    @Override
    public int getCount() {
        return sessionCountDao.getCount();
    }

    @Override
    public boolean resetCount(int id) {
        return sessionCountDao.resetCount(id);
    }

    @Override
    public boolean updateCount(SessionCount sc) {
       return sessionCountDao.updateCount(sc);
    }

    @Override
    public SessionCount getSessionCount(int id) {
       return sessionCountDao.getsessioncount(id);
    }

    @Override
    public String getDate() {
        return sessionCountDao.getDate();
    }

    
}
