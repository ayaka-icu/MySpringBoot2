package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EhcacheTests {

    @Test
    void contextLoads() {
        for (int i = 0; i < 20; i++) {
            double v = (Math.random() * 9 + 1) * 100000;
            System.out.println((int)v);
        }
    }

}
