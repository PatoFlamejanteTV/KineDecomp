package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Oc;

/* compiled from: ForwardingClientStreamListener.java */
/* loaded from: classes3.dex */
abstract class Ma implements ClientStreamListener {
    @Override // io.grpc.internal.ClientStreamListener
    public void a(io.grpc.P p) {
        b().a(p);
    }

    protected abstract ClientStreamListener b();

    public String toString() {
        return MoreObjects.a(this).a("delegate", b()).toString();
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void a(Status status, io.grpc.P p) {
        b().a(status, p);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
        b().a(status, rpcProgress, p);
    }

    @Override // io.grpc.internal.Oc
    public void a(Oc.a aVar) {
        b().a(aVar);
    }

    @Override // io.grpc.internal.Oc
    public void a() {
        b().a();
    }
}
