package com.ganga.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.Mapper.UserMapper;
import com.ganga.pojo.User;
import com.ganga.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean updateByName(String name, Integer id) {
        int i = userMapper.updateByName(name, id);
        return i > 0;
    }
}
