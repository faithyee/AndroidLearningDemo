package com.faithyee.androidlearningdemo.ui.retrofit;

import com.faithyee.androidlearningdemo.entity.LectureComments;
import com.faithyee.androidlearningdemo.entity.Weather;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * retrofit 请求网络接口
 * Created by faith_yee on 2017/12/9.
 */

public interface RetrofitService {


    //完整URL ： https://free-api.heweather.com/s6/weather/now?location=shenzhen&key=e530e075e7a74c89aed52d3cd87e4268
    @GET("s6/weather/now")
    Call<Weather>getWeather(@Query("location")String location, @Query("key")String key);

    @GET("s6/weather/now")
    Call<Weather>getWeatherQueryMap(@QueryMap Map<String, String> options);

    //完整URL :　http://api.yixi.tv/api/v1/lecture/comments/416/page/1
    @Headers({"User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4033.400 QQBrowser/9.6.12624.400"})
    @GET("api/v1/lecture/comments/416/page/{page}")
    Call<LectureComments>getLectureComments(@Path("page") String page);

    @FormUrlEncoded
    @POST("s6/weather/now")
    Call<Weather>getWeatherPost(@Field("location")String location, @Field("key")String key);




}
