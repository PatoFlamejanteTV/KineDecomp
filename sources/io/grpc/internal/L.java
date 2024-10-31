package io.grpc.internal;

import io.grpc.A;
import io.grpc.AbstractC2408g;
import io.grpc.internal.J;

/* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
/* compiled from: CensusTracingModule.java */
/* loaded from: classes3.dex */
class L<ReqT, RespT> extends A.a<ReqT, RespT> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ J.a f27417b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ J.e f27418c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(J.e eVar, AbstractC2408g abstractC2408g, J.a aVar) {
        super(abstractC2408g);
        this.f27418c = eVar;
        this.f27417b = aVar;
    }

    @Override // io.grpc.A, io.grpc.AbstractC2408g
    public void a(AbstractC2408g.a<RespT> aVar, io.grpc.P p) {
        b().a(new K(this, aVar), p);
    }
}
