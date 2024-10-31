package io.grpc.internal;

import io.grpc.internal.C2461mb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.ib, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2445ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2461mb f27633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2445ib(C2461mb c2461mb) {
        this.f27633a = c2461mb;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2461mb.b bVar;
        bVar = this.f27633a.f27686f;
        bVar.c(this.f27633a);
    }
}
