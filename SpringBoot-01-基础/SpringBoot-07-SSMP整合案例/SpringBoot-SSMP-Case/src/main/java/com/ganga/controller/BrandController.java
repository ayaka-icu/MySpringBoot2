package com.ganga.controller;

import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基于 Restful 风格
 */

@RestController()
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @GetMapping
    public List<Brand> selectAll(){
        List<Brand> list = brandService.list();
        return list;
    }

    //添加数据
    @PostMapping
    public boolean save(@RequestBody Brand brand){
        boolean save = brandService.save(brand);
        return save;
    }

    @DeleteMapping("/{id}") //请求体路径参数 restful风格参数
    public boolean deleteById(@PathVariable Integer id){
        boolean b = brandService.removeById(id);
        return b;
    }

    @PutMapping
    public boolean update(@RequestBody Brand brand){
        boolean b = brandService.updateById(brand);
        return b;
    }


}
