package com.ganga.server.impl;

import com.ganga.server.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgService {

    //模拟一个缓存
    private HashMap<Long,Integer> cache = new HashMap<>();

    @Override
    public int getAndSave(long tel) {

        //从缓存中找对应消息验证码
        Integer code = cache.get(tel);

        //判断是否为空
        if (code == null){

            //如果为空生成一个 6为数验证码
            int num = (int) ((Math.random() * 9 + 1)*100000);
            //添加到缓存当中
            cache.put(tel,num);
            //返回验证码
            return num;
        }

        //不为空 直接从缓存中返回验证码
        return code;
    }

    @Override
    public boolean check(long tel, int code) {

        //从缓存中找对应的验证码
        Integer num = cache.get(tel);

        //与用户输入的验证码进行匹配
        if (num == code){
            //验证成功
            return true;
        }

        //验证失败
        return false;
    }

}
