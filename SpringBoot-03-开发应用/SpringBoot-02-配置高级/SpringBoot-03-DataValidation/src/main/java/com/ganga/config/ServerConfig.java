package com.ganga.config;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@ConfigurationProperties(prefix = "ganga")

//第二步：给类添加@Validated注解
@Validated
public class ServerConfig {

    //第三步：给数据添加校验注解
    @Length(max = 12,min = 6,message = "ip地址最大12字符 最小6字符")
    private String ipAddress;
    @Max(value = 8888,message = "端口号最大值不能超过8888")
    @Min(value = 202, message = "端口号最小值不能小于202")
    private int port;
    //@NonNull
    private long timeOut;

    //jdk8: 引入时间存储数据
    private Duration serverTimeOut01;

    //jdk8: 引入空间存储数据
    private DataSize logSize01;

    //设置为小时
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut02;

    //设置为MB
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize logSize02;



}
