package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesApiClientFactory implements d.a.c<ApiClient> {

    /* renamed from: a, reason: collision with root package name */
    private final ApiClientModule f17916a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<GrpcClient> f17917b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<Application> f17918c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<DataCollectionHelper> f17919d;

    public ApiClientModule_ProvidesApiClientFactory(ApiClientModule apiClientModule, Provider<GrpcClient> provider, Provider<Application> provider2, Provider<DataCollectionHelper> provider3) {
        this.f17916a = apiClientModule;
        this.f17917b = provider;
        this.f17918c = provider2;
        this.f17919d = provider3;
    }

    public static d.a.c<ApiClient> a(ApiClientModule apiClientModule, Provider<GrpcClient> provider, Provider<Application> provider2, Provider<DataCollectionHelper> provider3) {
        return new ApiClientModule_ProvidesApiClientFactory(apiClientModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public ApiClient get() {
        ApiClient a2 = this.f17916a.a(this.f17917b.get(), this.f17918c.get(), this.f17919d.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
