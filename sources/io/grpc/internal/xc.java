package io.grpc.internal;

import io.grpc.internal.wc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetriableStream.java */
/* loaded from: classes3.dex */
public class xc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ wc.f f27787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xc(wc.f fVar) {
        this.f27787a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        wc.g d2;
        wc.f fVar = this.f27787a;
        d2 = wc.this.d(fVar.f27775a.f27780d);
        wc.this.c(d2);
    }
}
