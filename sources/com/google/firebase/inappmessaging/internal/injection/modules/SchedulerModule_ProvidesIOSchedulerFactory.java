package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;
import io.reactivex.r;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesIOSchedulerFactory implements d.a.c<r> {

    /* renamed from: a */
    private final SchedulerModule f17962a;

    public SchedulerModule_ProvidesIOSchedulerFactory(SchedulerModule schedulerModule) {
        this.f17962a = schedulerModule;
    }

    public static d.a.c<r> a(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesIOSchedulerFactory(schedulerModule);
    }

    @Override // javax.inject.Provider
    public r get() {
        r b2 = this.f17962a.b();
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
