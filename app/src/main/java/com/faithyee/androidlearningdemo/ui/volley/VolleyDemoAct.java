package com.faithyee.androidlearningdemo.ui.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

public class VolleyDemoAct extends AppCompatActivity {

    private static final String TAG = "VolleyDemoAct";
    private String weather_url = "https://free-api.heweather.com/s6/weather/now";
    private RequestQueue mQueue;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_volley_demo);

        mQueue = Volley.newRequestQueue(VolleyDemoAct.this);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void get(View v){
        tv.setText("");
        StringRequest mStringRequest = new StringRequest(Request.Method.GET,
                weather_url + "?location=beijing&key=e530e075e7a74c89aed52d3cd87e4268",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        LogUtils.i(TAG, "response = " + response);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(response);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i(TAG, error.getMessage());
            }
        });
        //将请求添加在请求队列中
        mQueue.add(mStringRequest);
    }

    public void post(View v){
        tv.setText("");
        StringRequest mStringRequest = new StringRequest(Request.Method.POST,
                weather_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        LogUtils.i(TAG, "response = " + response);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(response);
                            }
                        });
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i(TAG, error.getMessage());
            }
        }){
            //post请求参数需要重写方法
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("location","beijing");
                params.put("key","e530e075e7a74c89aed52d3cd87e4268");
                return params;
            }

            //修改header需要重写方法
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<>();
                headers.put("action","NETWORK_POST");
                return headers;
            }
        };
        //将请求添加在请求队列中
        mQueue.add(mStringRequest);
    }


}