package io.grpc.internal;

import io.grpc.internal.Y;

/* compiled from: Http2Ping.java */
/* renamed from: io.grpc.internal.ab */
/* loaded from: classes3.dex */
class RunnableC2413ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Y.a f27556a;

    /* renamed from: b */
    final /* synthetic */ long f27557b;

    public RunnableC2413ab(Y.a aVar, long j) {
        this.f27556a = aVar;
        this.f27557b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27556a.a(this.f27557b);
    }
}
