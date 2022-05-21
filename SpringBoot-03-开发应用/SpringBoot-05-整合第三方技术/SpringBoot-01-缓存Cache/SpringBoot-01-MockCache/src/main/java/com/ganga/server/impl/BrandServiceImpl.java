package com.ganga.server.impl;

import com.ganga.dao.BrandDao;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

//这里演示缓存 方法是自己写的
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;


    //模拟一个缓存
    private HashMap<Integer,Brand> cache = new HashMap<>();

    @Override
    public Brand getById(int id) {

        //通过id 拿到数据
        Brand brand = cache.get(id);

        //判断数据是否纯在
        if (brand == null){
            //不存在就查询数据库 拿到对应数据
            Brand brandQuery = brandDao.selectById(id);
            //放入缓存中
            cache.put(id,brandQuery);
            //返回数据
            return brandQuery;
        }

        //缓存中有数据 就直接返回数据
        return brand;
    }

}
