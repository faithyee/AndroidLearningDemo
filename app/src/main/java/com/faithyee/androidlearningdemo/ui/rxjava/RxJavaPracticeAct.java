package com.faithyee.androidlearningdemo.ui.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.entity.Weather;
import com.faithyee.androidlearningdemo.ui.rxjava.retrofit.MovieService;
import com.faithyee.androidlearningdemo.utils.LogUtils;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RxJavaPracticeAct extends AppCompatActivity {

    private static final String TAG = "RxJavaPracticeAct";
    private TextView result;
    private static OkHttpClient client;
    private String weather_url = "https://free-api.heweather.com/s6/weather/now";
    private String hot_moive_url = "https://api-m.mtime.cn/";
    private StringBuffer sb;


    static {
        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(8, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(8, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        client = builder.build();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rx_java_practice);
        sb = new StringBuffer();
        result = (TextView) findViewById(R.id.result);
    }


    /**
     * 请求网络接口
     * 1）通过 Observable.create() 方法，调用 OkHttp 网络请求；
     * 2）通过 map 操作符集合 gson，将 Response 转换为 bean 类；
     * 3）通过 doOnNext() 方法，解析 bean 中的数据，并进行数据库存储等操作；
     * 4）调度线程，在子线程中进行耗时操作任务，在主线程中更新 UI ；
     * 5）通过 subscribe()，根据请求成功或者失败来更新 UI 。
     * @param v
     */
    public void checkApi(View v){
        clear();

        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Response> e) throws Exception {

                showLog("Observable subscribe : current thread id = " + Thread.currentThread().getId() + "\n");

                Request.Builder requestBuilder = new Request.Builder()
                        .url(weather_url + "?location=beijing&key=e530e075e7a74c89aed52d3cd87e4268");
                requestBuilder.method("GET", null);
                Request request = requestBuilder.build();
                Call mCall = client.newCall(request);
                Response response = mCall.execute();
                e.onNext(response);
            }
        }).map(new Function<Response, Weather>() {
            @Override
            public Weather apply(@NonNull Response response) throws Exception {

                if(response.isSuccessful()){
                    showLog("Observable map : current thread id = " + Thread.currentThread().getId() + "\n");
                    Weather weather = new Gson().fromJson(response.body().string(),Weather.class);
                    return weather;
                }else {
                    return null;
                }
            }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(new Consumer<Weather>() {
            @Override
            public void accept(Weather weather) throws Exception {
                showLog("doOnNext accept : current thread id = " + Thread.currentThread().getId() + "\n");
                showLog("doOnNext save data Weather==="+weather.getHeWeather6().get(0).getBasic().toString() + " successed!!\n");
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Weather>() {
            @Override
            public void accept(Weather weather) throws Exception {
                showLog("Consumer accept : current thread id = " + Thread.currentThread().getId() + "\n");
                showLog("Weather===" + weather.getHeWeather6().get(0).getBasic().toString() + "\n");
                result.setText(sb.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //请求失败回调
                showLog("Consumer accept : current thread id = " + Thread.currentThread().getId() + "\n");
                showLog("Consumer accept : error");
                result.setText(sb.toString());
            }
        });

    }


    /**
     * RxJava + Retrofit 请求网络
     * @param v
     */
    public void doRxjavaAndRetrofit(View v){
        clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(hot_moive_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Observable<HotMovies> observable = movieService.getHotMovies("366");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotMovies>() {
                    @Override
                    public void accept(HotMovies hotMovies) throws Exception {
                        showLog("observable accept hotMovies===" + hotMovies.toString() + "\n");
                        result.setText(sb.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        showLog("observable accept error : " + throwable.getMessage());
                        result.setText(sb.toString());
                    }
                });
    }

    public void clear(){
        result.setText("");
    }

    public void showLog(String str){
        sb.append(str + "\n");
        LogUtils.i(TAG, str + "\n");
    }
}

