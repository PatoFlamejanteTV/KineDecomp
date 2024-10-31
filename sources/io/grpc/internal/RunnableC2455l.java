package io.grpc.internal;

import io.grpc.internal.MessageDeframer;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2455l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f27659a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2463n f27660b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2455l(C2463n c2463n, boolean z) {
        this.f27660b = c2463n;
        this.f27659a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer.a aVar;
        aVar = this.f27660b.f27696a;
        aVar.a(this.f27659a);
    }
}
