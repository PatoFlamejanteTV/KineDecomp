package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.C2403b;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.Nb;
import io.grpc.internal.Y;
import java.util.concurrent.Executor;

/* compiled from: ForwardingConnectionClientTransport.java */
/* loaded from: classes3.dex */
abstract class Na implements InterfaceC2424da {
    @Override // io.grpc.internal.Nb
    public Runnable a(Nb.a aVar) {
        return b().a(aVar);
    }

    protected abstract InterfaceC2424da b();

    @Override // io.grpc.internal.Nb
    public void b(Status status) {
        b().b(status);
    }

    @Override // io.grpc.internal.InterfaceC2424da
    public C2403b getAttributes() {
        return b().getAttributes();
    }

    public String toString() {
        return MoreObjects.a(this).a("delegate", b()).toString();
    }

    @Override // io.grpc.internal.Nb
    public void a(Status status) {
        b().a(status);
    }

    @Override // io.grpc.internal.Y
    public X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        return b().a(methodDescriptor, p, c2406e);
    }

    @Override // io.grpc.internal.Y
    public void a(Y.a aVar, Executor executor) {
        b().a(aVar, executor);
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return b().a();
    }
}
