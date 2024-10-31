package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.AbstractC2408g;

/* compiled from: PartialForwardingClientCallListener.java */
/* loaded from: classes3.dex */
abstract class W<RespT> extends AbstractC2408g.a<RespT> {
    @Override // io.grpc.AbstractC2408g.a
    public void a(P p) {
        b().a(p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AbstractC2408g.a<?> b();

    public String toString() {
        return MoreObjects.a(this).a("delegate", b()).toString();
    }

    @Override // io.grpc.AbstractC2408g.a
    public void a(Status status, P p) {
        b().a(status, p);
    }

    @Override // io.grpc.AbstractC2408g.a
    public void a() {
        b().a();
    }
}
