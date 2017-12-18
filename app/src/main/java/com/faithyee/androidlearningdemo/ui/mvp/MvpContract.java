package com.faithyee.androidlearningdemo.ui.mvp;

/**
 * Author：yewmf on 2017/12/18 10:13
 * E-mail：faith_yee@163.com
 */
public interface MvpContract {


    interface View <Presenter>{
        public void commitSuccess(String result);

        public void commitFailed(String result);
    }

    interface Presenter{

        public void login(String name, String pw);
    }

}
