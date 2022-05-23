package com.ganga.server;

import com.ganga.pojo.Brand;

public interface BrandService{

    Brand getByIdDemo01(int id);

    Brand getByIdDemo02(int id);


    boolean save(Brand brand);

    boolean updateById(Brand brand);

    boolean deleteById(int id);

}
