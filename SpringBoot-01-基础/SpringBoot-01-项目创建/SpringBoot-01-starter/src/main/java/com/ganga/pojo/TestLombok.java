package com.ganga.pojo;

import org.junit.Test;

public class TestLombok {

    @Test
    public void meTest(){
        DameTest d1 = new DameTest("ganga", 18, "游郭");
        System.out.println(d1.getName());
        System.out.println(d1.getArr());
        System.out.println(d1.getAge());
        d1.toString();
    }

}
