package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.Ea;

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class Ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27219b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ea.a f27220c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(Ea.a aVar, Status status, io.grpc.P p) {
        this.f27220c = aVar;
        this.f27218a = status;
        this.f27219b = p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClientStreamListener clientStreamListener;
        clientStreamListener = this.f27220c.f27268a;
        clientStreamListener.a(this.f27218a, this.f27219b);
    }
}
