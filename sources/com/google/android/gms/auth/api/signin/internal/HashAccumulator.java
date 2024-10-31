package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public class HashAccumulator {

    /* renamed from: a */
    @VisibleForTesting
    private static int f10586a = 31;

    /* renamed from: b */
    private int f10587b = 1;

    @KeepForSdk
    public HashAccumulator a(Object obj) {
        this.f10587b = (f10586a * this.f10587b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final HashAccumulator a(boolean z) {
        this.f10587b = (f10586a * this.f10587b) + (z ? 1 : 0);
        return this;
    }

    @KeepForSdk
    public int a() {
        return this.f10587b;
    }
}
