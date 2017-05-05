package com.jordanpourazari.samsungphotoapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jordanpourazari on 5/4/17.
 */

public class PreviewPager extends ViewPager{

    public PreviewPager(Context context) {
        super(context);
    }

    public PreviewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    public void nextPage(){
        int current = this.getCurrentItem();
        this.setCurrentItem(current+1);
    }

    public void previousPage(){
        int current = this.getCurrentItem();
        this.setCurrentItem(current - 1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

}
