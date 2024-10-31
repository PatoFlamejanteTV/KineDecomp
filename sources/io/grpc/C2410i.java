package io.grpc;

import io.grpc.AbstractC2408g;
import io.grpc.MethodDescriptor;

/* JADX INFO: Add missing generic type declarations: [WRespT] */
/* compiled from: ClientInterceptors.java */
/* renamed from: io.grpc.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2410i<WRespT> extends W<WRespT> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC2408g.a f27195a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2509j f27196b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2410i(C2509j c2509j, AbstractC2408g.a aVar) {
        this.f27196b = c2509j;
        this.f27195a = aVar;
    }

    @Override // io.grpc.AbstractC2408g.a
    public void a(WRespT wrespt) {
        this.f27195a.a((AbstractC2408g.a) this.f27196b.f27813b.c().a(this.f27196b.f27814c.f27816b.a((MethodDescriptor.b) wrespt)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.W
    public AbstractC2408g.a<?> b() {
        return this.f27195a;
    }
}
