package io.grpc.internal;

import io.grpc.internal.Fb;

/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
class Lb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fb.f f27419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lb(Fb.f fVar) {
        this.f27419a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27419a.f27295a.b(Fb.f27282e);
    }
}
