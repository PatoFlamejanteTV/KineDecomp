package io.reactivex.internal.operators.single;

import io.reactivex.c.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;

/* compiled from: SingleDoOnError.java */
/* loaded from: classes3.dex */
public final class a<T> extends s<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<T> f28367a;

    /* renamed from: b, reason: collision with root package name */
    final e<? super Throwable> f28368b;

    /* compiled from: SingleDoOnError.java */
    /* renamed from: io.reactivex.internal.operators.single.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    final class C0162a implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final t<? super T> f28369a;

        C0162a(t<? super T> tVar) {
            this.f28369a = tVar;
        }

        @Override // io.reactivex.t
        public void onError(Throwable th) {
            try {
                a.this.f28368b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f28369a.onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28369a.onSubscribe(bVar);
        }

        @Override // io.reactivex.t
        public void onSuccess(T t) {
            this.f28369a.onSuccess(t);
        }
    }

    public a(u<T> uVar, e<? super Throwable> eVar) {
        this.f28367a = uVar;
        this.f28368b = eVar;
    }

    @Override // io.reactivex.s
    protected void b(t<? super T> tVar) {
        this.f28367a.a(new C0162a(tVar));
    }
}
