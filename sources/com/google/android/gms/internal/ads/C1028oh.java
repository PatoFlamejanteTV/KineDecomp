package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.oh */
/* loaded from: classes2.dex */
final class C1028oh extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f12387a;

    public C1028oh(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th != null) {
            this.f12387a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C1028oh.class) {
            if (this == obj) {
                return true;
            }
            C1028oh c1028oh = (C1028oh) obj;
            if (this.f12387a == c1028oh.f12387a && get() == c1028oh.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12387a;
    }
}
