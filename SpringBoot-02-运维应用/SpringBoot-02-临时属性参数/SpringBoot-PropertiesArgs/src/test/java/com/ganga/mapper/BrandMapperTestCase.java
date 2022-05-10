package com.ganga.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ganga.ProApplication;
import com.ganga.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * BrandMapper测试用例
 */
@SpringBootTest(classes = ProApplication.class)
public class BrandMapperTestCase {

    //注入数据层对象
    @Autowired
    private BrandMapper brandMapper;

    @Test
    void selectList(){
        List<Brand> brands = brandMapper.selectList(null);
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    /**
     * 添加数据
     */
    @Test
    void insert(){
        Brand brand = new Brand();
        brand.setBrandName("原神");
        brand.setCompanyName("米哈游科技");
        brand.setOrdered(1);
        brand.setDescription("为美好的世界而战！");
        brand.setStatus(1);
        brandMapper.insert(brand);
        /**
         * 注意:
         *      MyBatis-Plus id是雪花算法 如果要使用数据库自增id的话
         *      在配置文件中设置
         */
    }

    /**
     * 通过id删除数据
     */
    @Test
    void deleteBatchIds(){
        /*Test:
        INSERT INTO tb_brand(brand_name,company_name,ordered,description,status)
            values ('test1','111',111,'111',0), ('test2','222',222,'222',0), ('test3','333',333,'333',0)
        */
        brandMapper.deleteBatchIds(Arrays.asList(11,12,13));
    }

    /**
     * 通过id更新数据
     */
    @Test
    void save(){
        Brand brand = new Brand();
        brand.setId(7);
        brand.setBrandName("腾讯游戏真辣鸡");
        brand.setOrdered(666666);
        brandMapper.updateById(brand);
    }


    /**
     * 通过id查询数据
     */
    @Test
    void selectById(){
        brandMapper.selectById(7);
    }

    /**
     * 分页查询
     */
    @Test
    void select1(){
        IPage page = new Page(1,4);
        brandMapper.selectPage(page,null);
        System.out.println("=================");
        System.out.println("getCurrent===>" + page.getCurrent());
        System.out.println("getSize===>" + page.getSize());
        System.out.println("getTotal===>" + page.getTotal());
        System.out.println("getPages===>" + page.getPages());
        System.out.println("getRecords===>" + page.getRecords());
    }

    /**
     * 分页查询
     */
    @Test
    void select2(){
        IPage page = new Page(3,4);
        brandMapper.selectPage(page,null);
        System.out.println("=================");
        System.out.println("getCurrent===>" + page.getCurrent());
        System.out.println("getSize===>" + page.getSize());
        System.out.println("getTotal===>" + page.getTotal());
        System.out.println("getPages===>" + page.getPages());
        System.out.println("getRecords===>" + page.getRecords());
    }

    /**
     * 按条件查询: 1
     */
    @Test
    void selectCondition01(){
        //查询brand_name带 "腾讯" 的数据
        QueryWrapper<Brand> qw = new QueryWrapper<>();
        qw.like("brand_name","腾讯");

        brandMapper.selectList(qw);
    }
    /*
    ==>  Preparing: SELECT id,brand_name,company_name,ordered,description,status FROM tb_brand WHERE (brand_name LIKE ?)
    ==>  Parameters: %腾讯%(String)
     */


    /**
     * 按条件查询: 2
     */
    @Test
    void selectCondition02(){
        String arg = null; //如果值为null 下面也没有判断是否为null 则会出现 %null% 是不愿看到的 应为 %%才对 可以添加一个 参数 != null 的判断
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
        /*if (arg != null)*/
        lqw.like(arg != null,Brand::getBrandName,arg);

        brandMapper.selectList(lqw);
    }


}
