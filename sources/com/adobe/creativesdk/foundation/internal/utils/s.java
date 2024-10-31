package com.adobe.creativesdk.foundation.internal.utils;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;

/* compiled from: NavBarUtil.java */
/* loaded from: classes.dex */
public class s {
    public static boolean a(Activity activity) {
        return b(activity) > 0 && (activity.getResources().getBoolean(c.a.a.a.b.a.tablet) || activity.getResources().getConfiguration().orientation == 1);
    }

    public static int b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                return i2 - i;
            }
        }
        return 0;
    }

    public static int c(Activity activity) {
        if (a(activity)) {
            return activity.getResources().getDimensionPixelSize(c.a.a.a.b.c.nav_bar_height);
        }
        return 0;
    }
}
