package com.ganga.service;

import com.ganga.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class CommentServiceTests {


    @Autowired
    private CommentService commentService;

    //新增评论
    @Test
    void saverCommentTest(){
        Comment comment = new Comment();
        comment.setId("xxxxxxxx"); //不设置id 会自动生成
        comment.setContent("test");
        comment.setPublishtime(new Date());
        comment.setUserid("test");
        comment.setNickname("test");
        comment.setCreatedatetime(null);
        comment.setLikenum(666);
        comment.setReplynum(666);
        comment.setState("test");
        comment.setParentid("test");
        comment.setArticleid("test");
        commentService.saveComment(comment);
    }

    //更新评论
    @Test
    void updateCommentTest(){
        Comment comment = new Comment();
        comment.setId("xxxxxxxx"); //设置集合中已存在的id
        comment.setContent("test666");
        comment.setPublishtime(new Date());
        comment.setUserid("test666");
        comment.setNickname("test666");
        comment.setCreatedatetime(null);
        comment.setLikenum(666);
        comment.setReplynum(666);
        comment.setState("test666");
        comment.setParentid("test666");
        comment.setArticleid("test666");
        commentService.updateComment(comment);
    }


    //根据id删除评论
    @Test
    void deleteByIdCommentTest(){
        String id = "xxxxxxxx";
        commentService.deleteByIdComment(id);
    }


    //查询所有评论
    @Test
    void findAllCommentsTest(){
        List<Comment> comments = commentService.findAllComments();
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    //根据id查询评论
    @Test
    void findByIdCommentTest(){
        String id = "1";
        Comment comment = commentService.findByIdComment(id);
        System.out.println(comment);
    }

    //根据id 点赞数 +1
    @Test
    void updateCommentLinknumTest(){
        String id = "1";
        //调用6次
        commentService.updateCommentLikenum(id);
        commentService.updateCommentLikenum(id);
        commentService.updateCommentLikenum(id);
        commentService.updateCommentLikenum(id);
        commentService.updateCommentLikenum(id);
        commentService.updateCommentLikenum(id);
    }


    //分页查询
    @Test
    void findPagesTest(){
        String parentid = "33"; //查询条件 {parentid:"33"}
        int page = 1; //查询第一页
        int size = 2; //每页最大为2条文档
        Page<Comment> pages = commentService.findPages("33", page, size);

        // 获取当前共几页
        System.out.println(pages.getTotalPages());
        // 获取条件查询出多少文档
        System.out.println(pages.getTotalElements());
        // 获取每页最大多少条文档
        System.out.println(pages.getSize());

        // 获取添加查询 本分页后的数据
        List<Comment> comments = pages.getContent();
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }




}
