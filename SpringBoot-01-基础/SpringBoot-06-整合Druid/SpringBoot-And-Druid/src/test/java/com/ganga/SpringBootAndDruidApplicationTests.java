package com.ganga;

import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootAndDruidApplicationTests {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    void contextLoads() {

        System.out.println(brandMapper.getById(5));

    }

    @Test
    void selectAllTest(){
        List<Brand> brands = brandMapper.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

}
