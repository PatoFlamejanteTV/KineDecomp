package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.Y;

/* compiled from: KeepAliveManager.java */
/* renamed from: io.grpc.internal.sb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2484sb implements Y.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KeepAliveManager.a f27736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2484sb(KeepAliveManager.a aVar) {
        this.f27736a = aVar;
    }

    @Override // io.grpc.internal.Y.a
    public void a(long j) {
    }

    @Override // io.grpc.internal.Y.a
    public void a(Throwable th) {
        InterfaceC2424da interfaceC2424da;
        interfaceC2424da = this.f27736a.f27416a;
        interfaceC2424da.a(Status.q.b("Keepalive failed. The connection is likely gone"));
    }
}
