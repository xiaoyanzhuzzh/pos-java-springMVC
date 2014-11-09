package com.thoughtWorks.service;

import com.thoughtWorks.dao.ItemDao;
import com.thoughtWorks.model.Item;
import com.thoughtWorks.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDaoImpl;

    private List<Item> items = new ArrayList<Item>();
    public ItemServiceImpl(){

    }

    @Override
    public Item getItemByBarcode(String barcode) {
        return itemDaoImpl.getItemByBarcode(barcode);
    }

    @Override
    public List<Item> getItems() {
        return itemDaoImpl.getItems();
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        return itemDaoImpl.getPromotionsByItemId(id);
    }

    public void insertItem(Item item){
        items.add(item);
    }
}
