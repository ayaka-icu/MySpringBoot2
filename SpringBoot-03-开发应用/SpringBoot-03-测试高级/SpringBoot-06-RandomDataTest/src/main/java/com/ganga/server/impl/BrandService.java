package com.ganga.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.server.IBrandServer;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends ServiceImpl<BrandMapper,Brand> implements IBrandServer {



}
