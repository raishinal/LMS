/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;

import com.lms.models.Alerts;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface AlertService {

    public boolean addAlert(Alerts al);

    public List<Alerts> findAllAlerts();
    
    public List<Alerts> findAlertById(int id);

    public List<Alerts> findAlertByLatest();

    public boolean deleteAlert(int id);
}
