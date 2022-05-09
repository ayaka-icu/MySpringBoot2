package com.ganga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProApplication {

    public static void main(String[] args) {

        //方式一: 通过cmd运行时加入：java -jar 工程文件jar包.jar --server.port=66 --参数k=参数v
        //方式二：在开发环境 idea 中 [运行/调试配置] 中配置 配置 [程序参数]

        //方式三:

        //切断外界的临时参数的传入，提高安全性
        //SpringApplication.run(SSMPApplication.class/*, args*/);
        //或者传入非main的args 而是 传入内部要调试的传数

        System.out.println("==========");
        SpringApplication.run(ProApplication.class,test());

    }

    /**
     * 调试临时参数
     * @return 临时参数
     */
    private static String[] test(){

        //调试临时参数
        String[] args = new String[]{
                //端口号
                "--server.port=123"
                //......
        };

        return args;
    }

}
