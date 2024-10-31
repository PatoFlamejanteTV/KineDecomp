package com.google.firebase.inappmessaging.internal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class Schedulers {

    /* renamed from: a */
    private final io.reactivex.r f17827a;

    /* renamed from: b */
    private final io.reactivex.r f17828b;

    /* renamed from: c */
    private final io.reactivex.r f17829c;

    @Inject
    public Schedulers(@Named("io") io.reactivex.r rVar, @Named("compute") io.reactivex.r rVar2, @Named("main") io.reactivex.r rVar3) {
        this.f17827a = rVar;
        this.f17828b = rVar2;
        this.f17829c = rVar3;
    }

    public io.reactivex.r a() {
        return this.f17827a;
    }

    public io.reactivex.r b() {
        return this.f17829c;
    }
}
