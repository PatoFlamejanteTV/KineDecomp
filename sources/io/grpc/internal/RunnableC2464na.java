package io.grpc.internal;

import io.grpc.InterfaceC2521p;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.na */
/* loaded from: classes3.dex */
class RunnableC2464na implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2521p f27703a;

    /* renamed from: b */
    final /* synthetic */ Ea f27704b;

    public RunnableC2464na(Ea ea, InterfaceC2521p interfaceC2521p) {
        this.f27704b = ea;
        this.f27703a = interfaceC2521p;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27704b.f27264c;
        x.a(this.f27703a);
    }
}
