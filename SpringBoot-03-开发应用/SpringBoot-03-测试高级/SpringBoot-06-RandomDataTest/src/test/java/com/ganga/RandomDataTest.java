package com.ganga;

import com.ganga.config.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RandomDataTest {

    @Test
    void me(@Autowired TestCase testCase) {

        System.out.println(testCase);

    }

}
