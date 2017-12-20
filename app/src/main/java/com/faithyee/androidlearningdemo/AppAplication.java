package com.faithyee.androidlearningdemo;

import android.app.Application;

import com.faithyee.androidlearningdemo.ui.dagger2.component.AppComponent;
import com.faithyee.androidlearningdemo.ui.dagger2.component.DaggerAppComponent;
import com.faithyee.androidlearningdemo.ui.dagger2.module.ApiModule;

/**
 * Author：yewmf on 2017/12/20 16:52
 * E-mail：faith_yee@163.com
 */
public class AppAplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
