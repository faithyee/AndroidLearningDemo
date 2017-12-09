package com.faithyee.androidlearningdemo.ui.okhttp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 1、get
 * 2、post
 * 3、缓存使用
 */
public class OkhttpDemoAct extends AppCompatActivity {

    private static final String TAG = "OkhttpDemoAct";
    private static OkHttpClient client;
    private String weather_url = "https://free-api.heweather.com/s6/weather/now";
    private TextView result;


    //okhttp 缓存
    private static final long cacheSize = 1024 * 1024 * 20;// 缓存文件最大限制大小20M
    private static String cacheDirectory = Environment.getExternalStorageDirectory() + "/okhttpcache"; // 设置缓存文件路径,/sdcard目录下
    private static Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //

    static {
        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(8, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(8, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        builder.cache(cache);// 设置缓存
        builder.addNetworkInterceptor(new CacheInterceptor());//缓存拦截器,通过这个设置maxAge与maxStale  !!!
        client = builder.build();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_okhttp_demo);
        result = (TextView) findViewById(R.id.result);

    }

    public void get(View v){
        result.setText("");
        Request.Builder requestBuilder = new Request.Builder()
                //以下是三种缓存策略：maxAge、maxStale、FORCE_NETWORK（必须使用网络）、FORCE_CACHE（只使用缓存）
//                .cacheControl(new CacheControl.Builder().maxStale(10, TimeUnit.SECONDS).build())
//                .cacheControl(new CacheControl.Builder().maxAge(cache_maxAge_inSeconds, TimeUnit.SECONDS).build())
//                .cacheControl( CacheControl.FORCE_NETWORK)
//                .cacheControl( CacheControl.FORCE_CACHE)
                .url(weather_url + "?location=beijing&key=e530e075e7a74c89aed52d3cd87e4268");
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mCall = client.newCall(request);
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.i(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str;

                if (response.isSuccessful()) {

                    str = "responseBody:" + response.body().string();
                } else {
                    if(response.cacheResponse()!=null){
                        //直接读取缓存
                        str = "Cache responseBody:" + response.cacheResponse().body().string();

                    }else {
                        str = "responseBody: response失败了，连接状态码为" + response.code();

                    }
                }


                LogUtils.i(TAG, str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(str);
                    }
                });
            }
        });
    }

    public void post(View v){
        result.setText("");
        FormBody postParams = new FormBody.Builder()
                .add("location", "shenzhen")
                .add("key", "e530e075e7a74c89aed52d3cd87e4268")
                .build();
        Request request = new Request.Builder()
                .url(weather_url)
                .post(postParams)
                .build();
        Call mCall = client.newCall(request);
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.i(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = "responseBody:" + response.body().string();
                LogUtils.i(TAG, str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(str);
                    }
                });
            }
        });

    }

    /**
     * 缓存拦截器
     */
    private static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Response originResponse = chain.proceed(chain.request());

            //设置缓存时间为，并移除了pragma消息头，移除它的原因是因为pragma也是控制缓存的一个消息头属性
            return originResponse.newBuilder().removeHeader("pragma")
                    .header("Cache-Control", "max-age=10")//设置10秒
                    .header("Cache-Control", "max-stale=30").build();
        }
    }

}
