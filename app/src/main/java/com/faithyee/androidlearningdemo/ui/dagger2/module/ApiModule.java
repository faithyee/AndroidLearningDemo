package com.faithyee.androidlearningdemo.ui.dagger2.module;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
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

    String mBaseUrl;

    public ApiModule(String baseUrl){
        this.mBaseUrl = baseUrl;
    }

    /**
     * 组件内的内部关联,该方法的返回值，直接提供给provideOkHttpClient(Cache cache)使用了
     * @return
     */
    @Singleton
    @Provides
    Cache provideOkHttpCache(){
        //okhttp 缓存
        final long cacheSize = 1024 * 1024 * 20;// 缓存文件最大限制大小20M
        String cacheDirectory = Environment.getExternalStorageDirectory() + "/okhttpcache"; // 设置缓存文件路径,/sdcard目录下
        Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
        return cache;
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache){
        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(8, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(8, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        builder.cache(cache);
        OkHttpClient client = builder.build();
        return client;
    }


    @Provides
    @Singleton
    Retrofit provideRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }




}
