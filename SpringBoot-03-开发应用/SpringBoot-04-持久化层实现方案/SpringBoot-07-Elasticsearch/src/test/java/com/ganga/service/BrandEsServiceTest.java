package com.ganga.service;

import com.ganga.pojo.Brand;
import com.ganga.server.BrandEsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandEsServiceTest {

    @Autowired
    private BrandEsService brandEsService;

    @Test
    void getByIdTest(){
        Brand byId = (Brand) brandEsService.getById("1");
        System.out.println(byId);
    }

    @Test
    void getAllTest(){

        Iterable<Brand> brands = brandEsService.getAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }

    }

    @Test
    void saveTest(){
        Brand brand = new Brand();
        brand.setId("666");
        brand.setBrandName("test666");
        brand.setCompanyName("test666");
        brand.setDescription("test666");
        brand.setOrdered(0);
        brand.setStatus(0);

        brandEsService.save(brand);
    }

    @Test
    void deleteByIdTest(){
        brandEsService.deleteById("666");
    }


}
