package com.faithyee.androidlearningdemo.ui.view.practiceDay09.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * Scroller演示View
 * Created by faith_yee on 2018/1/8.
 */

public class ScrollerView extends View {

    private Scroller mScroller;

    public ScrollerView(Context context) {
        super(context);
        init(context);
    }

    public ScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);

    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }


    public void smoothScrollTo(int destX, int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //在2000ms内沿x轴平移delta像素
        mScroller.startScroll(scrollX, 0, delta, 0, 2000);
        invalidate();
    }
}
