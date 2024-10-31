package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ta implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17997a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimitProto.RateLimit f17998b;

    private ta(RateLimiterClient rateLimiterClient, RateLimitProto.RateLimit rateLimit) {
        this.f17997a = rateLimiterClient;
        this.f17998b = rateLimit;
    }

    public static io.reactivex.c.a a(RateLimiterClient rateLimiterClient, RateLimitProto.RateLimit rateLimit) {
        return new ta(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.c.a
    public void run() {
        this.f17997a.a(this.f17998b);
    }
}
