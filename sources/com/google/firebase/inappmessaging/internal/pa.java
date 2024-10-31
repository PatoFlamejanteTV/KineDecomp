package com.google.firebase.inappmessaging.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class pa implements io.reactivex.c.e {

    /* renamed from: a */
    private final RateLimiterClient f17987a;

    private pa(RateLimiterClient rateLimiterClient) {
        this.f17987a = rateLimiterClient;
    }

    public static io.reactivex.c.e a(RateLimiterClient rateLimiterClient) {
        return new pa(rateLimiterClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17987a.a();
    }
}
