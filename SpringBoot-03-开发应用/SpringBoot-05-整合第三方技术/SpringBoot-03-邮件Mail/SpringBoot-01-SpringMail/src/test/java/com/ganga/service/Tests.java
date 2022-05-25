package com.ganga.service;

import com.ganga.mail.AnnexMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tests {

    @Autowired
    private AnnexMail annexMail;

    @Test
    void me(){
        annexMail.sendMail();
    }

}
