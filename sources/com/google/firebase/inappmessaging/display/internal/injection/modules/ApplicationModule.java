package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class ApplicationModule {

    /* renamed from: a */
    private final Application f17647a;

    public ApplicationModule(Application application) {
        this.f17647a = application;
    }

    @Singleton
    public Application a() {
        return this.f17647a;
    }
}
