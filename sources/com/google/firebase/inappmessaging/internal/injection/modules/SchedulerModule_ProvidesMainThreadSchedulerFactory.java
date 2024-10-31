package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;
import io.reactivex.r;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesMainThreadSchedulerFactory implements d.a.c<r> {

    /* renamed from: a */
    private final SchedulerModule f17963a;

    public SchedulerModule_ProvidesMainThreadSchedulerFactory(SchedulerModule schedulerModule) {
        this.f17963a = schedulerModule;
    }

    public static d.a.c<r> a(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesMainThreadSchedulerFactory(schedulerModule);
    }

    @Override // javax.inject.Provider
    public r get() {
        r c2 = this.f17963a.c();
        f.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }
}
