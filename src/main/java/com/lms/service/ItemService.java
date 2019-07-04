/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;

import com.lms.models.Items;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
public interface ItemService {
     public boolean addItem(Items item);

    public List<Items> findAllItem();

    public Items findItemById(int id);

    public List<Items> findItemByCategory(int category);

    public List<Items> findItemByTags(String tag);
    
    public List<Items> findItemBySub(int sub);
    public List<Items> findItemByKey(String key);
    public List<Items> findLatestItems();
    public List<Items> findLatestByDate(String date);
    public List<Items> findByRetailer(int id);

    public boolean updateItem(Items item);

    public boolean deleteItem(int id);

    boolean uploadImage(MultipartFile image);
}
