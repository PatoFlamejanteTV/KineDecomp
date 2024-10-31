package io.grpc;

import io.grpc.AbstractC2408g;
import io.grpc.MethodDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
/* compiled from: ClientInterceptors.java */
/* renamed from: io.grpc.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2509j<ReqT, RespT> extends V<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC2408g f27812a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MethodDescriptor f27813b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2510k f27814c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2509j(C2510k c2510k, AbstractC2408g abstractC2408g, MethodDescriptor methodDescriptor) {
        this.f27814c = c2510k;
        this.f27812a = abstractC2408g;
        this.f27813b = methodDescriptor;
    }

    @Override // io.grpc.AbstractC2408g
    public void a(AbstractC2408g.a<RespT> aVar, P p) {
        this.f27812a.a(new C2410i(this, aVar), p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.V
    public AbstractC2408g<?, ?> b() {
        return this.f27812a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.AbstractC2408g
    public void a(ReqT reqt) {
        this.f27812a.a((AbstractC2408g) this.f27814c.f27815a.a(this.f27813b.b().a((MethodDescriptor.b<ReqT>) reqt)));
    }
}
