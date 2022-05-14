package com.ganga.service;

import com.ganga.pojo.Brand;
import com.ganga.server.impl.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional //测试时 只添加@Transactional不添加@Rollback 默认回滚
@Rollback(value = false) //@Rollback手动设置是否回滚 true默认回滚  false不会滚
public class BrandServiceTest {

    @Test
    void testSave(@Autowired BrandService brandService){
        Brand brand = new Brand();
        brand.setBrandName("SpringBoot2");
        brand.setCompanyName("SpringBoot2");
        brand.setOrdered(666);
        brand.setDescription("SpringBoot2");
        brand.setStatus(1);

        boolean save = brandService.save(brand);
        System.out.println(save);
    }


}
