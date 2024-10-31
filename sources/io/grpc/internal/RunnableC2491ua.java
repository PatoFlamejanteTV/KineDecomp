package io.grpc.internal;

import java.io.InputStream;

/* compiled from: DelayedStream.java */
/* renamed from: io.grpc.internal.ua */
/* loaded from: classes3.dex */
class RunnableC2491ua implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InputStream f27745a;

    /* renamed from: b */
    final /* synthetic */ Ea f27746b;

    public RunnableC2491ua(Ea ea, InputStream inputStream) {
        this.f27746b = ea;
        this.f27745a = inputStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x;
        x = this.f27746b.f27264c;
        x.a(this.f27745a);
    }
}
