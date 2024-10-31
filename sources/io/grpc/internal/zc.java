package io.grpc.internal;

import io.grpc.internal.wc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetriableStream.java */
/* loaded from: classes3.dex */
public class zc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ wc.f f27811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zc(wc.f fVar) {
        this.f27811a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        wc.this.t = null;
        wc.this.f27761f.execute(new yc(this));
    }
}
