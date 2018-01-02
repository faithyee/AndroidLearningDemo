package com.faithyee.androidlearningdemo.ui.view.practiveDay08.view;

/**
 * Author：yewmf on 2018/1/2 10:20
 * E-mail：faith_yee@163.com
 */
public class TulPoint {

    float x;
    float y;

    TulPoint() {
    }

    public TulPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        android.graphics.Point point = (android.graphics.Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        return result;
    }

    @Override
    public String toString() {
        return "TulPoint(" + x + ", " + y + ")";
    }

}
