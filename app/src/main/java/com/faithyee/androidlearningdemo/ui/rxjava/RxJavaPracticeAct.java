package com.faithyee.androidlearningdemo.ui.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.entity.MovieDetails;
import com.faithyee.androidlearningdemo.entity.Weather;
import com.faithyee.androidlearningdemo.ui.rxjava.retrofit.MovieService;
import com.faithyee.androidlearningdemo.utils.ACache;
import com.faithyee.androidlearningdemo.utils.LogUtils;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
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
    private String movie_details_url = "https://ticket-api-m.mtime.cn/";
    private StringBuffer sb;
    private boolean isFromNet;
    private ACache mAcache;
    private String movie_cache_name = "hotMovies";


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
        mAcache = ACache.get(this);
    }


    /**
     * 请求网络接口
     * 1）通过 Observable.create() 方法，调用 OkHttp 网络请求；
     * 2）通过 map 操作符集合 gson，将 Response 转换为 bean 类；
     * 3）通过 doOnNext() 方法，解析 bean 中的数据，并进行数据库存储等操作；
     * 4）调度线程，在子线程中进行耗时操作任务，在主线程中更新 UI ；
     * 5）通过 subscribe()，根据请求成功或者失败来更新 UI 。
     *
     * @param v
     */
    public void checkApi(View v) {
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

                if (response.isSuccessful()) {
                    showLog("Observable map : current thread id = " + Thread.currentThread().getId() + "\n");
                    Weather weather = new Gson().fromJson(response.body().string(), Weather.class);
                    return weather;
                } else {
                    return null;
                }
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) throws Exception {
                        showLog("doOnNext accept : current thread id = " + Thread.currentThread().getId() + "\n");
                        showLog("doOnNext save data Weather===" + weather.getHeWeather6().get(0).getBasic().toString() + " successed!!\n");
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
     *
     * @param v
     */
    public void doRxjavaAndRetrofit(View v) {
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

    /**
     * 使用concat模拟：先读取缓存，如果缓存没数据再通过网络请求获取数据后更新UI
     *
     * @param v
     */
    public void doReadCacheBeforeNet(View v) {
        clear();
        Observable.concat(getCacheObservable(), getNetObservable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotMovies>() {
                    @Override
                    public void accept(HotMovies hotMovies) throws Exception {

                        if (isFromNet) {
                            showLog("读取网络数据成功并设置缓存\n");
                            // TODO: 2017/12/13 设置缓存
                            mAcache.put(movie_cache_name, hotMovies);
                        }else {
                            showLog("读取缓存成功\n");
                        }

                        showLog("读取数据成功：observable accept hotMovies===" + hotMovies.toString() + "\n");
                        result.setText(sb.toString());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        showLog("获取数据失败:" + throwable.getMessage() + "\n");
                        result.setText(sb.toString());

                    }
                });
    }

    /**
     * 从缓存中读取数据
     *
     * @return
     */
    public Observable<HotMovies> getCacheObservable() {
        return Observable.create(new ObservableOnSubscribe<HotMovies>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<HotMovies> e) throws Exception {
                showLog("create当前线程:" + Thread.currentThread().getName() + "\n");
                showLog("读取缓存开始\n");

                // TODO: 2017/12/14  读取缓存
                HotMovies hotMovies = (HotMovies) mAcache.getAsObject(movie_cache_name);

                if (hotMovies != null) { // 如果缓存数据不为空，则直接读取缓存数据，而不读取网络数据
                    isFromNet = false;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showLog("读取缓存数据成功.\n");
                        }
                    });
                    e.onNext(hotMovies);

                } else {//缓存没有数据，直接从网络中读取数据
                    isFromNet = true;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showLog("读取缓存数据失败.\n");
                        }
                    });

                    e.onComplete();
                }
            }
        });

    }

    /**
     * 从网络中读取数据
     *
     * @return
     */
    public Observable<HotMovies> getNetObservable() {

        return Observable.create(new ObservableOnSubscribe<HotMovies>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<HotMovies> e) throws Exception {
                //查看请求网络observable所在的线程
                showLog("Observable subscribe : current thread id = " + Thread.currentThread().getId() + "\n");
                showLog("网络请求开始\n");

                Request.Builder requestBuilder = new Request.Builder()
                        .url("https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=366");
                requestBuilder.method("GET", null);
                Request request = requestBuilder.build();
                Call mCall = client.newCall(request);
                Response response = mCall.execute();
                if (response.isSuccessful()) {

                    HotMovies hotMovies = new Gson().fromJson(response.body().string(), HotMovies.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showLog("网络请求成功\n");
                        }
                    });

                    e.onNext(hotMovies);
                } else {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showLog("网络请求失败\n");
                        }
                    });

                    e.onComplete();
                }
            }
        });
    }

    /**
     *  请求热门电影接口，并带着热门电影数据去请求具体某部电影的详情。
     * @param v
     */
    public void doFlatMapPractice(View v){
        clear();
        showLog("doFlatMapPractice start \n");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(hot_moive_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(MovieService.class)
                .getHotMovies("366")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<HotMovies>() {
                    @Override
                    public void accept(HotMovies hotMovies) throws Exception {
                        showLog("observable accept hotMovies === " + hotMovies.getMovies().get(13).getTitleCn() + "\n");
                        result.setText(sb.toString());

                    }
                })
        .observeOn(Schedulers.io())//回到io中去请求网络
        .flatMap(new Function<HotMovies, ObservableSource<MovieDetails>>() {//关键
            @Override
            public ObservableSource<MovieDetails> apply(@NonNull HotMovies hotMovies) throws Exception {

                if(hotMovies != null){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(movie_details_url)
                            //增加返回值为String的支持
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();

                    MovieService movieService = retrofit.create(MovieService.class);
                    Observable<MovieDetails> observable = movieService.getMovieDetails("366",hotMovies.getMovies().get(13).getMovieId()+"");
                    return observable;
                }

                return null;
            }
        })
        .observeOn(AndroidSchedulers.mainThread())//flatmap请求完网络，切换回UI线程展示UI
        .subscribe(new Consumer<MovieDetails>() {
            @Override
            public void accept(MovieDetails movieDetails) throws Exception {
                showLog("finally, moviesDetails == "+ movieDetails.getData().getBasic().getStory()+"\n");
                result.setText(sb.toString());
            }
        });
    }

    /**
     * 结合多个接口的数据更新UI: zip 操作符可以将多个 Observable 的数据结合为一个数据源再发射出去。
     * 同一个页面同时请求两个接口，并合并内容一起展示在UI中（Zip练习）
     * @param v
     */
    public void doZipPractice(View v){

        clear();
        showLog("doZipPractice start .. \n");

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(hot_moive_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //Observable1
        MovieService movieService1 = retrofit1.create(MovieService.class);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(movie_details_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //Observable2
        MovieService movieService2 = retrofit2.create(MovieService.class);


        Observable.zip(
                movieService1.getHotMovies("366"),//Observable1 HotMovies
                movieService2.getMovieDetails("366", "70233"),//Observable2 MovieDetails
                new BiFunction<HotMovies, MovieDetails, String>() {
            @Override
            public String apply(@NonNull HotMovies hotMovies, @NonNull MovieDetails movieDetails) throws Exception {
                showLog("合并信息 == " + hotMovies.getMovies().get(13).getTitleCn() + "\n" + movieDetails.getData().getBasic().getStory() + "\n");
                return hotMovies.getMovies().get(13).getTitleCn() + "\n" + movieDetails.getData().getBasic().getStory() + "\n";
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                showLog("接收到的组合结果是 == " + s);
                result.setText(sb.toString());
            }
        });
    }

    public void clear() {
        result.setText("");
        sb.replace(0, sb.length(), "");
    }

    public void showLog(String str) {
        sb.append(str + "\n");
        LogUtils.i(TAG, str + "\n");
    }
}

