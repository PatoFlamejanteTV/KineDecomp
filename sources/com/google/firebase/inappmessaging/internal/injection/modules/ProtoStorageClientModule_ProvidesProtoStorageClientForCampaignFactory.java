package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory implements d.a.c<ProtoStorageClient> {

    /* renamed from: a */
    private final ProtoStorageClientModule f17954a;

    /* renamed from: b */
    private final Provider<Application> f17955b;

    public ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.f17954a = protoStorageClientModule;
        this.f17955b = provider;
    }

    public static d.a.c<ProtoStorageClient> a(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory(protoStorageClientModule, provider);
    }

    @Override // javax.inject.Provider
    public ProtoStorageClient get() {
        ProtoStorageClient a2 = this.f17954a.a(this.f17955b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
