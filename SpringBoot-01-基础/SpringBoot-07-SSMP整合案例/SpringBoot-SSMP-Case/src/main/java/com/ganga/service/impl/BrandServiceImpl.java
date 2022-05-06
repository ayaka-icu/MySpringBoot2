package com.ganga.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import org.springframework.stereotype.Service;

@Service //别放了 放入spring 容器当中！
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {


}
