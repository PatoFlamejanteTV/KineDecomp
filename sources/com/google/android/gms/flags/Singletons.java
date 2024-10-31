package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class Singletons {

    /* renamed from: a */
    private static Singletons f11339a;

    /* renamed from: b */
    private final FlagRegistry f11340b = new FlagRegistry();

    /* renamed from: c */
    private final zzb f11341c = new zzb();

    static {
        Singletons singletons = new Singletons();
        synchronized (Singletons.class) {
            f11339a = singletons;
        }
    }

    private Singletons() {
    }

    @KeepForSdk
    public static FlagRegistry a() {
        return c().f11340b;
    }

    public static zzb b() {
        return c().f11341c;
    }

    private static Singletons c() {
        Singletons singletons;
        synchronized (Singletons.class) {
            singletons = f11339a;
        }
        return singletons;
    }
}
