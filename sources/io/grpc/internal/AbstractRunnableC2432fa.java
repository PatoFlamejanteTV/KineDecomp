package io.grpc.internal;

import io.grpc.Context;

/* compiled from: ContextRunnable.java */
/* renamed from: io.grpc.internal.fa */
/* loaded from: classes3.dex */
abstract class AbstractRunnableC2432fa implements Runnable {

    /* renamed from: a */
    private final Context f27608a;

    public AbstractRunnableC2432fa(Context context) {
        this.f27608a = context;
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        Context b2 = this.f27608a.b();
        try {
            b();
        } finally {
            this.f27608a.b(b2);
        }
    }
}
