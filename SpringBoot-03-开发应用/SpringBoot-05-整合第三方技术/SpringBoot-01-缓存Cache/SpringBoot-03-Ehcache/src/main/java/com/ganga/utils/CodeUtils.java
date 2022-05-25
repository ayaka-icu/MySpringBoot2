package com.ganga.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private String [] patch = {"000000","00000","0000","000","00","0",""};

    // 生成验证码
    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    /**
     * 根据key 取 缓存中的验证码
     * 如果没有 缓存一个 tal = null
     * @param tel
     * @return
     */
    @Cacheable(value = "msgCacheSpace", key = "#tel")
    public String getCacheCode(String tel){
        return null;
    }


}

