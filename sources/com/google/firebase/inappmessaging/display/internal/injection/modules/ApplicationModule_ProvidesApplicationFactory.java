package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import d.a.c;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidesApplicationFactory implements c<Application> {

    /* renamed from: a */
    private final ApplicationModule f17648a;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.f17648a = applicationModule;
    }

    public static c<Application> a(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    @Override // javax.inject.Provider
    public Application get() {
        Application a2 = this.f17648a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
