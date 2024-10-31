package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ra implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimitProto.RateLimit f17992a;

    /* renamed from: b, reason: collision with root package name */
    private final RateLimit f17993b;

    private ra(RateLimitProto.RateLimit rateLimit, RateLimit rateLimit2) {
        this.f17992a = rateLimit;
        this.f17993b = rateLimit2;
    }

    public static io.reactivex.c.f a(RateLimitProto.RateLimit rateLimit, RateLimit rateLimit2) {
        return new ra(rateLimit, rateLimit2);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        RateLimitProto.RateLimit build;
        build = RateLimitProto.RateLimit.b(this.f17992a).a(this.f17993b.c(), RateLimiterClient.a((RateLimitProto.Counter) obj)).build();
        return build;
    }
}
