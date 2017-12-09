package com.faithyee.androidlearningdemo.ui.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retrofit 请求网络接口
 * Created by faith_yee on 2017/12/9.
 */

public interface IpService {


    //完整URL ： https://free-api.heweather.com/s6/weather/now?location=shenzhen&key=e530e075e7a74c89aed52d3cd87e4268
    @GET("s6/weather/now")
    Call<Weather>getWeather(@Query("location")String location, @Query("key")String key);
}
