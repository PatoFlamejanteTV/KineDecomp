package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GrpcClient_Factory implements d.a.c<GrpcClient> {

    /* renamed from: a */
    private final Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> f17767a;

    public GrpcClient_Factory(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        this.f17767a = provider;
    }

    public static d.a.c<GrpcClient> a(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        return new GrpcClient_Factory(provider);
    }

    @Override // javax.inject.Provider
    public GrpcClient get() {
        return new GrpcClient(this.f17767a.get());
    }
}
