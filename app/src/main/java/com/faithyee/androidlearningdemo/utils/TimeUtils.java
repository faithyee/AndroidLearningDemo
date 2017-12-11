package com.faithyee.androidlearningdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author：yewmf on 2017/12/11 15:37
 * E-mail：faith_yee@163.com
 */
public class TimeUtils {

    public static String getNowtime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
