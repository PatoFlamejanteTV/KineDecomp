package io.grpc.internal;

import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.internal.AbstractC2503y;
import io.opencensus.trace.Span;

/* compiled from: BinaryLogProvider.java */
/* renamed from: io.grpc.internal.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2500x implements InterfaceC2409h {
    @Override // io.grpc.InterfaceC2409h
    public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
        Span a2 = io.opencensus.trace.q.b().a();
        if (a2 == null) {
            return abstractC2407f.a(methodDescriptor, c2406e);
        }
        return abstractC2407f.a(methodDescriptor, c2406e.a(AbstractC2503y.f27789b, AbstractC2503y.c.a(a2)));
    }
}
