package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.B;
import io.grpc.Status;

/* JADX INFO: Add missing generic type declarations: [RespT] */
/* compiled from: CensusTracingModule.java */
/* loaded from: classes3.dex */
class K<RespT> extends B.a<RespT> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ L f27395b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(L l, AbstractC2408g.a aVar) {
        super(aVar);
        this.f27395b = l;
    }

    @Override // io.grpc.B.a, io.grpc.B, io.grpc.W, io.grpc.AbstractC2408g.a
    public void a(Status status, io.grpc.P p) {
        this.f27395b.f27417b.a(status);
        super.a(status, p);
    }
}
