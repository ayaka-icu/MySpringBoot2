package com.ganga.config;

import com.ganga.task.MyTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类是配置类 主要工作注入两Bean,同时声明调度器
 *      JobDetail 工作明细
 *      Trigger   触发器
 *      Scheduler
 */
@Configuration
public class QuartzConfig {

    //工作明细 JobDetail
    @Bean
    public JobDetail getJobDetail(){
        return JobBuilder.
                newJob(MyTask.class).//指定工作 Job
                storeDurably(). //用于持久化的
                build();//最终创建
    }

    //触发器 Trigger
    @Bean
    public Trigger getTrigger(){

        //创建调度器 Scheduler
        ScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");

        return TriggerBuilder.
                newTrigger().
                withSchedule(schedule).//绑定调度器
                forJob(getJobDetail()).//指定指定工作 就是调用上面的方法
                build();//最终创建
    }

}
