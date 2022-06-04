package com.ganga.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ganga.pojo.Brand;

import java.io.Serializable;

public interface IBrandService extends IService<Brand>{

    boolean deleteById(Integer id);

    IPage<Brand> getPage(Integer current,Integer size);

    IPage<Brand> getPageCondition(Integer current,Integer size,Brand brand);

}
