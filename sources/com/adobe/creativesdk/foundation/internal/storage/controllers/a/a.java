package com.adobe.creativesdk.foundation.internal.storage.controllers.a;

import android.os.Build;

/* compiled from: PlatformCommonUtils.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
