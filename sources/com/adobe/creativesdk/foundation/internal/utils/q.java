package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: ColumnCountUtil.java */
/* loaded from: classes.dex */
public class q {
    public static int a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d2 = displayMetrics.widthPixels;
        double d3 = displayMetrics.xdpi;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return Math.max(1, (int) Math.round((d2 / d3) / (context.getResources().getBoolean(c.a.a.a.b.a.tablet) ? 1.75d : 1.5d)));
    }
}
