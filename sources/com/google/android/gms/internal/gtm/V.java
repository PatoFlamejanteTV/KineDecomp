package com.google.android.gms.internal.gtm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class V extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f13186a;

    public V(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th != null) {
            this.f13186a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == V.class) {
            if (this == obj) {
                return true;
            }
            V v = (V) obj;
            if (this.f13186a == v.f13186a && get() == v.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13186a;
    }
}
