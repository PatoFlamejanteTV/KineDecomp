package io.grpc.internal;

import io.grpc.ConnectivityState;
import io.grpc.J;
import io.grpc.internal.Fb;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
class Ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ J.f f27366a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConnectivityState f27367b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fb.b f27368c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ib(Fb.b bVar, J.f fVar, ConnectivityState connectivityState) {
        this.f27368c = bVar;
        this.f27366a = fVar;
        this.f27367b = connectivityState;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fb.b bVar;
        C2428ea c2428ea;
        Fb.b bVar2 = this.f27368c;
        bVar = Fb.this.B;
        if (bVar2 != bVar) {
            return;
        }
        Fb.this.a(this.f27366a);
        if (this.f27367b != ConnectivityState.SHUTDOWN) {
            c2428ea = Fb.this.u;
            c2428ea.a(this.f27367b);
        }
    }
}
