package com.faithyee.androidlearningdemo.ui.mvp;

import com.faithyee.androidlearningdemo.entity.HotMovies;

/**
 * Author：yewmf on 2017/12/18 16:31
 * E-mail：faith_yee@163.com
 */
public interface NetworkCallback {

    void onSuccess(HotMovies data);
    void onFailure(int code, String msg);

}
