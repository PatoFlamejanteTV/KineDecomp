package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* compiled from: PartialForwardingClientCall.java */
/* loaded from: classes3.dex */
abstract class V<ReqT, RespT> extends AbstractC2408g<ReqT, RespT> {
    @Override // io.grpc.AbstractC2408g
    public void a(int i) {
        b().a(i);
    }

    public abstract AbstractC2408g<?, ?> b();

    public String toString() {
        return MoreObjects.a(this).a("delegate", b()).toString();
    }

    @Override // io.grpc.AbstractC2408g
    public void a(@Nullable String str, @Nullable Throwable th) {
        b().a(str, th);
    }

    @Override // io.grpc.AbstractC2408g
    public void a() {
        b().a();
    }
}
