package io.grpc.internal;

import io.grpc.internal.Ea;

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class Aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Ea.a f27197a;

    public Aa(Ea.a aVar) {
        this.f27197a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClientStreamListener clientStreamListener;
        clientStreamListener = this.f27197a.f27268a;
        clientStreamListener.a();
    }
}
