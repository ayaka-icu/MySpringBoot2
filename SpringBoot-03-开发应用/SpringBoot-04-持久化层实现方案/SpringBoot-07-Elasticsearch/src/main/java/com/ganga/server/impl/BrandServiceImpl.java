package com.ganga.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.dao.BrandDao;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements BrandService {

}
