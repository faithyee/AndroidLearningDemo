package com.faithyee.androidlearningdemo.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PixelUtils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
