package com.ganga.server.impl;

import com.ganga.pojo.MsgCode;
import com.ganga.server.MsgService;
import com.ganga.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private CodeUtils codeUtils;


    @Override
    //CachePut 只放不取 而 Cacheable放入数据 有的话 不会执行方法内部 直接返回缓存中的数据
    @CachePut(value = "msgCacheSpace",key = "#tel")
    public String getAndSave(String tel) {

        //生成 并 返回这个验证码
        return codeUtils.generator(tel);
    }


    @Override
    public boolean check(MsgCode msgCode) {
        //用户输入的验证码
        String code = msgCode.getCode();
        //缓存中的验证码
        String cacheCode = codeUtils.getCacheCode(msgCode.getTal());
        //判断并返回
        return code.equals(cacheCode); //cacheCode可能为null 放在后面
    }


    //int num = (int) ((Math.random() * 9 + 1)*100000);

}
