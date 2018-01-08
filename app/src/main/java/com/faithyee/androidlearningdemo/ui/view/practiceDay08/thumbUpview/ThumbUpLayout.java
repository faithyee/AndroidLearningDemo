package com.faithyee.androidlearningdemo.ui.view.practiceDay08.thumbUpview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.faithyee.androidlearningdemo.R;

/**
 * Author：yewmf on 2018/1/2 10:18
 * E-mail：faith_yee@163.com
 */
@SuppressWarnings("ALL")
public class ThumbUpLayout extends LinearLayout implements View.OnClickListener {
    public static final float DEFAULT_DRAWABLE_PADDING = 4f;
    private ThumbView mThumbView;
    private CountView mNumView;

    private float mDrawablePadding;
    private int mTextColor;
    private int mNum;
    private float mTextSize;
    private boolean mIsThumbUp;
    private int mTopMargin;
    private boolean mNeedChangeChildView;

    public ThumbUpLayout(Context context) {
        this(context, null);
    }

    public ThumbUpLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThumbUpLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ThumbUpView);
        mDrawablePadding = typedArray.getDimension(R.styleable.ThumbUpView_tul_drawable_padding, TulUtils.dip2px(context, DEFAULT_DRAWABLE_PADDING));
        mNum = typedArray.getInt(R.styleable.ThumbUpView_tul_count, 0);
        mTextColor = typedArray.getColor(R.styleable.ThumbUpView_tul_text_color, Color.parseColor(CountView.DEFAULT_TEXT_COLOR));
        mTextSize = typedArray.getDimension(R.styleable.ThumbUpView_tul_drawable_padding, TulUtils.sp2px(context, CountView.DEFAULT_TEXT_SIZE));
        mIsThumbUp = typedArray.getBoolean(R.styleable.ThumbUpView_tul_isThumbUp, false);
        typedArray.recycle();
        init();
    }

    private void init() {
        removeAllViews();
        setClipChildren(false);
        setOrientation(LinearLayout.HORIZONTAL);

        addThumbView();
        addNumView();


        //把设置的padding分解到子view，否则对超出view范围的动画显示不全
        setPadding(0, 0, 0, 0, false);
        setOnClickListener(this);

    }

    @SuppressWarnings("SameParameterValue")
    public void setPadding(int left, int top, int right, int bottom, boolean needChange) {
        this.mNeedChangeChildView = needChange;
        setPadding(left, top, right, bottom);
    }

    private void addThumbView() {
        mThumbView = new ThumbView(getContext());
        mThumbView.setIsThumbUp(mIsThumbUp);
        TulPoint circlePoint = mThumbView.getCirclePoint();
        mTopMargin = (int) (circlePoint.y - mTextSize / 2);
        addView(mThumbView, getThumbParams());
    }

    private LayoutParams getThumbParams() {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (mTopMargin < 0) {
            params.topMargin = mTopMargin;//设置这个距离是为了文字与拇指居中显示
        }
        params.leftMargin = getPaddingLeft();
        params.topMargin += getPaddingTop();
        params.bottomMargin = getPaddingBottom();
        return params;
    }

    private void addNumView() {

        mNumView = new CountView(getContext());
        mNumView.setTextColor(mTextColor);
        mNumView.setTextSize(mTextSize);
        mNumView.setNum(mNum);

        addView(mNumView, getNumParams());
    }

    private LayoutParams getNumParams() {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (mTopMargin > 0) {
            params.topMargin = mTopMargin;//设置这个距离是为了文字与拇指居中显示
        }
        params.leftMargin = (int) mDrawablePadding;
        params.topMargin += getPaddingTop();
        params.bottomMargin = getPaddingBottom();
        params.rightMargin = getPaddingRight();
        return params;
    }

    @Override
    public void onClick(View v) {
        mIsThumbUp = !mIsThumbUp;
        if (mIsThumbUp) {
            mNumView.calculateChangeNum(1);
        } else {
            mNumView.calculateChangeNum(-1);
        }
        mThumbView.startAnim();
    }

    public void setThumbUpClickListener(ThumbView.ThumbUpClickListener listener){
        mThumbView.setThumbUpClickListener(listener);
    }

    public ThumbUpLayout setCount(int mCount) {
        this.mNum = mCount;
        mNumView.setNum(mCount);
        return this;
    }

    public ThumbUpLayout setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        mNumView.setTextColor(mTextColor);
        return this;
    }

    public ThumbUpLayout setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        mNumView.setTextSize(mTextSize);
        return this;
    }


    public ThumbUpLayout setThumbUp(boolean isThumbUp) {
        this.mIsThumbUp = isThumbUp;
        mThumbView.setIsThumbUp(mIsThumbUp);
        return this;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle data = new Bundle();
        data.putParcelable("superData", super.onSaveInstanceState());
        data.putInt("count", mNum);
        data.putFloat("textSize", mTextSize);
        data.putInt("textColor", mTextColor);
        data.putBoolean("isThumbUp", mIsThumbUp);
        data.putFloat("drawablePadding", mDrawablePadding);
        return data;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle data = (Bundle) state;
        Parcelable superData = data.getParcelable("superData");
        super.onRestoreInstanceState(superData);
        mNum = data.getInt("count");
        mTextSize = data.getFloat("textSize", TulUtils.sp2px(getContext(), CountView.DEFAULT_TEXT_SIZE));
        mTextColor = data.getInt("textColor", Color.parseColor(CountView.DEFAULT_TEXT_COLOR));
        mIsThumbUp = data.getBoolean("isThumbUp", false);
        mDrawablePadding = data.getFloat("drawablePadding", TulUtils.sp2px(getContext(), DEFAULT_DRAWABLE_PADDING));
        init();
    }

}
