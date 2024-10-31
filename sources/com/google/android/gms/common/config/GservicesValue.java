package com.google.android.gms.common.config;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {

    /* renamed from: a */
    private static final Object f10982a = new Object();

    /* renamed from: b */
    private static a f10983b = null;

    /* renamed from: c */
    private static int f10984c = 0;

    /* renamed from: d */
    protected final String f10985d;

    /* renamed from: e */
    protected final T f10986e;

    /* renamed from: f */
    private T f10987f = null;

    /* loaded from: classes.dex */
    private interface a {
    }

    public GservicesValue(String str, T t) {
        this.f10985d = str;
        this.f10986e = t;
    }

    @KeepForSdk
    public static GservicesValue<Boolean> a(String str, boolean z) {
        return new com.google.android.gms.common.config.a(str, Boolean.valueOf(z));
    }

    @KeepForSdk
    public static GservicesValue<Long> a(String str, Long l) {
        return new b(str, l);
    }

    @KeepForSdk
    public static GservicesValue<Integer> a(String str, Integer num) {
        return new c(str, num);
    }

    @KeepForSdk
    public static GservicesValue<Float> a(String str, Float f2) {
        return new d(str, f2);
    }

    @KeepForSdk
    public static GservicesValue<String> a(String str, String str2) {
        return new e(str, str2);
    }
}
