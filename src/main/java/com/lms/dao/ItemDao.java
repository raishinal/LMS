/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.dao;

import com.lms.models.Items;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface ItemDao {
    public boolean insert(Items item);
    public List<Items> selectAll();
    public Items selectById(int id);
    public List<Items> selectByCategory(int category);
    public List<Items> selectByTags(String tag);
    public List<Items> selectBySub(int sub);
    public List<Items> searchKeywords(String key);
    public List<Items> findLatestItem();
    public List<Items> findByDate(String date);
    public List<Items> findByRetailer(int id);
    public boolean update(Items item);
    public boolean delete(int id);
}
