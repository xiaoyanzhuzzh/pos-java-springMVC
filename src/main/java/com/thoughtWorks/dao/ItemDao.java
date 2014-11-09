package com.thoughtWorks.dao;

import com.thoughtWorks.model.*;

import java.util.List;

public interface ItemDao {
    Item getItemByBarcode(String barcode);
    List<Item> getItems();
    List<Promotion> getPromotionsByItemId(String id);
}
