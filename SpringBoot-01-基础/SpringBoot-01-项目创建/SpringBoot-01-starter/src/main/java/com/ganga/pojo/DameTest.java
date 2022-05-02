package com.ganga.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //生成setter/getter、equals、canEqual、hashCode、toString方法
@NoArgsConstructor //生成无参构造
@AllArgsConstructor //生成全参构造
//@ToString //生成toString()方法
public class DameTest {

    private String name;
    private Integer age;
    private String arr;

}
