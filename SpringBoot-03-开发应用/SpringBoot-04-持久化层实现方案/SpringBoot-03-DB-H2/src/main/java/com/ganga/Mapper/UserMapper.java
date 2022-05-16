package com.ganga.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ganga.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("update USER set id = #{id} where name = #{name} ;")
    int updateByName(String name,Integer id);

}
