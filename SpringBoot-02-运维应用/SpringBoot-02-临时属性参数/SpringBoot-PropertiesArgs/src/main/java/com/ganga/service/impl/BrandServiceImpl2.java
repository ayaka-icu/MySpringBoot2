package com.ganga.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import com.ganga.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //放入spring容器
public class BrandServiceImpl2 implements BrandService {

    //注入dao数据层对象
    @Autowired
    private BrandMapper brandMapper;

    //新建 添加数据
    @Override
    public boolean saver(Brand brand) {
        return brandMapper.insert(brand) > 0;
    }

    //通过id删除
    @Override
    public boolean deleteById(Integer id) {
        return brandMapper.deleteById(id) > 0;
    }

    //批量删除
    @Override
    public boolean deleteIds(List list) {
        return brandMapper.deleteBatchIds(list) > 0;
    }

    //更新 修改
    @Override
    public boolean update(Brand brand) {
        return brandMapper.updateById(brand) > 0;
    }

    //查询所有数据
    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectList(null);
    }

    //分页查询
    @Override
    public IPage<Brand> selectPage(Integer currentPage, Integer sizePage) {
        IPage<Brand> page = new Page<>(currentPage,sizePage);
        return brandMapper.selectPage(page,null);
    }
}
