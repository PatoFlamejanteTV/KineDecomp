package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.3L, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C3L<T> extends AbstractRunnableC00351g {
    public final WeakReference<T> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.3L != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public C3L(T t) {
        this.A00 = new WeakReference<>(t);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.3L != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public final T A06() {
        return this.A00.get();
    }
}
