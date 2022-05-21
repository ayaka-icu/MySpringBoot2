package com.ganga.controller;

import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/{id}")
    public Brand getById(@PathVariable int id){
        return brandService.getById(id);
    }

}
