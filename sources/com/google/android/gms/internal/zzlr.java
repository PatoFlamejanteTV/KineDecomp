package com.google.android.gms.internal;

import android.os.Binder;

/* loaded from: classes.dex */
public abstract class zzlr<T> {
    private T zzOX = null;
    protected final String zzue;
    protected final T zzuf;
    private static final Object zzpy = new Object();
    private static a zzadc = null;
    private static int zzadd = 0;
    private static String zzade = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        Boolean a(String str, Boolean bool);

        Float a(String str, Float f);

        Integer a(String str, Integer num);

        Long a(String str, Long l);

        String a(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlr(String str, T t) {
        this.zzue = str;
        this.zzuf = t;
    }

    public static boolean isInitialized() {
        return zzadc != null;
    }

    public static zzlr<Float> zza(String str, Float f) {
        return new gd(str, f);
    }

    public static zzlr<Integer> zza(String str, Integer num) {
        return new gc(str, num);
    }

    public static zzlr<Long> zza(String str, Long l) {
        return new gb(str, l);
    }

    public static zzlr<Boolean> zzg(String str, boolean z) {
        return new ga(str, Boolean.valueOf(z));
    }

    public static int zzoo() {
        return zzadd;
    }

    public static zzlr<String> zzu(String str, String str2) {
        return new ge(str, str2);
    }

    public final T get() {
        return this.zzOX != null ? this.zzOX : zzbY(this.zzue);
    }

    protected abstract T zzbY(String str);

    public final T zzop() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
