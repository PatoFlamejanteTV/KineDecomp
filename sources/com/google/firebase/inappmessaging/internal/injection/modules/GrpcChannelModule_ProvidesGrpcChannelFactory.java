package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;
import io.grpc.AbstractC2407f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GrpcChannelModule_ProvidesGrpcChannelFactory implements d.a.c<AbstractC2407f> {

    /* renamed from: a */
    private final GrpcChannelModule f17946a;

    /* renamed from: b */
    private final Provider<String> f17947b;

    public GrpcChannelModule_ProvidesGrpcChannelFactory(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        this.f17946a = grpcChannelModule;
        this.f17947b = provider;
    }

    public static d.a.c<AbstractC2407f> a(GrpcChannelModule grpcChannelModule, Provider<String> provider) {
        return new GrpcChannelModule_ProvidesGrpcChannelFactory(grpcChannelModule, provider);
    }

    @Override // javax.inject.Provider
    public AbstractC2407f get() {
        AbstractC2407f a2 = this.f17946a.a(this.f17947b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
