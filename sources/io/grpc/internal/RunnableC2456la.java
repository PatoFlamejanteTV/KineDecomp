package io.grpc.internal;

import io.grpc.internal.C2460ma;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.la, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2456la implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2460ma.a f27661a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Y f27662b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2460ma f27663c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2456la(C2460ma c2460ma, C2460ma.a aVar, Y y) {
        this.f27663c = c2460ma;
        this.f27661a = aVar;
        this.f27662b = y;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27661a.a(this.f27662b);
    }
}
