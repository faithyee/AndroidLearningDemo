package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;


public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        paint.setShader(shader);
        canvas.drawCircle(500, 600, 500, paint);
    }
}
