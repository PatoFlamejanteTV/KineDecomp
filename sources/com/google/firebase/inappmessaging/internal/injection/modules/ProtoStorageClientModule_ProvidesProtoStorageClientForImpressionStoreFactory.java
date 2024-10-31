package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory implements d.a.c<ProtoStorageClient> {

    /* renamed from: a */
    private final ProtoStorageClientModule f17956a;

    /* renamed from: b */
    private final Provider<Application> f17957b;

    public ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.f17956a = protoStorageClientModule;
        this.f17957b = provider;
    }

    public static d.a.c<ProtoStorageClient> a(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory(protoStorageClientModule, provider);
    }

    @Override // javax.inject.Provider
    public ProtoStorageClient get() {
        ProtoStorageClient b2 = this.f17956a.b(this.f17957b.get());
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
