package io.grpc.internal;

import io.grpc.internal.C2461mb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSubchannel.java */
/* renamed from: io.grpc.internal.hb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2441hb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.grpc.r f27628a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2461mb f27629b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2441hb(C2461mb c2461mb, io.grpc.r rVar) {
        this.f27629b = c2461mb;
        this.f27628a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2461mb.b bVar;
        bVar = this.f27629b.f27686f;
        bVar.a(this.f27629b, this.f27628a);
    }
}
