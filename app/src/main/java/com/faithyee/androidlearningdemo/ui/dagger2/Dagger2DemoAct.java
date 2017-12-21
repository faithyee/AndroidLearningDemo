package com.faithyee.androidlearningdemo.ui.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.AppAplication;
import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.dagger2.component.AppComponent;
import com.faithyee.androidlearningdemo.utils.LogUtils;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 1、dagger2的基本使用
 * 2、如何封装
 */
public class Dagger2DemoAct extends AppCompatActivity implements Dagger2Contract.View{

    private static final String TAG = "Dagger2DemoAct";

    /**
     * @Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
     */
    @Inject
    Dagger2Presenter presenter;

    @Inject
    OkHttpClient client;

    @Inject
    Retrofit retrofit;

    private TextView resultTv;
    private EditText name;
    private EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_demo);

        resultTv = (TextView) findViewById(R.id.result);
        name = (EditText) findViewById(R.id.name);
        pw = (EditText) findViewById(R.id.pw);

        AppComponent appComponent = ((AppAplication) getApplication()).getAppComponent();
        /**
         * 此时，注入过程就完成了
         * 由于Dagger2Component里依赖了ApiModule，而ApiModule已经由AppComponent组装了，因而在此可以
         * 使用该方式进行注入
         */
        DaggerDagger2Component.builder()
                .appComponent(appComponent)
                .dagger2Module(new Dagger2Module(this))//通过该步把Act的实体类传到Dagger2Module里
                .build()
                .inject(this);

    }

    public void login(View view){

        LogUtils.i(TAG, "okhttpClint == " + client);

        LogUtils.i(TAG, "retrofit  == " + retrofit);

        presenter.login(
                name.getText().toString(),
                pw.getText().toString());
    }

    @Override
    public void commitSuccess(String result) {
        resultTv.setText(result);
    }

    @Override
    public void commitFailed(String result) {
        resultTv.setText(result);
    }


}
