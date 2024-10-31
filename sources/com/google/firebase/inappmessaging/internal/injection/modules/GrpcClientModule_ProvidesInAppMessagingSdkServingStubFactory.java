package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import d.a.f;
import io.grpc.AbstractC2407f;
import io.grpc.P;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements d.a.c<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> {

    /* renamed from: a, reason: collision with root package name */
    private final GrpcClientModule f17951a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<AbstractC2407f> f17952b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<P> f17953c;

    public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(GrpcClientModule grpcClientModule, Provider<AbstractC2407f> provider, Provider<P> provider2) {
        this.f17951a = grpcClientModule;
        this.f17952b = provider;
        this.f17953c = provider2;
    }

    public static d.a.c<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> a(GrpcClientModule grpcClientModule, Provider<AbstractC2407f> provider, Provider<P> provider2) {
        return new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(grpcClientModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub get() {
        InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub a2 = this.f17951a.a(this.f17952b.get(), this.f17953c.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
