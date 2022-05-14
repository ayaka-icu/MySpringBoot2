package com.ganga.controller;

import com.ganga.pojo.Brand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @GetMapping
    public Brand getById(){
        Brand brand = new Brand();
        brand.setId(1);
        brand.setBrandName("SpringBoot setBrandName");
        brand.setCompanyName("SpringBoot setCompanyName");
        brand.setOrdered(1);
        brand.setDescription("SpringBoot setDescription");

        return brand;
    }

    @DeleteMapping
    public String delete(){
        System.out.println("SpringBoot getById is running...");
        return "SpringBoot getById is running...";
    }

}
