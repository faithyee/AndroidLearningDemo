package com.faithyee.androidlearningdemo.ui.rxjava.retrofit;

import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.entity.Weather;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retrofit 请求网络接口
 * Created by faith_yee on 2017/12/9.
 */

public interface MovieService {


    //完整URL ： https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=366
    @GET("PageSubArea/HotPlayMovies.api")
    Observable<HotMovies> getHotMovies(@Query("locationId") String locationId);
}
