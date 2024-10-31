package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;
import io.grpc.P;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GrpcClientModule_ProvidesApiKeyHeadersFactory implements d.a.c<P> {

    /* renamed from: a */
    private final GrpcClientModule f17950a;

    public GrpcClientModule_ProvidesApiKeyHeadersFactory(GrpcClientModule grpcClientModule) {
        this.f17950a = grpcClientModule;
    }

    public static d.a.c<P> a(GrpcClientModule grpcClientModule) {
        return new GrpcClientModule_ProvidesApiKeyHeadersFactory(grpcClientModule);
    }

    @Override // javax.inject.Provider
    public P get() {
        P a2 = this.f17950a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
