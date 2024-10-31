package io.grpc.internal;

import io.grpc.internal.Nb;

/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.ha, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2440ha implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Nb.a f27626a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2460ma f27627b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2440ha(C2460ma c2460ma, Nb.a aVar) {
        this.f27627b = c2460ma;
        this.f27626a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27626a.a(true);
    }
}
