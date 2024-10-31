package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class RateLimiterClient {

    /* renamed from: a */
    private static final RateLimitProto.RateLimit f17820a = RateLimitProto.RateLimit.n();

    /* renamed from: b */
    private final ProtoStorageClient f17821b;

    /* renamed from: c */
    private final Clock f17822c;

    /* renamed from: d */
    private io.reactivex.i<RateLimitProto.RateLimit> f17823d = io.reactivex.i.b();

    @Inject
    public RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock) {
        this.f17821b = protoStorageClient;
        this.f17822c = clock;
    }

    private static RateLimitProto.Counter a(RateLimitProto.Counter counter) {
        return RateLimitProto.Counter.b(counter).c().b(counter.p() + 1).build();
    }

    private RateLimitProto.Counter c() {
        return RateLimitProto.Counter.q().b(0L).a(this.f17822c.now()).build();
    }

    public io.reactivex.a a(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return b().a((io.reactivex.i<RateLimitProto.RateLimit>) f17820a).b(la.a(this, rateLimit));
    }

    public io.reactivex.s<Boolean> b(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return b().b(io.reactivex.i.b(RateLimitProto.RateLimit.n())).d(ma.a(this, rateLimit)).a((io.reactivex.c.h<? super R>) na.a(this, rateLimit)).c();
    }

    public static /* synthetic */ boolean b(RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return rateLimiterClient.a(counter, rateLimit) || counter.p() < rateLimit.b();
    }

    private io.reactivex.i<RateLimitProto.RateLimit> b() {
        return this.f17823d.b(this.f17821b.a(RateLimitProto.RateLimit.o()).b(oa.a(this))).a(pa.a(this));
    }

    public static /* synthetic */ boolean a(RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return !rateLimiterClient.a(counter, rateLimit);
    }

    private boolean a(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return this.f17822c.now() - counter.o() > rateLimit.d();
    }

    public void a(RateLimitProto.RateLimit rateLimit) {
        this.f17823d = io.reactivex.i.b(rateLimit);
    }

    public void a() {
        this.f17823d = io.reactivex.i.b();
    }
}
