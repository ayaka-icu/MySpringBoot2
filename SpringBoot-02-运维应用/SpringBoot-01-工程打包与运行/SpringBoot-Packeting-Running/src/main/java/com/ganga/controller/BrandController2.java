package com.ganga.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基于 Restful 风格
 */

//@RestController()  //数据返回格式不统一 废弃！
@RequestMapping("/brands")
public class BrandController2 {

    @Autowired
    private IBrandService brandService;

    //查询所有
    @GetMapping
    public List<Brand> selectAll(){
        List<Brand> list = brandService.list();
        return list;
    }

    //通过id查询
    @GetMapping("/{id}")
    public Brand selectById(@PathVariable Integer id){
        Brand brand = brandService.getById(id);
        System.out.println(brand);
        return brand;
    }

    //添加数据
    @PostMapping
    public boolean save(@RequestBody Brand brand){
        boolean save = brandService.save(brand);
        return save;
    }

    //通过id查询
    @DeleteMapping("/{id}") //请求体路径参数 restful风格参数
    public boolean deleteById(@PathVariable Integer id){
        boolean b = brandService.removeById(id);
        return b;
    }

    //更新数据
    @PutMapping
    public boolean update(@RequestBody Brand brand){
        boolean b = brandService.updateById(brand);
        return b;
    }

    //分页查询
    @GetMapping("/{current}/{age}")
    public IPage<Brand> selectPage(@PathVariable Integer current,@PathVariable Integer age){
        IPage<Brand> brands = brandService.getPage(current, age);
        return brands;
    }


}
