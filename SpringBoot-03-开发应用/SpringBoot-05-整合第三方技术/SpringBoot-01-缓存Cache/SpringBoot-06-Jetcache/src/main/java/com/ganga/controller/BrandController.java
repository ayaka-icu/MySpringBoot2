package com.ganga.controller;

import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/{id}")
    public Brand getByIdDemo01(@PathVariable int id){
        return brandService.getByIdDemo02(id);
    }

    @PostMapping
    public String save(@RequestBody Brand brand){
        return brandService.save(brand) ? "添加成功！":"添加失败！";
    }

    @PutMapping
    public String updateById(@RequestBody Brand brand){
        return brandService.updateById(brand) ? "修改成功！":"修改失败！";
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable int id){
        return brandService.deleteById(id) ? "删除成功！":"删除失败！";
    }

}
