package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class AssetViewerViewPager extends ViewPager {
    private boolean ma;

    public AssetViewerViewPager(Context context) {
        super(context);
        this.ma = false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.ma) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ma) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLocked(boolean z) {
        this.ma = z;
    }

    public AssetViewerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ma = false;
    }
}
