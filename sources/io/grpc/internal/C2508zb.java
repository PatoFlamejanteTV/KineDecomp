package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.internal.Nb;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* renamed from: io.grpc.internal.zb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2508zb implements Nb.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fb f27810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2508zb(Fb fb) {
        this.f27810a = fb;
    }

    @Override // io.grpc.internal.Nb.a
    public void a() {
    }

    @Override // io.grpc.internal.Nb.a
    public void a(Status status) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f27810a.I;
        Preconditions.b(atomicBoolean.get(), "Channel must have been shut down");
    }

    @Override // io.grpc.internal.Nb.a
    public void b() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f27810a.I;
        Preconditions.b(atomicBoolean.get(), "Channel must have been shut down");
        this.f27810a.K = true;
        this.f27810a.b(false);
        this.f27810a.g();
        this.f27810a.h();
    }

    @Override // io.grpc.internal.Nb.a
    public void a(boolean z) {
        Fb fb = this.f27810a;
        fb.W.a(fb.G, z);
    }
}
