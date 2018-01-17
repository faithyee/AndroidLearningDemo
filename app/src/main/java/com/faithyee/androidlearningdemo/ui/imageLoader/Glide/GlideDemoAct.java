package com.faithyee.androidlearningdemo.ui.imageLoader.Glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.constant.ConstantValue;

public class GlideDemoAct extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_glide_demo);

        imageView = (ImageView)findViewById(R.id.image_view);
    }

    public void loadImage(View v){
        Glide.with(this)
                .load(ConstantValue.IMAGE_GIF_URL)
//                .asBitmap()//使用该api,gif就无法播放了,只停留在第一帧
//                .asGif()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(100, 100)//Glide现在只会将图片加载成100*100像素的尺寸
                .into(imageView);
    }
}
