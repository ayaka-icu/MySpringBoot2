package com.ganga.controller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端 同意响应数据格式
 */
@Data
@NoArgsConstructor
public class R {

    //是否成功
    private Boolean success;

    //响应数据
    private Object data;

    //异常消息
    private String msg;

    //更过信息...


    /**
     * 业务是否成功
     * @param success true --> 成功
     */
    public R(Boolean success){
        this.success = success;
    }

    /**
     * 业务是否成功 并 响应前端传入数据
     * @param success true --> 成功
     * @param data 存入前端的数据
     */
    public R(Boolean success,Object data){
        this.success = success;
        this.data = data;
    }

    /**
     * 业务是否成功 并 传入相应的通知消息
     * @param success
     * @param msg
     */
    public R(Boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }

    /**
     * 异常
     * @param msg 异常消息
     */
    public R(String msg){
        this.success = false; //异常 操作失败
        this.msg = msg;
    }


}
