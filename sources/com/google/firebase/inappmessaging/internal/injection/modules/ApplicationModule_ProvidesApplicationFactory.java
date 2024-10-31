package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidesApplicationFactory implements d.a.c<Application> {

    /* renamed from: a */
    private final ApplicationModule f17933a;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.f17933a = applicationModule;
    }

    public static d.a.c<Application> a(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    @Override // javax.inject.Provider
    public Application get() {
        Application a2 = this.f17933a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
