package com.faithyee.androidlearningdemo.ui.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NetworkDemoAct extends AppCompatActivity {

    private String weather_url = "https://free-api.heweather.com/s6/weather/now";
    public static final String NETWORK_GET = "NETWORK_GET";
    public static final String NETWORK_POST = "NETWORK_POST";
    private static final String TAG = "NetworkDemoAct";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_network_demo);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void get(View v){
        tv.setText("");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(weather_url + "?location=beijing&key=e530e075e7a74c89aed52d3cd87e4268");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setRequestProperty("action", NETWORK_GET);
                    conn.setUseCaches(false);
                    String requestHeader = getReqeustHeader(conn);
                    InputStream is = conn.getInputStream();
                    String responseHeader = getResponseHeader(conn);
                    final String responseBody = getStringByBytes(getBytesByInputStream(is));
                    LogUtils.i(TAG, "requestHeader="  + requestHeader);
                    LogUtils.i(TAG, "responseHeader="  + responseHeader);
                    LogUtils.i(TAG, "responseBody="  + responseBody);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText("responseBody" + responseBody);
                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void post(View v){
        tv.setText("");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(weather_url);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setRequestProperty("action", NETWORK_POST);
                    conn.setUseCaches(false);
                    String requestHeader = getReqeustHeader(conn);

                    //获取conn的输出流
                    OutputStream os = conn.getOutputStream();
                    //获取两个键值对name=孙群和age=27的字节数组，将该字节数组作为请求体
                    byte[] requestBody = new String("location=beijing&key=e530e075e7a74c89aed52d3cd87e4268").getBytes("UTF-8");
                    //将请求体写入到conn的输出流中
                    os.write(requestBody);
                    //记得调用输出流的flush方法
                    os.flush();
                    //关闭输出流
                    os.close();

                    InputStream is = conn.getInputStream();
                    String responseHeader = getResponseHeader(conn);
                    final String responseBody = getStringByBytes(getBytesByInputStream(is));
                    LogUtils.i(TAG, "requestHeader="  + requestHeader);
                    LogUtils.i(TAG, "responseHeader="  + responseHeader);
                    LogUtils.i(TAG, "responseBody="  + responseBody);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText("responseBody" + responseBody);
                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //读取请求头
    private String getReqeustHeader(HttpURLConnection conn) {
        Map<String, List<String>> requestHeaderMap = conn.getRequestProperties();
        Iterator<String> requestHeaderIterator = requestHeaderMap.keySet().iterator();
        StringBuilder sbRequestHeader = new StringBuilder();
        while (requestHeaderIterator.hasNext()) {
            String requestHeaderKey = requestHeaderIterator.next();
            String requestHeaderValue = conn.getRequestProperty(requestHeaderKey);
            sbRequestHeader.append(requestHeaderKey);
            sbRequestHeader.append(":");
            sbRequestHeader.append(requestHeaderValue);
            sbRequestHeader.append("\n");
        }
        return sbRequestHeader.toString();
    }

    //读取响应头
    private String getResponseHeader(HttpURLConnection conn) {
        Map<String, List<String>> responseHeaderMap = conn.getHeaderFields();
        int size = responseHeaderMap.size();
        StringBuilder sbResponseHeader = new StringBuilder();
        for(int i = 0; i < size; i++){
            String responseHeaderKey = conn.getHeaderFieldKey(i);
            String responseHeaderValue = conn.getHeaderField(i);
            sbResponseHeader.append(responseHeaderKey);
            sbResponseHeader.append(":");
            sbResponseHeader.append(responseHeaderValue);
            sbResponseHeader.append("\n");
        }
        return sbResponseHeader.toString();
    }

    //根据字节数组构建UTF-8字符串
    private String getStringByBytes(byte[] bytes) {
        String str = "";
        try {
            str = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    //从InputStream中读取数据，转换成byte数组，最后关闭InputStream
    private byte[] getBytesByInputStream(InputStream is) {
        byte[] bytes = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        byte[] buffer = new byte[1024 * 8];
        int length = 0;
        try {
            while ((length = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }
}
