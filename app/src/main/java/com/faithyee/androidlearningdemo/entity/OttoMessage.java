package com.faithyee.androidlearningdemo.entity;

import java.io.Serializable;

/**
 * otto消息类
 * Author：yewmf on 2017/12/15 09:34
 * E-mail：faith_yee@163.com
 */
public class OttoMessage implements Serializable {

    private String message;

    public OttoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
