package com.ganga.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//前后端统一处理异常消息
//统一后端处理异常消息
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //要处理的异常   返回异常处理后的消息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){

        //各种异常处理逻辑 如：
        //记录日志
        //通知运维
        //通知开发

        //最后别忘了打印异常
        ex.printStackTrace();

        //返回数据
        return new R("服务器点小意外, 或请重新刷新页面！");
    }

}
