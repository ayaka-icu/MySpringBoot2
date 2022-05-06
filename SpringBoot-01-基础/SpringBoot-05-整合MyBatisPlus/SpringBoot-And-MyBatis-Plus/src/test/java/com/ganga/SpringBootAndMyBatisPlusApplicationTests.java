package com.ganga;

import com.ganga.mapper.BrandMapper;
import com.ganga.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 'springboot_db.brand' doesn't exist
 * mybatis-plus 问题 表名和类名映射问题
 */
@SpringBootTest
class SpringBootAndMyBatisPlusApplicationTests {

    //注入dao
    @Autowired
    private BrandMapper brandMapper;

    @Test
    void contextLoads() {

        System.out.println("/////////////////////////////");
        Brand brand = brandMapper.selectById(1);
        System.out.println(brand);
        System.out.println("/////////////////////////////");
        List<Brand> brands = brandMapper.selectList(null);
        for (Brand br : brands) {
            System.out.println(br);
        }
        System.out.println("/////////////////////dxx////////");

    }

}
