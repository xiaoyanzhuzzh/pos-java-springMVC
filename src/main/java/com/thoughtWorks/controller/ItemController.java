package com.thoughtWorks.controller;

import com.thoughtWorks.model.Item;
import com.thoughtWorks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemServiceImpl;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String printHello(@RequestParam("barcode") String barcode, ModelMap modelMap){
        Item item = itemServiceImpl.getItemByBarcode(barcode);
        modelMap.addAttribute("item", item);
        return "item";
    }

    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    public String getItems(ModelMap modelMap){
        List<Item> items = itemServiceImpl.getItems();
        modelMap.addAttribute("items", items);
        return "item";
    }

    @ModelAttribute("item")
    public Item getItem(){
        Item item = new Item();
        return item;
    }

    @RequestMapping(value="/insert", method = RequestMethod.GET)
    public String insertItem(@ModelAttribute("item") Item item, ModelMap modelMap){
        itemServiceImpl.insertItem(item);
        List<Item> items = itemServiceImpl.getItems();
        modelMap.addAttribute("items", items);
        return "item";
    }
}
