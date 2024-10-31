package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.model.RateLimit;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class RateLimitModule {
    @AppForeground
    public RateLimit a() {
        return RateLimit.a().a(1L).a("APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY").b(TimeUnit.DAYS.toMillis(1L)).a();
    }
}
