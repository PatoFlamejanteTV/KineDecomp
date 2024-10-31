package io.grpc.internal;

import java.util.HashSet;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: InUseStateAggregator.java */
@NotThreadSafe
/* renamed from: io.grpc.internal.db */
/* loaded from: classes3.dex */
public abstract class AbstractC2425db<T> {

    /* renamed from: a */
    private final HashSet<T> f27596a = new HashSet<>();

    abstract void a();

    public final void a(T t, boolean z) {
        int size = this.f27596a.size();
        if (z) {
            this.f27596a.add(t);
            if (size == 0) {
                a();
                return;
            }
            return;
        }
        if (this.f27596a.remove(t) && size == 1) {
            b();
        }
    }

    abstract void b();

    public final boolean c() {
        return !this.f27596a.isEmpty();
    }
}
