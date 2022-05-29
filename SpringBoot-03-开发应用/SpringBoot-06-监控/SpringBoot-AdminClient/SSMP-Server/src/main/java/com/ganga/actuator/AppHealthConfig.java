package com.ganga.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 继承 AbstractHealthIndicator 抽象方法
 */
@Component
public class AppHealthConfig extends AbstractHealthIndicator {

    /**
     * 实现 doHealthCheck方法
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        //具体的逻辑
        boolean condition = false;

        if (condition){
            builder.withDetail("尴尬","尴尬了");
            builder.withDetail("runTim",new Date(System.currentTimeMillis()));
            builder.withDetail("brands","ssm");
            builder.status(Status.UP); //设置状态为正常
        }else{
            builder.withDetail("务器开了吗？","没开玩个锤子");
            builder.status(Status.DOWN); //设置状态为错误
        }


    }
}
