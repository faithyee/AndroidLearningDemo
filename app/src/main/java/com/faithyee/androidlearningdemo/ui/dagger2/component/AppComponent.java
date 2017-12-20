package com.faithyee.androidlearningdemo.ui.dagger2.component;

import com.faithyee.androidlearningdemo.ui.dagger2.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Author：yewmf on 2017/12/20 18:00
 * E-mail：faith_yee@163.com
 * 该组件在AppAplication里进行依赖注入
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    OkHttpClient getClient();

    Retrofit getRetrofit();

}
