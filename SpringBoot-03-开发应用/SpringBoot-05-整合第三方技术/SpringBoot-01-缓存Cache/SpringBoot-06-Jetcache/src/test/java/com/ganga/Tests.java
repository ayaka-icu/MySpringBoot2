package com.ganga;

import com.alibaba.fastjson.JSON;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Tests {

    @Test
    void contextLoads() {
        for (int i = 0; i < 20; i++) {
            double v = (Math.random() * 9 + 1) * 100000;
            System.out.println((int)v);
        }
    }

    @Test
    void json(@Autowired BrandService brandService){
        Brand brand = brandService.getByIdDemo01(26);
        String json = JSON.toJSONString(brand);
        System.out.println(json);
        //{"brandName":"SpringBoot2","companyName":"SpringBoot2","description":"SpringBoot2","id":"26","ordered":666,"status":1}
    }

}
