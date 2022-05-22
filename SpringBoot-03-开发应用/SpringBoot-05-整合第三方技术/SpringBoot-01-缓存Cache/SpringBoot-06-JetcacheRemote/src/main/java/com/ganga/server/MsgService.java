package com.ganga.server;

import com.ganga.pojo.MsgCode;

public interface MsgService {

    String getAndSave(String tel);

    boolean check(MsgCode msgCode);

}
