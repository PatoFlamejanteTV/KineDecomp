package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Ea;

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class Da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27224a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ClientStreamListener.RpcProgress f27225b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27226c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ea.a f27227d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(Ea.a aVar, Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
        this.f27227d = aVar;
        this.f27224a = status;
        this.f27225b = rpcProgress;
        this.f27226c = p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClientStreamListener clientStreamListener;
        clientStreamListener = this.f27227d.f27268a;
        clientStreamListener.a(this.f27224a, this.f27225b, this.f27226c);
    }
}
