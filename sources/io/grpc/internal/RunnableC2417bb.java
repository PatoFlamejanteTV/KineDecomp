package io.grpc.internal;

import io.grpc.internal.Y;

/* compiled from: Http2Ping.java */
/* renamed from: io.grpc.internal.bb */
/* loaded from: classes3.dex */
class RunnableC2417bb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Y.a f27566a;

    /* renamed from: b */
    final /* synthetic */ Throwable f27567b;

    public RunnableC2417bb(Y.a aVar, Throwable th) {
        this.f27566a = aVar;
        this.f27567b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27566a.a(this.f27567b);
    }
}
