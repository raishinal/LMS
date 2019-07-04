/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.Items;
import com.lms.service.CategoryService;
import com.lms.service.ItemService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class ItemController {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(dtf);

    @Autowired
    private Items item;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @GetMapping("/Admin/Item/Add")
    public ModelAndView addItem(ModelAndView mv) {
        mv.addObject("categorylist", categoryService.findSubCategory());
        mv.addObject("tagslist", categoryService.findAllCategory());
        mv.setViewName("admin/additem");
        return mv;
    }

    @RequestMapping(value = "/Admin/Item/Add", method = RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("stock") int stock,
            @RequestParam("image") MultipartFile image
    ) {

        // image 
        if (!image.isEmpty()) {
            if (itemService.uploadImage(image)) {
                item.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/Item/Add?ImageNotUploaded";
            }
        } else {
            return "redirect:/Admin/Item/Add?ImageNotSelected";
        }

        // other form data
        item.setName(name);
        item.setCategory(category);
        item.setDescription(description);
        item.setStock(stock);
        item.setTags(tags);
        item.setPrice(price);
        item.setRetailer(0);
        item.setPosted_date(formattedDateTime);

        if (!itemService.addItem(item)) {
            return "redirect:/Admin/Item/Add?Failed";
        } else {
            return "redirect:/Admin/Item/Add?Success";
        }
    }

    @GetMapping("/Admin/Item/Show")
    public ModelAndView showItems(ModelAndView mv) {
        mv.addObject("itemlist", itemService.findAllItem());
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("admin/displayitem");
        return mv;
    }

    @RequestMapping(value = "/Admin/Item/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable int id, ModelAndView mv) {
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("item", itemService.findItemById(id));
        mv.setViewName("admin/edititem");
        return mv;
    }

    @RequestMapping(value = "/Admin/Item/Update", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("stock") int stock,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("imagename") String imagename,
            @RequestParam("image") MultipartFile image,
            Principal p
    ) {

        // image 
        if (!image.isEmpty()) {
            if (itemService.uploadImage(image)) {
                item.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/Item/Show?ImageUploadFailed";
            }
        } else {

            item.setImageName(imagename);

        }
        Items i = itemService.findItemById(id);

        // other form data
        item.setId(id);
        item.setName(name);
        item.setStock(stock);
        item.setCategory(category);
        item.setTags(tags);
        item.setDescription(description);
        item.setPrice(price);
        item.setRetailer(0);
        item.setPosted_date(i.getPosted_date());

        if (!itemService.updateItem(item)) {
            return "redirect:/Admin/Item/Show?failed";
        } else {

            return "redirect:/Admin/Item/Show?Success";
        }

    }

    @RequestMapping(value = "/Admin/Item/Delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        if (itemService.deleteItem(id)) {
            return "redirect:/Admin/Item/Show?Success";

        } else {
            return "redirect:/Admin/Item/Show?Failed";
        }
    }
}
