package com.faithyee.androidlearningdemo.ui.view.practiceDay10.innerRuler;

import android.content.Context;
import android.support.annotation.Px;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import com.faithyee.androidlearningdemo.ui.view.practiceDay10.BooheeRuler;

/**
 * 水平尺子抽象类
 * Author：yewmf on 2018/1/10 14:25
 * E-mail：faith_yee@163.com
 */
public abstract class HorizontalRuler extends InnerRuler {

    private final String TAG = "ruler";
    private float mLastX = 0;
    //一半宽度
    protected int mHalfWidth = 0;

    public HorizontalRuler(Context context, BooheeRuler booheeRuler) {
        super(context, booheeRuler);
    }

    //处理滑动，主要是触摸的时候通过计算现在的event坐标和上一个的位移量来决定scrollBy()的多少
    //滑动完之后计算速度是否满足Fling，满足则使用OverScroller来计算Fling滑动
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        //开始速度检测
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mOverScroller.isFinished()) {
                    //停止滚动动画
                    mOverScroller.abortAnimation();
                }

                mLastX = currentX;
                break;
            case MotionEvent.ACTION_MOVE:
                //move的过程中，currentX值在不断变化
                float moveX = mLastX - currentX;
                mLastX = currentX;
//                Log.i(TAG,"mLastX = " + moveX);
                scrollBy((int) (moveX), 0);//水平滚动
                break;
            case MotionEvent.ACTION_UP:
                //处理松手后的Fling
                /**
                 * unit :A value of 1
                 * provides pixels per millisecond, 1000 provides pixels per second, etc.
                 * 每秒1像素
                 */
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocityX = (int) mVelocityTracker.getXVelocity();
                if (Math.abs(velocityX) > mMinimumVelocity) {
                    fling(-velocityX);
                } else {
                    //渐变回弹：渐渐回滚到精确的刻度上
                    scrollBackToCurrentScale();
                }
                //VelocityTracker回收
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                releaseEdgeEffects();
                break;
            case MotionEvent.ACTION_CANCEL:
                if (!mOverScroller.isFinished()) {
                    mOverScroller.abortAnimation();
                }
                //回滚到整点刻度
                scrollBackToCurrentScale();
                //VelocityTracker回收
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                releaseEdgeEffects();
                break;
        }
        return true;
    }

    @Override
    protected void scrollBackToCurrentScale() {
        //渐变回弹
//        Log.d(TAG, "scrollBackToCurrentScale: ");
        mOverScroller.startScroll(getScrollX(), 0, scaleToScrollX(Math.round(mCurrentScale)) - getScrollX(), 0, 500);
        invalidate();
    }

    private void fling(int vX) {
        mOverScroller.fling(getScrollX(), 0, vX, 0, mMinPosition - mEdgeLength, mMaxPosition + mEdgeLength, 0, 0);
        invalidate();
    }

    //把Scale转化为ScrollX
    private int scaleToScrollX(float scale) {
//        Log.d(TAG, "scaleToScrollX: ");
        return (int) ((scale - mParent.getMinScale()) / mMaxLength * mLength + mMinPosition);
    }

    //重写滑动方法，设置到边界的时候不滑,并显示边缘效果。滑动完输出刻度。
    @Override
    public void scrollTo(@Px int x, @Px int y) {
        if (x < mMinPosition) {
            goStartEdgeEffect(x);
            x = mMinPosition;
        }
        if (x > mMaxPosition) {
            goEndEdgeEffect(x);
            x = mMaxPosition;
        }
        if (x != getScrollX()) {
            super.scrollTo(x, y);
        }

        mCurrentScale = scrollXtoScale(x);
        if (mRulerCallback != null) {
            mRulerCallback.onScaleChanging(Math.round(mCurrentScale));
        }

    }

    //把滑动偏移量scrollX转化为刻度Scale
    //TODO 转化大刻度（1000k以上）的时候会很卡，后面有时间再尝试缓存或者分级处理
    private float scrollXtoScale(int scrollX) {
//        Log.d(TAG, "scrollXtoScale: " + scrollX);
        return ((float) (scrollX - mMinPosition) / mLength) * mMaxLength + mParent.getMinScale();
    }

    //头部边缘效果处理
    private void goStartEdgeEffect(int x){
        if (mParent.canEdgeEffect()) {
            if (!mOverScroller.isFinished()) {
                mStartEdgeEffect.onAbsorb((int) mOverScroller.getCurrVelocity());
                mOverScroller.abortAnimation();
            } else {
                mStartEdgeEffect.onPull((float) (mMinPosition - x) / (mEdgeLength) * 3 + 0.3f);
                mStartEdgeEffect.setSize(mParent.getCursorHeight(), getWidth());
            }
            postInvalidateOnAnimation();
        }
    }

    //尾部边缘效果处理
    private void goEndEdgeEffect(int x){
        if(mParent.canEdgeEffect()) {
            if (!mOverScroller.isFinished()) {
                mEndEdgeEffect.onAbsorb((int) mOverScroller.getCurrVelocity());
                mOverScroller.abortAnimation();
            } else {
                mEndEdgeEffect.onPull((float) (x - mMaxPosition) / (mEdgeLength) * 3 + 0.3f);
                mEndEdgeEffect.setSize(mParent.getCursorHeight(), getWidth());
            }
            postInvalidateOnAnimation();
        }
    }

    //取消边缘效果动画
    private void releaseEdgeEffects(){
        if (mParent.canEdgeEffect()) {
            mStartEdgeEffect.onRelease();
            mEndEdgeEffect.onRelease();
        }
    }


    @Override
    public void refreshSize() {
        mLength = (mParent.getMaxScale() - mParent.getMinScale()) * mParent.getInterval();
        mHalfWidth = getWidth() / 2;
        mMinPosition = -mHalfWidth;
        mMaxPosition = mLength - mHalfWidth;
    }

    //获取控件宽高，设置相应信息
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        refreshSize();
    }


    //直接跳转到当前刻度
    public void goToScale(float scale) {
        mCurrentScale = Math.round(scale);
        scrollTo(scaleToScrollX(mCurrentScale), 0);
//        if (mRulerCallback != null) {
//            mRulerCallback.onScaleChanging(mCurrentScale);
//        }
    }


}
