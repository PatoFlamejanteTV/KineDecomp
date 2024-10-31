package io.grpc.internal;

import io.grpc.internal.MessageDeframer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2459m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Throwable f27669a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2463n f27670b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2459m(C2463n c2463n, Throwable th) {
        this.f27670b = c2463n;
        this.f27669a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageDeframer.a aVar;
        aVar = this.f27670b.f27696a;
        aVar.a(this.f27669a);
    }
}
