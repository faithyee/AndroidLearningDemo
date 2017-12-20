package com.faithyee.androidlearningdemo.ui.dagger2.module;

import com.faithyee.androidlearningdemo.ui.okhttp.OkhttpDemoAct;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Author：yewmf on 2017/12/20 17:52
 * E-mail：faith_yee@163.com
 */
@Module
public class ApiModule {

    private String weather_url = "https://free-api.heweather.com/";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(8, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(8, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        OkHttpClient client = builder.build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weather_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }




}
