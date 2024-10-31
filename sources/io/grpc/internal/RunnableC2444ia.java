package io.grpc.internal;

import io.grpc.internal.Nb;

/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.ia, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2444ia implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Nb.a f27631a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2460ma f27632b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2444ia(C2460ma c2460ma, Nb.a aVar) {
        this.f27632b = c2460ma;
        this.f27631a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27631a.a(false);
    }
}
