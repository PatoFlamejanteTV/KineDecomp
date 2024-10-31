package io.grpc.internal;

import io.grpc.internal.MessageDeframer;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2451k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f27651a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2463n f27652b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2451k(C2463n c2463n, int i) {
        this.f27652b = c2463n;
        this.f27651a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer.a aVar;
        aVar = this.f27652b.f27696a;
        aVar.c(this.f27651a);
    }
}
