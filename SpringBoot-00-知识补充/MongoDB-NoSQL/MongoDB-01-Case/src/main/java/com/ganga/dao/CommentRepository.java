package com.ganga.dao;

import com.ganga.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

// 继承 MongoRepository 泛型是<T,ID>  T:实体类对象  ID:主键类型
// 会自动代理注入 bean:  org.springframework.data.mongodb.repository.support.SimpleMongoRepository@696fad31
public interface CommentRepository extends MongoRepository<Comment,String> {

    /**
     * 根据父id，查询子评论的分页列表
     * @param parentid 条件
     * @param pageable
     * @return
     */
    Page<Comment> findByParentid(String parentid, Pageable pageable);


}
