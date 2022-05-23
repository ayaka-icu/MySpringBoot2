package com.ganga.server.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.*;
import com.ganga.dao.BrandDao;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


//这里演示缓存 方法是自己写的
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @CreateCache(area = "env2",name = "test_",expire = 10,timeUnit = TimeUnit.MINUTES,cacheType = CacheType.LOCAL)
    private Cache<Integer,Brand> brandCache;

    /**
     * 不使用缓存方法 演示
     * @param id
     * @return
     */
    @Override
    public Brand getByIdDemo01(int id) {
        Brand brand = brandCache.get(id);
        System.out.println(brand);
        if (brand == null){
            brand = brandDao.selectById(id);
            System.out.println("====>" + brand);
            brandCache.put(id,brand);
        }
        return brand;
    }




    /**
     * 使用缓存方法  @Cached
     * @param id
     * @return
     */
    @Override
    //@Cached 多一个 key="#xxx" xxx就是缓存的k 别忘了前面加个#号
    @Cached(name = "brand_",key = "#id",expire = 10,cacheType = CacheType.REMOTE,timeUnit = TimeUnit.MINUTES)
    //@CacheRefresh 设置每10分钟查询更新缓存数据
    @CacheRefresh(refresh = 10,timeUnit = TimeUnit.MINUTES)
    public Brand getByIdDemo02(int id) {
        return brandDao.selectById(id);
    }

    @Override
    public boolean save(Brand brand) {
        return brandDao.insert(brand) > 0;
    }

    /**
     * 更新数据 同时更新缓存 使用@CacheUpdate注解
     * @param brand
     * @return
     */
    @Override
    @CacheUpdate(name="brand_", key="#brand.id", value="#brand")
    public boolean updateById(Brand brand) {
        return brandDao.updateById(brand) > 0;
    }

    /**
     * 删除数据 同时删除对应缓存中的数据使用@CacheInvalidate注解
     * @param id
     * @return
     */
    @Override
    @CacheInvalidate(name="brand_", key = "#id")
    public boolean deleteById(int id) {
        return brandDao.deleteById(id) > 0;
    }





}
