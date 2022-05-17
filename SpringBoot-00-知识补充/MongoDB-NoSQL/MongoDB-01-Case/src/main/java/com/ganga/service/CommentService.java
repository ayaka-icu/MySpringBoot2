package com.ganga.service;

import com.ganga.dao.CommentRepository;
import com.ganga.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        //调用dao
        commentRepository.save(comment);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void deleteByIdComment(String id){
        //调用dao
        commentRepository.deleteById(id);
    }

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findAllComments(){
        //调用dao
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }

    /**
     * 通过id查询评论
     * @param id
     * @return
     */
    public Comment findByIdComment(String id){
        //调用dao
        Comment comment = commentRepository.findById(id).get();
        //注意: 调用 findById(id)后再调用get()方法 返回实体类！
        return comment;
    }


    /**
     * 根据id 点赞数 +1
     * 这了使用MongoTemplate 效率过于 根据id去Update文档
     * @param id
     */
    public void updateCommentLikenum(String id){

        //设置条件
        Query query= Query.query(Criteria.where("_id").is(id));

        //更新数据
        Update update = new Update(); //update.set("key","value"); //局部更新，相当于$set
        update.inc("likenum");    //递增$inc

        //调用模板对象
        mongoTemplate.updateFirst(query,update,"comment");

    }


    /**
     * 根据父id查询分页列表
     * @param parentid 条件
     * @param page 第几页
     * @param size 每页最大数据
     * @return page对象
     */
    public Page<Comment> findPages(String parentid, int page , int size){

        return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));

    }



}
