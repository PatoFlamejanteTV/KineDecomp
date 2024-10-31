package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesDataCollectionHelperFactory implements d.a.c<DataCollectionHelper> {

    /* renamed from: a, reason: collision with root package name */
    private final ApiClientModule f17920a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<SharedPreferencesUtils> f17921b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<Subscriber> f17922c;

    public ApiClientModule_ProvidesDataCollectionHelperFactory(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider, Provider<Subscriber> provider2) {
        this.f17920a = apiClientModule;
        this.f17921b = provider;
        this.f17922c = provider2;
    }

    public static d.a.c<DataCollectionHelper> a(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider, Provider<Subscriber> provider2) {
        return new ApiClientModule_ProvidesDataCollectionHelperFactory(apiClientModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public DataCollectionHelper get() {
        DataCollectionHelper a2 = this.f17920a.a(this.f17921b.get(), this.f17922c.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
