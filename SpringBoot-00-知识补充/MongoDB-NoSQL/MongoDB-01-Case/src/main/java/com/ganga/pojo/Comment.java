package com.ganga.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

//指定文档名
@Document(collection = "comment")
//@CompoundIndex(def = "{'userid': 1, 'nickname': -1}") //符合索引
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id//指定主键
    private String id; //主键
    @Field("content") //该属性对应mongodb的字段的名字，如果一致，则无需该注解
    private String content; //吐槽内容
    private Date publishtime; //发布日期
    @Indexed//添加了一个单字段的索引
    private String userid; //发布人ID
    private String nickname; //昵称
    private LocalDateTime createdatetime; //评论的日期时间
    private Integer likenum; //点赞数
    private Integer replynum; //回复数
    private String state; //状态
    private String parentid; //上级ID
    private String articleid;

}
