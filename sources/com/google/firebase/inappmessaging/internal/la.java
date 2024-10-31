package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class la implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17975a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimit f17976b;

    private la(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.f17975a = rateLimiterClient;
        this.f17976b = rateLimit;
    }

    public static io.reactivex.c.f a(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new la(rateLimiterClient, rateLimit);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        io.reactivex.c b2;
        b2 = io.reactivex.m.b(r3.a(r1.c(), r0.c())).b(qa.a(r0, r1)).a((io.reactivex.p) io.reactivex.m.b(r0.c())).c(ra.a((RateLimitProto.RateLimit) obj, this.f17976b)).b(sa.a(this.f17975a));
        return b2;
    }
}
