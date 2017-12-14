package com.faithyee.androidlearningdemo.ui.rxjava.retrofit;

import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.entity.MovieDetails;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retrofit 请求网络接口
 * 使用的是时光网api
 * 详情请前往：https://github.com/jokermonn/-Api/blob/master/Time.md
 * Created by faith_yee on 2017/12/9.
 */

public interface MovieService {



    //完整URL ： https://api-m.mtime.cn/PageSubArea/HotPlayMovies.api?locationId=366
    @GET("PageSubArea/HotPlayMovies.api")
    Observable<HotMovies> getHotMovies(@Query("locationId") String locationId);

    /**
     * 查看某电影详情,以下Url查看的是《神奇女侠》
     * @param locationId
     * @param movieId
     * @return
     */
    //完整URL：https://ticket-api-m.mtime.cn/movie/detail.api?locationId=366&movieId=70233
    @GET("movie/detail.api")
    Observable<MovieDetails> getMovieDetails(@Query("locationId") String locationId, @Query("movieId") String movieId);
}
