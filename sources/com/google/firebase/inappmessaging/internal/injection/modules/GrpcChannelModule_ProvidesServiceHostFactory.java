package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GrpcChannelModule_ProvidesServiceHostFactory implements d.a.c<String> {

    /* renamed from: a */
    private final GrpcChannelModule f17948a;

    public GrpcChannelModule_ProvidesServiceHostFactory(GrpcChannelModule grpcChannelModule) {
        this.f17948a = grpcChannelModule;
    }

    public static d.a.c<String> a(GrpcChannelModule grpcChannelModule) {
        return new GrpcChannelModule_ProvidesServiceHostFactory(grpcChannelModule);
    }

    @Override // javax.inject.Provider
    public String get() {
        String a2 = this.f17948a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
