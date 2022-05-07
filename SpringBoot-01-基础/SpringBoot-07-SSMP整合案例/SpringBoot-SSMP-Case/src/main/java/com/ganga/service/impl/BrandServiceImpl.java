package com.ganga.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //别放了 放入spring 容器当中！
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 手动封装分页查询
     * @param current
     * @param size
     * @return
     */
    @Override
    public IPage<Brand> getPage(Integer current, Integer size) {
        IPage<Brand> page = new Page<>(current,size);
        brandMapper.selectPage(page,null);
        return page;
    }
}
