package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.view.View;

/* compiled from: Compat.java */
/* loaded from: classes.dex */
public class a {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(5)
    private static int b(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @TargetApi(11)
    private static int c(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static int a(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return c(i);
        }
        return b(i);
    }
}
