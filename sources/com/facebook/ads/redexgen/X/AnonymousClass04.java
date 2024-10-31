package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.04, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass04<T> {

    @Nullable
    public final T A00;

    @Nullable
    public final Throwable A01;
    public final boolean A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.04 != com.facebook.ads.cache.api.CacheResponse<T> */
    public AnonymousClass04(boolean z, @Nullable T t) {
        this.A02 = z;
        this.A00 = t;
        this.A01 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.04 != com.facebook.ads.cache.api.CacheResponse<T> */
    public AnonymousClass04(boolean z, @Nullable T result, @Nullable Throwable th) {
        this.A02 = z;
        this.A00 = result;
        this.A01 = th;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.04 != com.facebook.ads.cache.api.CacheResponse<T> */
    @Nullable
    public final T A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.04 != com.facebook.ads.cache.api.CacheResponse<T> */
    public final boolean A01() {
        return this.A02;
    }
}
