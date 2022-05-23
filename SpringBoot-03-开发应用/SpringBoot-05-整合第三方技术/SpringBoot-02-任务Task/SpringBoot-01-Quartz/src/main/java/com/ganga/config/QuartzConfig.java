package com.ganga.config;

import com.ganga.task.MyTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    //工作明细 JobDetail
    @Bean
    public JobDetail getJobDetail(){
        return JobBuilder.
                newJob(MyTask.class).//指定工作 Job
                storeDurably().
                build();//最终创建
    }

    //触发器
    @Bean
    public Trigger getTrigger(){

        //创建触发器
        ScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");

        return TriggerBuilder.
                newTrigger().
                withSchedule(schedule).
                forJob(getJobDetail()).//指定指定工作 就是调用上面的方法
                build();//最终创建
    }

}
