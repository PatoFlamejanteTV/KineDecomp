package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class oa implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final RateLimiterClient f17985a;

    private oa(RateLimiterClient rateLimiterClient) {
        this.f17985a = rateLimiterClient;
    }

    public static io.reactivex.c.e a(RateLimiterClient rateLimiterClient) {
        return new oa(rateLimiterClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17985a.a((RateLimitProto.RateLimit) obj);
    }
}
