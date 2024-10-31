package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesSharedPreferencesUtilsFactory implements d.a.c<SharedPreferencesUtils> {

    /* renamed from: a */
    private final ApiClientModule f17925a;

    public ApiClientModule_ProvidesSharedPreferencesUtilsFactory(ApiClientModule apiClientModule) {
        this.f17925a = apiClientModule;
    }

    public static d.a.c<SharedPreferencesUtils> a(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesSharedPreferencesUtilsFactory(apiClientModule);
    }

    @Override // javax.inject.Provider
    public SharedPreferencesUtils get() {
        SharedPreferencesUtils c2 = this.f17925a.c();
        f.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }
}
