package io.reactivex.internal.operators.single;

import io.reactivex.s;
import io.reactivex.t;

/* compiled from: SingleJust.java */
/* loaded from: classes3.dex */
public final class c<T> extends s<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f28375a;

    public c(T t) {
        this.f28375a = t;
    }

    @Override // io.reactivex.s
    protected void b(t<? super T> tVar) {
        tVar.onSubscribe(io.reactivex.disposables.c.a());
        tVar.onSuccess(this.f28375a);
    }
}
