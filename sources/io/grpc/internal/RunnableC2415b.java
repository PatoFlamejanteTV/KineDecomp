package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.AbstractC2411a;
import io.grpc.internal.ClientStreamListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractClientStream.java */
/* renamed from: io.grpc.internal.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2415b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27558a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ClientStreamListener.RpcProgress f27559b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27560c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AbstractC2411a.c f27561d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2415b(AbstractC2411a.c cVar, Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
        this.f27561d = cVar;
        this.f27558a = status;
        this.f27559b = rpcProgress;
        this.f27560c = p;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27561d.a(this.f27558a, this.f27559b, this.f27560c);
    }
}
