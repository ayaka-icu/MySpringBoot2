package com.ganga.dao.impl;

import com.ganga.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository //Dao层 放入Spring容器当中
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("User is save ruing .....");
    }
}
