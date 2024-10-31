package com.nexstreaming.kinemaster.ui.f.a;

import io.reactivex.m;
import io.reactivex.subjects.PublishSubject;

/* compiled from: RxEventBus.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f21583a;

    /* renamed from: b, reason: collision with root package name */
    private PublishSubject<a> f21584b = PublishSubject.f();

    private b() {
    }

    public static b a() {
        if (f21583a == null) {
            f21583a = new b();
        }
        return f21583a;
    }

    public m<a> b() {
        return this.f21584b;
    }

    public void a(a aVar) {
        this.f21584b.onNext(aVar);
    }
}
