package com.faithyee.androidlearningdemo.ui.otto;

import com.squareup.otto.Bus;

/**
 * 相当于EventBus类
 * Author：yewmf on 2017/12/15 09:36
 * E-mail：faith_yee@163.com
 */
public class OttoBus extends Bus {

    public static volatile OttoBus instance;

    private OttoBus() {

    }

    public static OttoBus getInstance() {

        if (instance == null) {

            synchronized (OttoBus.class) {

                if (instance == null) {
                    instance = new OttoBus();
                }
            }
        }

        return instance;

    }


}
