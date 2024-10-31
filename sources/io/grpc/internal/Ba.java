package io.grpc.internal;

import io.grpc.internal.Ea;

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class Ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27205a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ea.a f27206b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(Ea.a aVar, io.grpc.P p) {
        this.f27206b = aVar;
        this.f27205a = p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClientStreamListener clientStreamListener;
        clientStreamListener = this.f27206b.f27268a;
        clientStreamListener.a(this.f27205a);
    }
}
