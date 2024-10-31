package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.model.RateLimit;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements d.a.c<RateLimit> {

    /* renamed from: a */
    private final RateLimitModule f17960a;

    @Override // javax.inject.Provider
    public RateLimit get() {
        RateLimit a2 = this.f17960a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
