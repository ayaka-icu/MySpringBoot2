package com.ganga;

import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTests {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    void contextLoads() {

        Brand brand1 = brandMapper.getById(1);
        System.out.println(brand1);
        Brand brand6 = brandMapper.getById(6);
        System.out.println(brand6);

    }

}
