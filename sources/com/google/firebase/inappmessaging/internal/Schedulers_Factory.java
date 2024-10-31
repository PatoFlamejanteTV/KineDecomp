package com.google.firebase.inappmessaging.internal;

import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class Schedulers_Factory implements d.a.c<Schedulers> {

    /* renamed from: a */
    private final Provider<io.reactivex.r> f17830a;

    /* renamed from: b */
    private final Provider<io.reactivex.r> f17831b;

    /* renamed from: c */
    private final Provider<io.reactivex.r> f17832c;

    public Schedulers_Factory(Provider<io.reactivex.r> provider, Provider<io.reactivex.r> provider2, Provider<io.reactivex.r> provider3) {
        this.f17830a = provider;
        this.f17831b = provider2;
        this.f17832c = provider3;
    }

    public static d.a.c<Schedulers> a(Provider<io.reactivex.r> provider, Provider<io.reactivex.r> provider2, Provider<io.reactivex.r> provider3) {
        return new Schedulers_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public Schedulers get() {
        return new Schedulers(this.f17830a.get(), this.f17831b.get(), this.f17832c.get());
    }
}
