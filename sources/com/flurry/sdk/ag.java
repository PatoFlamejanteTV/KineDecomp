package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f454a = ag.class.getSimpleName();

    public static PackageInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 20815);
        } catch (PackageManager.NameNotFoundException e) {
            as.a(f454a, "Cannot find package info for package: " + context.getPackageName());
            return null;
        }
    }

    public static String b(Context context) {
        PackageInfo a2 = a(context);
        return (a2 == null || a2.packageName == null) ? "" : a2.packageName;
    }
}
