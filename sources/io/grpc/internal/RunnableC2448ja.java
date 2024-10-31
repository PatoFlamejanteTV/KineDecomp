package io.grpc.internal;

import io.grpc.internal.Nb;

/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.ja, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2448ja implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Nb.a f27644a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2460ma f27645b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2448ja(C2460ma c2460ma, Nb.a aVar) {
        this.f27645b = c2460ma;
        this.f27644a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27644a.b();
    }
}
