package com.ganga.server.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.ganga.pojo.MsgCode;
import com.ganga.server.MsgService;
import com.ganga.utils.CodeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;

    /**
     * cacheType = CacheType.REMOTE 设置缓存是远程缓存 默认就是远程缓存
     *
     * CacheType.REMOTE 远程缓存
     * CacheType.Local  本地缓存
     * CacheType.BOTH   远程与本地同时
     *
     */
    //创建一个缓存空间
    @CreateCache(area = "env1",name = "msg_",expire = 20,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.REMOTE)
    private Cache<String,String> msgCache;
    // mame缓存空间名称 expire失效时间默认单位秒 timeUnit失效时间单位
    // area指定所使用的环境 不写是默认环境

    @Override
    public String getAndSave(String tel) {

        String code = codeUtils.generator(tel);
        msgCache.put(tel,code);

        return code;
    }


    @Override
    public boolean check(MsgCode msgCode) {
        //从缓存中获取验证码
        String code = msgCache.get(msgCode.getTal());
        System.out.println(code);
        //比较并返回
        return msgCode.getCode().equals(code);
    }


    //int num = (int) ((Math.random() * 9 + 1)*100000);

}
