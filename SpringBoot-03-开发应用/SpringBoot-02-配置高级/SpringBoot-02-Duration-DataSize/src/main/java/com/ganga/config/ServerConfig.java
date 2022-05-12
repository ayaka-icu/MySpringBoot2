package com.ganga.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@ConfigurationProperties(prefix = "ganga")
public class ServerConfig {

    private String ipAddress;
    private int port;
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
