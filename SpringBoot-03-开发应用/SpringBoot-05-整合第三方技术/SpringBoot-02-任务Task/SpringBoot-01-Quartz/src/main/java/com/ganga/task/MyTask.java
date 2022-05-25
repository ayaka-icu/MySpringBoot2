package com.ganga.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 工作Job 任务
 * 继承 QuartzJobBean
 */
public class MyTask extends QuartzJobBean {
    /*

    * 任务的具体方法 Job
    * */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz task running ...");
    }

}
