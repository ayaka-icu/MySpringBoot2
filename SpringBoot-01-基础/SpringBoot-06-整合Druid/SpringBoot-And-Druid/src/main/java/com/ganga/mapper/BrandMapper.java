package com.ganga.mapper;

import com.ganga.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("select * from tb_brand where id = #{id};")
    Brand getById(Integer id);

    @Select("select * from tb_brand;")
    List<Brand> selectAll();

}
 