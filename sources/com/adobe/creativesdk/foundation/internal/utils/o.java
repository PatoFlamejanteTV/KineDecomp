package com.adobe.creativesdk.foundation.internal.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AdobeUxUtilMainUIThreadHandler.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a */
    private static Handler f6878a;

    public static Handler a() {
        if (f6878a == null) {
            f6878a = new Handler(Looper.getMainLooper());
        }
        return f6878a;
    }
}
