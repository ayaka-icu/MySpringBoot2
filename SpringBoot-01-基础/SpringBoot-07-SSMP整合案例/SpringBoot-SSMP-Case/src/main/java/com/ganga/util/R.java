package com.ganga.util;

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

    //更过信息...

    public R(Boolean success){
        this.success = success;
    }

    public R(Boolean success,Object data){
        this.success = success;
        this.data = data;
    }

}
