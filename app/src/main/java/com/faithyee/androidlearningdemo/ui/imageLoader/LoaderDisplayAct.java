package com.faithyee.androidlearningdemo.ui.imageLoader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.ui.imageLoader.Glide.GlideDemoAct;

public class LoaderDisplayAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loader);
    }

    public void glide(View v){
        startActivity(new Intent(LoaderDisplayAct.this, GlideDemoAct.class));
    }
}
