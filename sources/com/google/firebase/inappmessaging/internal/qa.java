package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class qa implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17989a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimit f17990b;

    private qa(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f17989a = rateLimiterClient;
        this.f17990b = rateLimit;
    }

    public static io.reactivex.c.h a(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new qa(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        return RateLimiterClient.a(this.f17989a, this.f17990b, (RateLimitProto.Counter) obj);
    }
}
