package com.ganga.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现 InfoContributor 接口
 */
@Component
public class AppInfoConfig implements InfoContributor {


    /**
     * 实现contribute方法
     *
     * @param builder
     */
    @Override
    public void contribute(Info.Builder builder) {

        //添加一条消息
        builder.withDetail("appName","brands_ssm");

        Map<String,Object> infos = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());
        infos.put("runTime",date);
        infos.put("author","尴尬酱");
        infos.put("信息","信息内容");

        //添加一个map 多个消息
        builder.withDetails(infos);
    }
}
