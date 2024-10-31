package io.grpc;

import io.grpc.MethodDescriptor;

/* compiled from: ClientInterceptors.java */
/* renamed from: io.grpc.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2510k implements InterfaceC2409h {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MethodDescriptor.b f27815a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MethodDescriptor.b f27816b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ InterfaceC2409h f27817c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2510k(MethodDescriptor.b bVar, MethodDescriptor.b bVar2, InterfaceC2409h interfaceC2409h) {
        this.f27815a = bVar;
        this.f27816b = bVar2;
        this.f27817c = interfaceC2409h;
    }

    @Override // io.grpc.InterfaceC2409h
    public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
        return new C2509j(this, this.f27817c.a(methodDescriptor.b(this.f27815a, this.f27816b).a(), c2406e, abstractC2407f), methodDescriptor);
    }
}
