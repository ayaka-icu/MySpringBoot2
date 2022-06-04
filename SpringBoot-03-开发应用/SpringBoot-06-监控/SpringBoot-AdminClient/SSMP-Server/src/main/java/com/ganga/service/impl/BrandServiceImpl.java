package com.ganga.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service //别放了 放入spring 容器当中！
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    //付费次数计数
    private Counter counter;

    public BrandServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("付费业务执行次数:");
    }

    /**
     * 重写
     * @param id
     * @return
     */
    public boolean deleteById(Integer id) {
        boolean b = brandMapper.deleteById(id) > 0;
        if (b){
            //执行一次计数
            counter.increment();
        }
        return b;
    }

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
