package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class X extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f13404a;

    public X(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th != null) {
            this.f13404a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == X.class) {
            if (this == obj) {
                return true;
            }
            X x = (X) obj;
            if (this.f13404a == x.f13404a && get() == x.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13404a;
    }
}
