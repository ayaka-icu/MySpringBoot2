package com.ganga.controller.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {

    public final Logger log;


    public BaseClass(){
        this.log = LoggerFactory.getLogger(this.getClass());
    }

}
