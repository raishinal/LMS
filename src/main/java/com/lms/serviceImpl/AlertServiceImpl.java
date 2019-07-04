/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.AlertDao;
import com.lms.models.Alerts;
import com.lms.service.AlertService;
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
public class AlertServiceImpl implements AlertService{
@Autowired
AlertDao alertDao;
    @Override
    public boolean addAlert(Alerts al) {
        return alertDao.insert(al);
    }

    @Override
    public List<Alerts> findAllAlerts() {
       return alertDao.selectAll();
    }

    @Override
    public List<Alerts> findAlertById(int id) {
        return alertDao.selectById(id);
    }

    @Override
    public List<Alerts> findAlertByLatest() {
        return alertDao.selectByLatest();
    }

    @Override
    public boolean deleteAlert(int id) {
       return alertDao.delete(id);
    }
    
    
}
