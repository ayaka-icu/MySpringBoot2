package com.ganga.server.impl;

import com.ganga.pojo.MsgCode;
import com.ganga.server.MsgService;
import com.ganga.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;

    //注入缓存对象
    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String getAndSave(String tel) {
        //获取加密验证码
        String code = codeUtils.generator(tel);
        //放入缓存对象
        cacheChannel.set("msgCacheSpace",tel,code);
        return code;
    }


    @Override
    public boolean check(MsgCode msgCode) {
        //获取用户输入的验证码
        String code = msgCode.getCode();
        //获取缓存中对应的验证码
        String codeCache = cacheChannel.get("msgCacheSpace", msgCode.getTal()).asString();
        //判断并返回
        return code.equals(codeCache);
    }


}
