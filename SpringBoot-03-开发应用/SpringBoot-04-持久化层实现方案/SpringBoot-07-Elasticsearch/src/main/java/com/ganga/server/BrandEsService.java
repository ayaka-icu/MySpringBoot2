package com.ganga.server;

import com.ganga.dao.BrandRepository;
import com.ganga.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandEsService{

    @Autowired
    private BrandRepository brandRepository;

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Brand getById(String id){
        return brandRepository.findById(id).get();
    }

    /**
     * 查询所有
     * @return
     */
    public Iterable<Brand> getAll(){
        return brandRepository.findAll();
    }

    /**
     * 保存
     * @param brand
     */
    public void save(Brand brand){
        Brand save = brandRepository.save(brand);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void deleteById(String id){
        brandRepository.deleteById(id);
    }


}
