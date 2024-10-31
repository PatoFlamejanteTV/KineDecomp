package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesTestDeviceHelperFactory implements d.a.c<TestDeviceHelper> {

    /* renamed from: a */
    private final ApiClientModule f17926a;

    /* renamed from: b */
    private final Provider<SharedPreferencesUtils> f17927b;

    public ApiClientModule_ProvidesTestDeviceHelperFactory(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider) {
        this.f17926a = apiClientModule;
        this.f17927b = provider;
    }

    public static d.a.c<TestDeviceHelper> a(ApiClientModule apiClientModule, Provider<SharedPreferencesUtils> provider) {
        return new ApiClientModule_ProvidesTestDeviceHelperFactory(apiClientModule, provider);
    }

    @Override // javax.inject.Provider
    public TestDeviceHelper get() {
        TestDeviceHelper a2 = this.f17926a.a(this.f17927b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
