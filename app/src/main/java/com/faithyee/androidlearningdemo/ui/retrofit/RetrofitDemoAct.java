package com.faithyee.androidlearningdemo.ui.retrofit;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.entity.LectureComments;
import com.faithyee.androidlearningdemo.entity.Weather;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitDemoAct extends AppCompatActivity {

    private Call<Weather> weatherCall;
    private Call<LectureComments> lectureCommentsCall;
    private static final String TAG = "RetrofitDemoAct";
    private TextView result;
    private String weather_url = "https://free-api.heweather.com/";
    private String lecture_comments_url = "http://api.yixi.tv/";
    private Retrofit retrofit;
    private StringBuffer sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_retrofit_demo);
        result = (TextView) findViewById(R.id.result);
        sb = new StringBuffer();

    }

    /**
     * get请求demo
     * @param v
     */
    public void doGet(View v){
        clear();
        showLog("doGet start ..\n");
        //增加返回值为String的支持
        retrofit = new Retrofit.Builder()
                .baseUrl(weather_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        weatherCall = retrofitService.getWeather("shenzhen", "e530e075e7a74c89aed52d3cd87e4268");

        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                showLog("Weather==="+response.body().getHeWeather6().get(0).getBasic().toString() + "\n");
                result.setText(sb.toString());
            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * 使用QueryMap来制作请求参数
     * @param v
     */
    public void doQueryMap(View v){
        clear();
        showLog("doQueryMap start..\n");
        //增加返回值为String的支持
        retrofit = new Retrofit.Builder()
                .baseUrl(weather_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Map<String, String> options = new ArrayMap();
        options.put("location", "shenzhen");
        options.put("key", "e530e075e7a74c89aed52d3cd87e4268");

        weatherCall = retrofitService.getWeatherQueryMap(options);
        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                showLog("Weather==="+response.body().getHeWeather6().get(0).getBasic().toString() + "\n");
                result.setText(sb.toString());

            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * 使用Path来制作请求参数
     * @param v
     */
    public void doPath(View v){
        clear();
        showLog("doPath start..\n");
        //增加返回值为String的支持
        retrofit = new Retrofit.Builder()
                .baseUrl(lecture_comments_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        lectureCommentsCall = retrofitService.getLectureComments("1");
        lectureCommentsCall.enqueue(new Callback<LectureComments>() {
            @Override
            public void onResponse(Call<LectureComments> call, Response<LectureComments> response) {

                showLog("LectureComments ==="+response.body().getData().toString() + "\n");
                result.setText(sb.toString());

            }
            @Override
            public void onFailure(Call<LectureComments> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * post请求
     * @param v
     */
    public void doPost(View v){
        clear();
        showLog("doPost start..\n");
        //增加返回值为String的支持
        retrofit = new Retrofit.Builder()
                .baseUrl(weather_url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        weatherCall = retrofitService.getWeatherPost("shenzhen", "e530e075e7a74c89aed52d3cd87e4268");
        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                showLog("Weather==="+response.body().getHeWeather6().get(0).getBasic().toString() + "\n");
                result.setText(sb.toString());

            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showLog(String str){

        LogUtils.i(TAG, str);
        sb.append(str);

    }

    public void clear(){
        result.setText("");
        sb.replace(0,sb.length(),"");
    }

}
