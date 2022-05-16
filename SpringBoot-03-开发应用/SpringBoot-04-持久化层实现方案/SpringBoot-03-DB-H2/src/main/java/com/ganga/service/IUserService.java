package com.ganga.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ganga.pojo.User;

public interface IUserService extends IService<User> {

    boolean updateByName(String name,Integer id);

}
