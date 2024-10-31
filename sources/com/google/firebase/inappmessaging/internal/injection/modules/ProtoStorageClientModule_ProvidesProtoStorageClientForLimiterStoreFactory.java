package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory implements d.a.c<ProtoStorageClient> {

    /* renamed from: a */
    private final ProtoStorageClientModule f17958a;

    /* renamed from: b */
    private final Provider<Application> f17959b;

    public ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.f17958a = protoStorageClientModule;
        this.f17959b = provider;
    }

    public static d.a.c<ProtoStorageClient> a(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory(protoStorageClientModule, provider);
    }

    @Override // javax.inject.Provider
    public ProtoStorageClient get() {
        ProtoStorageClient c2 = this.f17958a.c(this.f17959b.get());
        f.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }
}
