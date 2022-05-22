package com.ganga.server.impl;

import com.ganga.pojo.MsgCode;
import com.ganga.server.MsgService;
import com.ganga.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;


    //注入memcached客户端
    @Autowired
    private MemcachedClient memcachedClient;


    @Override
    public String getAndSave(String tel) {

        String code = codeUtils.generator(tel);
        System.out.println(code);
        try { //存入缓存中
            memcachedClient.set(tel, 20, code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //生成 并 返回这个验证码
        return code;
    }


    @Override
    public boolean check(MsgCode msgCode) {
        //用户输入的验证码
        String code = msgCode.getCode();
        System.out.println("user===>" + code);
        //缓存中的验证码
        String cacheCode = null;
        try {
            cacheCode = memcachedClient.get(msgCode.getTal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cache===>" + cacheCode);
        //判断并返回
        return code.equals(cacheCode); //cacheCode可能为null 放在后面
    }


    //int num = (int) ((Math.random() * 9 + 1)*100000);

}
