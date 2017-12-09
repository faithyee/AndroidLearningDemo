package com.faithyee.androidlearningdemo.ui.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitDemoAct extends AppCompatActivity {

    private Call<Weather> call;
    private static final String TAG = "RetrofitDemoAct";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_retrofit_demo);
        result = (TextView) findViewById(R.id.result);
    }

    public void doGet(View v){
        getInformation("shenzhen", "e530e075e7a74c89aed52d3cd87e4268");

    }

    public void getInformation(String location, String key){

        String url = "https://free-api.heweather.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpService ipService = retrofit.create(IpService.class);
        call = ipService.getWeather(location, key);

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                LogUtils.i(TAG,"Weather==="+response.body().getHeWeather6().get(0).getBasic().toString());
                result.setText("Weather==="+response.body().getHeWeather6().get(0).getBasic().toString());
            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
