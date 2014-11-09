package com.thoughtWorks.service;

import com.thoughtWorks.model.Item;
import com.thoughtWorks.model.Promotion;

import java.util.List;

public interface ItemService {
    Item getItemByBarcode(String barcode);
    List<Item> getItems();
    List<Promotion> getPromotionsByItemId(String id);
    void insertItem(Item item);
}
