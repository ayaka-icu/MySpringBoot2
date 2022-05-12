package com.ganga.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ganga.pojo.Brand;

public interface IBrandService extends IService<Brand>{

    IPage<Brand> getPage(Integer current,Integer size);

    IPage<Brand> getPageCondition(Integer current,Integer size,Brand brand);

}
