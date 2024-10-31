package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class DefaultClock implements Clock {

    /* renamed from: a */
    private static final DefaultClock f11268a = new DefaultClock();

    private DefaultClock() {
    }

    @KeepForSdk
    public static Clock d() {
        return f11268a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long b() {
        return System.nanoTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long c() {
        return SystemClock.elapsedRealtime();
    }
}
