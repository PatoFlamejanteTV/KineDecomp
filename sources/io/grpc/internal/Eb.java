package io.grpc.internal;

import io.grpc.J;
import io.grpc.Status;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
class Eb extends J.f {

    /* renamed from: a, reason: collision with root package name */
    final J.c f27271a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Throwable f27272b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fb f27273c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eb(Fb fb, Throwable th) {
        this.f27273c = fb;
        this.f27272b = th;
        this.f27271a = J.c.a(Status.p.b("Panic! This is a bug!").b(this.f27272b));
    }

    @Override // io.grpc.J.f
    public J.c a(J.d dVar) {
        return this.f27271a;
    }
}
