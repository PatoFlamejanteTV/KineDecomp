package io.grpc.internal;

import io.grpc.internal.Ea;
import io.grpc.internal.Oc;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.za */
/* loaded from: classes3.dex */
class RunnableC2507za implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Oc.a f27808a;

    /* renamed from: b */
    final /* synthetic */ Ea.a f27809b;

    public RunnableC2507za(Ea.a aVar, Oc.a aVar2) {
        this.f27809b = aVar;
        this.f27808a = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClientStreamListener clientStreamListener;
        clientStreamListener = this.f27809b.f27268a;
        clientStreamListener.a(this.f27808a);
    }
}
