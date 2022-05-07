package com.ganga.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import com.ganga.util.R;
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

    //查询所有
    @GetMapping
    public R selectAll(){

        return new R(true,brandService.list());
    }

    //通过id查询
    @GetMapping("/{id}")
    public R selectById(@PathVariable Integer id){
        return new R(true,brandService.getById(id));
    }

    //添加数据
    @PostMapping
    public R save(@RequestBody Brand brand){
        return new R(brandService.save(brand));
    }

    //通过id删除
    @DeleteMapping("/{id}") //请求体路径参数 restful风格参数
    public R deleteById(@PathVariable Integer id){
        return new R(brandService.removeById(id));
    }

    //更新数据
    @CrossOrigin
    @PutMapping
    public R update(@RequestBody Brand brand){
        return new R(brandService.updateById(brand));
    }

    //分页查询
    @GetMapping("/{current}/{age}")
    public R selectPage(@PathVariable Integer current,@PathVariable Integer age){
        return new R(true,brandService.getPage(current, age));
    }


}
