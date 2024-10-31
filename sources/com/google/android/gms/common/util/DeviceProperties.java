package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {

    /* renamed from: a */
    private static Boolean f11269a;

    /* renamed from: b */
    private static Boolean f11270b;

    /* renamed from: c */
    private static Boolean f11271c;

    /* renamed from: d */
    private static Boolean f11272d;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean a(Context context) {
        if (f11271c == null) {
            PackageManager packageManager = context.getPackageManager();
            f11271c = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return f11271c.booleanValue();
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean b(Context context) {
        if (f11270b == null) {
            f11270b = Boolean.valueOf(PlatformVersion.h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f11270b.booleanValue();
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean c(Context context) {
        if (f11269a == null) {
            f11269a = Boolean.valueOf(PlatformVersion.g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f11269a.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean d(Context context) {
        if (!c(context)) {
            return false;
        }
        if (PlatformVersion.j()) {
            return b(context) && !PlatformVersion.k();
        }
        return true;
    }

    public static boolean e(Context context) {
        if (f11272d == null) {
            f11272d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f11272d.booleanValue();
    }

    @KeepForSdk
    public static boolean a() {
        return "user".equals(Build.TYPE);
    }
}
