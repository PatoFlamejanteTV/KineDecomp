package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ApplicationModule {

    /* renamed from: a */
    private final Application f17932a;

    public ApplicationModule(Application application) {
        this.f17932a = application;
    }

    @Singleton
    public Application a() {
        return this.f17932a;
    }
}
