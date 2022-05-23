package com.ganga.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {
/*
* Cache<Integer,Brand>  Brand要实现序列化接口
* */

    private String id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;

}
