package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice02RadialGradientView(Context context) {
        super(context);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);

        Shader shader3 = new RadialGradient(800, 300, 100, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.MIRROR);
        paint.setShader(shader3);
        canvas.drawCircle(800, 300, 200, paint);

        Shader shader2 = new RadialGradient(300, 800, 100, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"),
                Shader.TileMode.REPEAT);
        paint.setShader(shader2);
        canvas.drawCircle(300, 800, 200, paint);
    }
}
