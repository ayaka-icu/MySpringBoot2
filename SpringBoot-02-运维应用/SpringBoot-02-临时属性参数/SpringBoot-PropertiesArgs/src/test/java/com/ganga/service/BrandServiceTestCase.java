package com.ganga.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ganga.ProApplication;
import com.ganga.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = ProApplication.class)
public class BrandServiceTestCase {

    @Autowired
    private BrandService brandService;

    //新建 添加数据
    @Test
    public void TestSaver() {
        Brand brand = new Brand();
        brand.setBrandName("原神");
        brand.setCompanyName("米哈游科技");
        brand.setOrdered(1);
        brand.setDescription("为美好的世界而战！");
        brand.setStatus(1);

        boolean saver = brandService.saver(brand);
        System.out.println(saver);
    }

    //通过id删除
    @Test
    public void TestDeleteById() {
        Integer id = 8;
        boolean b = brandService.deleteById(8);
        System.out.println(b);
    }

    //批量删除
    @Test
    public void TestDeleteIds() {
        /*Test:
        INSERT INTO tb_brand(brand_name,company_name,ordered,description,status)
            values ('test1','111',111,'111',0), ('test2','222',222,'222',0), ('test3','333',333,'333',0)
        */
        List<Integer> ids = Arrays.asList(9, 10, 11);
        boolean b = brandService.deleteIds(ids);
        System.out.println(b);
    }

    //更新 修改
    @Test
    public void TestUpdate() {
        Brand brand = new Brand();
        brand.setId(7);
        brand.setBrandName("腾讯游戏真辣鸡");
        brand.setOrdered(666666);

        boolean update = brandService.update(brand);
        System.out.println(update);
    }

    //查询所有数据
    @Test
    public void TestSelectAll() {
        List<Brand> brands = brandService.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    //分页查询
    @Test
    public void TestSelectPage() {
        Integer currentPage = 2;
        Integer sizePage = 5;
        IPage<Brand> page = brandService.selectPage(currentPage, sizePage);
        System.out.println("getCurrent===>" + page.getCurrent());
        System.out.println("getSize===>" + page.getSize());
        System.out.println("getTotal===>" + page.getTotal());
        System.out.println("getPages===>" + page.getPages());
        System.out.println("getRecords===>");
        List<Brand> records = page.getRecords();
        for (Brand record : records) {
            System.out.println(record);
        }
    }

}
