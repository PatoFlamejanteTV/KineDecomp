package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class c extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f13120a;

    public c(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f13120a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == c.class) {
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            if (this.f13120a == cVar.f13120a && get() == cVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13120a;
    }
}
