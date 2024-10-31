package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ma implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17978a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimit f17979b;

    private ma(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f17978a = rateLimiterClient;
        this.f17979b = rateLimit;
    }

    public static io.reactivex.c.f a(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new ma(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        RateLimitProto.Counter a2;
        RateLimitProto.RateLimit rateLimit = (RateLimitProto.RateLimit) obj;
        a2 = rateLimit.a(this.f17979b.c(), this.f17978a.c());
        return a2;
    }
}
