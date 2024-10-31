package io.grpc.internal;

import io.grpc.C2528x;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.pa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC2472pa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2528x f27716a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ea f27717b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2472pa(Ea ea, C2528x c2528x) {
        this.f27717b = ea;
        this.f27716a = c2528x;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27717b.f27264c;
        x.a(this.f27716a);
    }
}
