package com.faithyee.androidlearningdemo.ui.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;

public class MvpDemoAct extends AppCompatActivity implements MvpContract.View {

    private TextView resultTv;

    private MvpContract.Presenter presenter;

    private EditText name;
    private EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_demo);
        presenter = new MvpPresenter(this);
        resultTv = (TextView) findViewById(R.id.result);
        name = (EditText) findViewById(R.id.name);
        pw = (EditText) findViewById(R.id.pw);

    }

    public void doRxjavaAndRetrofit(View view){
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
