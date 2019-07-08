/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.ItemDao;
import com.lms.models.Items;
import com.lms.service.ItemService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\ListManagementSystem\\src\\main\\webapp\\resources";
    
    @Autowired
    private ItemDao itemDao;

    @Override
    public boolean addItem(Items item) {
        return itemDao.insert(item);
    }

    @Override
    public List<Items> findAllItem() {
        return itemDao.selectAll();
    }

    @Override
    public Items findItemById(int id) {
        return itemDao.selectById(id);
    }

    @Override
    public List<Items> findItemByCategory(int category) {
        return itemDao.selectByCategory(category);
    }

    @Override
    public List<Items> findItemByTags(String tag) {
        return itemDao.selectByTags(tag);
    }

    @Override
    public List<Items> findItemBySub(int sub) {
       return itemDao.selectBySub(sub);
    }

    @Override
    public boolean updateItem(Items item) {
        return itemDao.update(item);
    }

    @Override
    public boolean deleteItem(int id) {
        return itemDao.delete(id);
    }

    @Override
    public boolean uploadImage(MultipartFile image) {
         boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "itemimage");
        if(!dir.exists()){
            dir.mkdirs();
        }
       
        
       String filename = image.getOriginalFilename();
       File uploadImage = new File(dir + File.separator +filename);
       try{
           image.transferTo(uploadImage);
           status = true;
       }catch(Exception e){
           System.out.println(e); 
       }
        
        return status;
    }

    @Override
    public List<Items> findItemByKey(String key) {
        return itemDao.searchKeywords(key);
    }

    @Override
    public List<Items> findLatestItems() {
       return itemDao.findLatestItem();
    }

    @Override
    public List<Items> findLatestByDate(String date) {
        return itemDao.findByDate(date);
    }

    @Override
    public List<Items> findByRetailer(int id) {
       return itemDao.findByRetailer(id);
    }

    @Override
    public List<Items> filterByPrice(int sub, double id) {
       return itemDao.findByPrice(sub, id);
    }

    @Override
    public List<Items> findPopularItems() {
        return itemDao.findPopularItem();
    }
    
}
