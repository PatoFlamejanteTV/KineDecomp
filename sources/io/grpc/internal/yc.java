package io.grpc.internal;

import io.grpc.internal.wc;

/* compiled from: RetriableStream.java */
/* loaded from: classes3.dex */
class yc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zc f27802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yc(zc zcVar) {
        this.f27802a = zcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        wc.g d2;
        wc.f fVar = this.f27802a.f27811a;
        d2 = wc.this.d(fVar.f27775a.f27780d + 1);
        wc.this.c(d2);
    }
}
