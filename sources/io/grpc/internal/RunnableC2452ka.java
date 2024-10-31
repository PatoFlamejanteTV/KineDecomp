package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.Nb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.ka, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2452ka implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f27653a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2460ma f27654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2452ka(C2460ma c2460ma, Status status) {
        this.f27654b = c2460ma;
        this.f27653a = status;
    }

    @Override // java.lang.Runnable
    public void run() {
        Nb.a aVar;
        aVar = this.f27654b.f27678h;
        aVar.a(this.f27653a);
    }
}
