package com.ganga.server;

public interface MsgService {

    int getAndSave(long tel);

    boolean check(long tel,int code);

}
