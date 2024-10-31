package com.google.firebase.inappmessaging.internal.injection.modules;

import d.a.f;
import io.reactivex.r;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesComputeSchedulerFactory implements d.a.c<r> {

    /* renamed from: a */
    private final SchedulerModule f17961a;

    public SchedulerModule_ProvidesComputeSchedulerFactory(SchedulerModule schedulerModule) {
        this.f17961a = schedulerModule;
    }

    public static d.a.c<r> a(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesComputeSchedulerFactory(schedulerModule);
    }

    @Override // javax.inject.Provider
    public r get() {
        r a2 = this.f17961a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
