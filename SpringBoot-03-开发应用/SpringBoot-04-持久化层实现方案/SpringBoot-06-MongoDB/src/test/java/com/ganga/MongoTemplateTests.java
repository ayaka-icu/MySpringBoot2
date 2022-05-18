package com.ganga;

import com.ganga.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class MongoTemplateTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void saveTest01() {

        Book book = new Book();
        //不指定主键
        book.setName("SpringBoot");
        book.setType("SpringBoot");
        book.setDescription("SpringBoot");

        mongoTemplate.save(book);
        //会生成一个 _class字段 java类型：com.ganga.pojo.Book
    }

    @Test
    void saveTest02() {

        Book book = new Book();
        book.setId("2");//指定主键
        book.setName("SpringBoot2");
        book.setType("SpringBoot2");
        book.setDescription("SpringBoot2");

        mongoTemplate.save(book);

    }


    @Test
    void findAll(){
        List<Book> books = mongoTemplate.findAll(Book.class);
        for (Book book : books) {
            System.out.println(book);
        }
        /** id有可能是 Object Bson类型 最好自己设置 id主键
         * Book(id=628511642b12577d4aa75b91, name=SpringBoot, type=SpringBoot, description=SpringBoot)
         * Book(id=2, name=SpringBoot2, type=SpringBoot2, description=SpringBoot2)
         */
    }

}
