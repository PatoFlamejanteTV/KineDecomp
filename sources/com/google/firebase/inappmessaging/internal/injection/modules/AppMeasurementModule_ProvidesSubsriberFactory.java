package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AppMeasurementModule_ProvidesSubsriberFactory implements d.a.c<Subscriber> {

    /* renamed from: a */
    private final AppMeasurementModule f17931a;

    public AppMeasurementModule_ProvidesSubsriberFactory(AppMeasurementModule appMeasurementModule) {
        this.f17931a = appMeasurementModule;
    }

    public static d.a.c<Subscriber> a(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesSubsriberFactory(appMeasurementModule);
    }

    @Override // javax.inject.Provider
    public Subscriber get() {
        Subscriber b2 = this.f17931a.b();
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
