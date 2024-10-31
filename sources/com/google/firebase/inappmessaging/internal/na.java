package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class na implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17982a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimit f17983b;

    private na(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f17982a = rateLimiterClient;
        this.f17983b = rateLimit;
    }

    public static io.reactivex.c.h a(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new na(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        return RateLimiterClient.b(this.f17982a, this.f17983b, (RateLimitProto.Counter) obj);
    }
}
