package io.grpc.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
public class Ab extends AbstractC2425db<Object> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fb f27198b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ab(Fb fb) {
        this.f27198b = fb;
    }

    @Override // io.grpc.internal.AbstractC2425db
    void a() {
        this.f27198b.d();
    }

    @Override // io.grpc.internal.AbstractC2425db
    void b() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f27198b.I;
        if (atomicBoolean.get()) {
            return;
        }
        this.f27198b.i();
    }
}
