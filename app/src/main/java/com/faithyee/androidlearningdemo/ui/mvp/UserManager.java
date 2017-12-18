package com.faithyee.androidlearningdemo.ui.mvp;

import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.ui.rxjava.retrofit.MovieService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Author：yewmf on 2017/12/18 16:26
 * E-mail：faith_yee@163.com
 */
public class UserManager {

    private String hot_moive_url = "https://api-m.mtime.cn/";

    public void performLogin(String name, String pw, final NetworkCallback callback){
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
//                        view.commitSuccess("observable accept hotMovies===" + hotMovies.toString() + "\n");
                        callback.onSuccess(hotMovies);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
//                        view.commitSuccess("observable accept error : " + throwable.getMessage());
                        callback.onFailure(-1,"observable accept error : " + throwable.getMessage() );
                    }
                });
    }


}
