package com.adobe.creativesdk.foundation.internal.utils;

import android.os.Build;
import android.support.design.widget.F;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* compiled from: TabLayoutHelper.java */
/* loaded from: classes.dex */
class t implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ F f6915a;

    public t(F f2) {
        this.f6915a = f2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f6915a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.f6915a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        LinearLayout linearLayout = (LinearLayout) this.f6915a.getChildAt(0);
        int i = 0;
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            int measuredWidth = linearLayout.getChildAt(i2).getMeasuredWidth();
            if (measuredWidth > i) {
                i = measuredWidth;
            }
        }
    }
}
