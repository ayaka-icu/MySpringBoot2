package com.ganga.mapper;

import com.ganga.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrandMapper {

    @Select("select * from brand where id = #{id};")
    Brand getById(Integer id);

}
 