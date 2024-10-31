package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class sa implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17995a;

    private sa(RateLimiterClient rateLimiterClient) {
        this.f17995a = rateLimiterClient;
    }

    public static io.reactivex.c.f a(RateLimiterClient rateLimiterClient) {
        return new sa(rateLimiterClient);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        io.reactivex.c a2;
        a2 = r0.f17821b.a(r2).a(ta.a(this.f17995a, (RateLimitProto.RateLimit) obj));
        return a2;
    }
}
