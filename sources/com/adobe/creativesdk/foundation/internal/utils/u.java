package com.adobe.creativesdk.foundation.internal.utils;

import android.support.design.widget.F;

/* compiled from: TabLayoutHelper.java */
/* loaded from: classes.dex */
public class u {
    public static void a(F f2) {
        f2.getViewTreeObserver().addOnGlobalLayoutListener(new t(f2));
    }
}
