package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.android.gms.clearcut.ClearcutLogger;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ClearcutLoggerClientModule_ProvidesClearcutClientFactory implements d.a.c<ClearcutLogger> {

    /* renamed from: a, reason: collision with root package name */
    private final ClearcutLoggerClientModule f17940a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Application> f17941b;

    public ClearcutLoggerClientModule_ProvidesClearcutClientFactory(ClearcutLoggerClientModule clearcutLoggerClientModule, Provider<Application> provider) {
        this.f17940a = clearcutLoggerClientModule;
        this.f17941b = provider;
    }

    public static d.a.c<ClearcutLogger> a(ClearcutLoggerClientModule clearcutLoggerClientModule, Provider<Application> provider) {
        return new ClearcutLoggerClientModule_ProvidesClearcutClientFactory(clearcutLoggerClientModule, provider);
    }

    @Override // javax.inject.Provider
    public ClearcutLogger get() {
        ClearcutLogger a2 = this.f17940a.a(this.f17941b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
