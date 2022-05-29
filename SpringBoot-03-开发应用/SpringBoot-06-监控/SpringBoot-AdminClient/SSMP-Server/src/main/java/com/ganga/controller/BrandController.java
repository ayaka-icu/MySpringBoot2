package com.ganga.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ganga.pojo.Brand;
import com.ganga.service.IBrandService;
import com.ganga.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 基于 Restful 风格
 */

@RestController()
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    //查询所有
    @GetMapping
    public R selectAll(){
        return new R(true,brandService.list());
    }

    //通过id查询
    @GetMapping("/{id}")
    public R selectById(@PathVariable Integer id){
        return new R(true,brandService.getById(id));
    }

    //条件查询
    @GetMapping("/{current}/{age}")
    public R selectCondition(@PathVariable Integer current,@PathVariable Integer age,Brand brand){
        //判断要查询的页码数 是否 大于最大页码数
        IPage<Brand> page = brandService.getPageCondition(current, age,brand);
        if (page.getCurrent() > page.getPages()){
            //如果超过最大页码数 则会查询最大页码数 即最后一页
            page = brandService.getPageCondition((int) page.getPages(),age,brand);
        }
        return new R(true,page);
    }

    //添加数据
    @PostMapping
    public R save(@RequestBody Brand brand) throws IOException {
        //模拟抛出异常
        if ("exc".equals(brand.getBrandName())) throw new IOException();
        boolean is = brandService.save(brand);
        return new R(is, is ? "商品添加成功！^_^" : "商品添加失败！T_T");
    }

    //通过id删除
    @DeleteMapping("/{id}") //请求体路径参数 restful风格参数
    public R deleteById(@PathVariable Integer id){
        boolean is = brandService.removeById(id);
        return new R(is, is ? "商品删除成功。^_^":"商品删除失败。T_T");
    }

    //批量删除
    @DeleteMapping() //请求体路径参数 restful风格参数
    public R deleteBatchByIds(@RequestBody List<Integer> list){
        boolean is = brandService.removeBatchByIds(list);
        return new R(is,is ? "批量删除成功！^_^":"批量删除失败！T_T");
    }

    //更新数据
    @CrossOrigin
    @PutMapping
    public R update(@RequestBody Brand brand){
        boolean is = brandService.updateById(brand);
        return new R(is,is ? "当前商品信息已更新, ^_^ 已自动刷新页面~ ":"商品信息更新失败!T_T");
    }

    //分页查询
    /*@GetMapping("/{current}/{age}")
    public R selectPage(@PathVariable Integer current,@PathVariable Integer age){
        //判断要查询的页码数 是否 大于最大页码数
        IPage<Brand> page = brandService.getPage(current, age);
        if (page.getCurrent() > page.getPages()){
            //如果超过最大页码数 则会查询最大页码数 即最后一页
            page = brandService.getPage((int) page.getPages(),age);
        }
        return new R(true,page);
    }*/


}
