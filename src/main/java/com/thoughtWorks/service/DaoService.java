package com.thoughtWorks.service;

import com.thoughtWorks.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoService {
    @Autowired
    private Dao itemDao;

    public String getItem(){
        return itemDao.getItem();
    }
}
