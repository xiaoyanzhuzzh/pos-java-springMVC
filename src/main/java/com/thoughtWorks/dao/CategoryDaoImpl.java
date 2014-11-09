package com.thoughtWorks.dao;

import com.thoughtWorks.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private final SimpleJdbcTemplate simpleJdbcTemplate;

    public CategoryDaoImpl(SimpleJdbcTemplate simpleJdbcTemplate){
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public Category getCategoryById(String id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)simpleJdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

    public class CategoryRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Category category = new Category();
            category.setId(resultSet.getString("id"));
            category.setName(resultSet.getString("name"));
            return category;
        }
    }
}
