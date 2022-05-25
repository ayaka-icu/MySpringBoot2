package com.ganga.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    //绑定任务
    @Scheduled(cron = "0/2 * * * * ?")
    public void printStr(){
        System.out.println(Thread.currentThread().getName() + ": Spring Task Running ... ");
    }

    /**
     * SpringTask 使用很简单
     *  第一步: 开启任务 @Scheduling
     *  第二步: 在任务方法前绑定 @Scheduled
     *
     * 不过要注意:
     *  1. @Scheduled 里面使用 Cron表达式绑定触发时间
     *  2. @Scheduled 基于Spring容器 说在类必须是个bean
     *
     */

}
