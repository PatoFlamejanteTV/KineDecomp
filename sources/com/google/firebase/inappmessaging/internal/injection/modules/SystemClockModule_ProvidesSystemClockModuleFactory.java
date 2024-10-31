package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SystemClockModule_ProvidesSystemClockModuleFactory implements d.a.c<Clock> {

    /* renamed from: a */
    private final SystemClockModule f17964a;

    public SystemClockModule_ProvidesSystemClockModuleFactory(SystemClockModule systemClockModule) {
        this.f17964a = systemClockModule;
    }

    public static d.a.c<Clock> a(SystemClockModule systemClockModule) {
        return new SystemClockModule_ProvidesSystemClockModuleFactory(systemClockModule);
    }

    @Override // javax.inject.Provider
    public Clock get() {
        Clock a2 = this.f17964a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
