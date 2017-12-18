package com.faithyee.androidlearningdemo.ui.mvp;


/**
 * Created by xiaochuang on 4/30/16.
 */
public class PasswordValidator {
    
    public PasswordValidator() {
    }

    public boolean verify(String name, String password) {
        //假设这个方法需要联网

        return "654321".equals(password) && name.equals("123456");
    }
}
