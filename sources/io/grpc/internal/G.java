package io.grpc.internal;

import io.grpc.A;
import io.grpc.AbstractC2408g;
import io.grpc.internal.E;

/* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
/* compiled from: CensusStatsModule.java */
/* loaded from: classes3.dex */
class G<ReqT, RespT> extends A.a<ReqT, RespT> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E.a f27307b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E.c f27308c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(E.c cVar, AbstractC2408g abstractC2408g, E.a aVar) {
        super(abstractC2408g);
        this.f27308c = cVar;
        this.f27307b = aVar;
    }

    @Override // io.grpc.A, io.grpc.AbstractC2408g
    public void a(AbstractC2408g.a<RespT> aVar, io.grpc.P p) {
        b().a(new F(this, aVar), p);
    }
}
