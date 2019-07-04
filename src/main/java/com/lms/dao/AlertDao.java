/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.Alerts;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface AlertDao {
     public boolean insert(Alerts al);

    public List<Alerts> selectAll();

    public List<Alerts> selectById(int id);

    public List<Alerts> selectByLatest();

    public boolean delete(int id);
}
