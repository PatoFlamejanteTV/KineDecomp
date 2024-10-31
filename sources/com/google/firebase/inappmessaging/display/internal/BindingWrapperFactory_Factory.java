package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class BindingWrapperFactory_Factory implements d.a.c<BindingWrapperFactory> {

    /* renamed from: a */
    private final Provider<Application> f17539a;

    public BindingWrapperFactory_Factory(Provider<Application> provider) {
        this.f17539a = provider;
    }

    public static d.a.c<BindingWrapperFactory> a(Provider<Application> provider) {
        return new BindingWrapperFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public BindingWrapperFactory get() {
        return new BindingWrapperFactory(this.f17539a.get());
    }
}
