package com.ganga.server.impl;

import com.ganga.dao.BrandDao;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

//这里演示缓存 方法是自己写的
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;


    @Override
    //要放入的缓存 及要取的数据
    @Cacheable(value = "cacheSpace", key = "#id")
    public Brand getById(int id) {

        System.out.println("===============");
        Brand brand = brandDao.selectById(id);
        System.out.println("===============");

        return brand;
    }
    /**
     *
     * value设置缓存位置
     *
     * key = "#参数"
     *
     * 原理：
     *      调用该方法 传入参数
     *         从该缓存中找传入参数是否纯在
     *         不存在：执行该方法 并返回 同时将返回的对象放入缓存
     *         存在：  如果存在 不执行该方法里的逻辑 而是从缓存中拿到数据 当做返回值返回
     */


}
