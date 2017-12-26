package com.faithyee.androidlearningdemo.ui.view.practiceDay02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.faithyee.androidlearningdemo.R;


public class Practice07ColorMatrixColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    private ColorMatrix colorMatrix;
    private ColorFilter colorFilter;

    private int brightness = 0;
    private float contrast = 1;

    public Practice07ColorMatrixColorFilterView(Context context) {
        super(context);
    }


    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static float[] calculateMatrix(int mode, int brightness, float contrast) {
        return applyBrightnessAndContrast(getMatrixByMode(mode), brightness, contrast);
    }

    private static float[] getMatrixByMode(int mode) {
        float[] targetMatrix = common();
        switch (mode) {
            case Mode.NONE:
                targetMatrix = common();
                break;
            case Mode.GREY_SCALE:
                targetMatrix = greyScale();
                break;
            case Mode.INVERT:
                targetMatrix = invert();
                break;
            case Mode.RGB_TO_BGR:
                targetMatrix = rgbToBgr();
                break;
            case Mode.SEPIA:
                targetMatrix = sepia();
                break;
            case Mode.BRIGHT:
                targetMatrix = bright();
                break;
            case Mode.BLACK_AND_WHITE:
                targetMatrix = blackAndWhite();
                break;
            case Mode.VINTAGE_PINHOLE:
                targetMatrix = vintagePinhole();
                break;
            case Mode.KODACHROME:
                targetMatrix = kodachrome();
                break;
            case Mode.TECHNICOLOR:
                targetMatrix = technicolor();
                break;
        }
        return targetMatrix;
    }

    private static float[] applyBrightnessAndContrast(float[] matrix, int brightness, float contrast) {
        float t = (1.0F - contrast) / 2.0F * 255.0F;
        for (int i = 0; i < 3; i++) {
            for (int j = i * 5; j < i * 5 + 3; j++) {
                matrix[j] *= contrast;
            }
            matrix[5 * i + 4] += t + brightness;
        }
        return matrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        int i = 200;
        float j = 300F;

        brightness = i - 255;
        contrast = j / 100F;
        colorMatrix = new ColorMatrix();
        colorMatrix.set(calculateMatrix(Mode.BRIGHT,brightness,contrast));
        colorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorFilter);

        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    private static final float[] COMMON = new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0
    };

    public static final float[] common() {
        return COMMON.clone();
    }

    private static final float[] GREY_SCALE = new float[] {
            0.33F, 0.59F, 0.11F, 0, 0,
            0.33F, 0.59F, 0.11F, 0, 0,
            0.33F, 0.59F, 0.11F, 0, 0,
            0, 0, 0, 1, 0,
    };

    public static final float[] greyScale() {
        return GREY_SCALE.clone();
    }

    private static final float[] INVERT = new float[] {
            -1, 0, 0, 0, 255,
            0, -1, 0, 0, 255,
            0, 0, -1, 0, 255,
            0, 0, 0, 1, 0,
    };

    public static final float[] invert() {
        return INVERT.clone();
    }

    private static final float[] RGB_TO_BGR = new float[] {
            0, 0, 1, 0, 0,
            0, 1, 0, 0, 0,
            1, 0, 0, 0, 0,
            0, 0, 0, 1, 0,
    };

    public static final float[] rgbToBgr() {
        return RGB_TO_BGR.clone();
    }

    private static final float[] SEPIA = new float[] {
            0.393F, 0.769F, 0.189F, 0, 0,
            0.349F, 0.686F, 0.168F, 0, 0,
            0.272F, 0.534F, 0.131F, 0, 0,
            0, 0, 0, 1, 0,
    };

    public static final float[] sepia() {
        return SEPIA.clone();
    }

    private static final float[] BRIGHT = new float[] {
            1.438F, -0.122F, -0.016F, 0, 0,
            -0.062F, 1.378F, -0.016F, 0, 0,
            -0.062F, -0.122F, 1.483F, 0, 0,
            0, 0, 0, 1, 0,
    };

    public static final float[] bright() {
        return BRIGHT.clone();
    }

    private static final float[] BLACK_AND_WHITE = new float[] {
            1.5F, 1.5F, 1.5F, 0, -255,
            1.5F, 1.5F, 1.5F, 0, -255,
            1.5F, 1.5F, 1.5F, 0, -255,
            0, 0, 0, 1, 0,
    };

    public static final float[] blackAndWhite() {
        return BLACK_AND_WHITE.clone();
    }

    private static final float[] VINTAGE_PINHOLE = new float[] {
            0.6279345635605994F, 0.3202183420819367F, -0.03965408211312453F, 0, 9.651285835294123F,
            0.02578397704808868F, 0.6441188644374771F, 0.03259127616149294F, 0, 7.462829176470591F,
            0.0466055556782719F, -0.0851232987247891F, 0.5241648018700465F, 0, 5.159190588235296F,
            0, 0, 0, 1, 0
    };

    public static final float[] vintagePinhole() {
        return VINTAGE_PINHOLE.clone();
    }

    private static final float[] KODACHROME = new float[] {
            1.1285582396593525F, -0.3967382283601348F, -0.03992559172921793F, 0, 63.72958762196502F,
            -0.16404339962244616F, 1.0835251566291304F, -0.05498805115633132F, 0, 24.732407896706203F,
            -0.16786010706155763F, -0.5603416277695248F, 1.6014850761964943F, 0, 35.62982807460946F,
            0, 0, 0, 1, 0
    };

    public static final float[] kodachrome() {
        return KODACHROME.clone();
    }

    private static final float[] TECHNICOLOR = new float[] {
            1.9125277891456083F, -0.8545344976951645F, -0.09155508482755585F, 0, 11.793603434377337F,
            -0.3087833385928097F, 1.7658908555458428F, -0.10601743074722245F, 0, -70.35205161461398F,
            -0.231103377548616F, -0.7501899197440212F, 1.847597816108189F, 0, 30.950940869491138F,
            0, 0, 0, 1, 0
    };

    public static final float[] technicolor() {
        return TECHNICOLOR.clone();
    }

    public static class Mode {
        public static final int NONE = -1;
        public static final int GREY_SCALE = 1;
        public static final int INVERT = 2;
        public static final int RGB_TO_BGR = 3;
        public static final int SEPIA = 4;
        public static final int BLACK_AND_WHITE = 5;
        public static final int BRIGHT = 6;
        public static final int VINTAGE_PINHOLE = 7;
        public static final int KODACHROME = 8;
        public static final int TECHNICOLOR = 9;
    }
}
