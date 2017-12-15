package com.faithyee.androidlearningdemo.entity;

/**
 * eventBus消息类
 * Author：yewmf on 2017/12/14 17:11
 * E-mail：faith_yee@163.com
 */
public class EventBusMessage {

    public EventBusMessage(String message) {
        this.message = message;
    }

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
