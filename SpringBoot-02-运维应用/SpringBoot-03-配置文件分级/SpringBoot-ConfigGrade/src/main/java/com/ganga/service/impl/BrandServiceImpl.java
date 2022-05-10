package com.ganga.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import org.apache.logging.log4j.util.Strings;
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

    @Override
    public IPage<Brand> getPageCondition(Integer current, Integer size, Brand brand) {
        //条件判断
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<Brand>();
        lqw.like(Strings.isNotEmpty(brand.getBrandName()),Brand::getBrandName,brand.getBrandName());
        lqw.like(Strings.isNotEmpty(brand.getCompanyName()),Brand::getCompanyName,brand.getCompanyName());
        lqw.like(Strings.isNotEmpty(brand.getDescription()),Brand::getDescription,brand.getDescription());

        IPage<Brand> page = new Page<>(current,size);
        brandMapper.selectPage(page,lqw);
        return page;
    }
}
