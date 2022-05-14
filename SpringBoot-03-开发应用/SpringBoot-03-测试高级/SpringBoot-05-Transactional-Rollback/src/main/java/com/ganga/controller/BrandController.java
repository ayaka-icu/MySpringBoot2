package com.ganga.controller;

import com.ganga.pojo.Brand;
import com.ganga.server.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public Boolean save(@RequestBody Brand brand){
        boolean is = brandService.save(brand);
        return is;
    }

}
