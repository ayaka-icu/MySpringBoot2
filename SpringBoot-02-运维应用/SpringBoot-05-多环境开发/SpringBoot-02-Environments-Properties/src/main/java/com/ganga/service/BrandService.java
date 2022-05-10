package com.ganga.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ganga.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 保存 添加数据
     * @param brand
     * @return true -- 保存成功！
     */
    boolean saver(Brand brand);

    /**
     * 通过id删除
     * @return true -- 成功！
     */
    boolean deleteById(Integer id);

    /**
     * 批量删除
     * @param list
     * @return true -- 成功！
     */
    boolean deleteIds(List list);

    /**
     * 修改数据
     * @param brand
     * @return true --- 成功
     */
    boolean update(Brand brand);

    /**
     * 查询所有数据
     * @return
     */
    List<Brand> selectAll();

    /**
     * 分页查询
     * @param currentPage 查询的页数
     * @param sizePage 每页的数量
     * @return
     */
    IPage<Brand> selectPage(Integer currentPage, Integer sizePage);

}
