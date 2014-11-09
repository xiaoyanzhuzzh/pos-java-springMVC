package com.thoughtWorks.dao;
import com.thoughtWorks.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.Object;
import java.sql.*;
import java.util.*;
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public ItemDaoImpl(){

    }

    public ItemDaoImpl(SimpleJdbcTemplate simpleJdbcTemplate){
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public Item getItemByBarcode(String barcode){
        String sql = "SELECT * FROM items WHERE barcode = ?";
        return (Item) simpleJdbcTemplate.queryForObject(sql, new ItemRowMapper(), barcode);
    }

    @Override
    public List<Item> getItems() {
        String sql = "SELECT * FROM items ";
        return simpleJdbcTemplate.query(sql, new ItemRowMapper());
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        String sql = "SELECT promotions.*, items_promotions.discount FROM promotions, items_promotions " +
                "WHERE items_promotions.itemId=? AND promotions.id=items_promotions.proId";
        return (List<Promotion>) simpleJdbcTemplate.query(sql, new PromotionRowMapper(), id);
    }


    private class ItemRowMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();

        item.setId(resultSet.getString("id"));
        item.setBarcode(resultSet.getString("barcode"));
        item.setName(resultSet.getString("name"));
        item.setUnit(resultSet.getString("unit"));
        item.setCategoryId(resultSet.getString("categoryId"));
        item.setPrice(resultSet.getDouble("price"));

        return item;
        }
    }

    private class PromotionRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Promotion promotion = PromotionFactory.getPromotionByType(resultSet.getInt("type"));

            promotion.setId(resultSet.getString("id"));
            promotion.setProDesc(resultSet.getString("proDesc"));
            promotion.setType(resultSet.getInt("type"));
            promotion.setDiscount(resultSet.getDouble("discount"));

            return promotion;
        }
    }
}
