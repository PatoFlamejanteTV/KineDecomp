package io.reactivex.internal.operators.single;

import io.reactivex.c.e;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;

/* compiled from: SingleDoOnSuccess.java */
/* loaded from: classes3.dex */
public final class b<T> extends s<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<T> f28371a;

    /* renamed from: b, reason: collision with root package name */
    final e<? super T> f28372b;

    /* compiled from: SingleDoOnSuccess.java */
    /* loaded from: classes3.dex */
    final class a implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        final t<? super T> f28373a;

        a(t<? super T> tVar) {
            this.f28373a = tVar;
        }

        @Override // io.reactivex.t
        public void onError(Throwable th) {
            this.f28373a.onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28373a.onSubscribe(bVar);
        }

        @Override // io.reactivex.t
        public void onSuccess(T t) {
            try {
                b.this.f28372b.accept(t);
                this.f28373a.onSuccess(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28373a.onError(th);
            }
        }
    }

    public b(u<T> uVar, e<? super T> eVar) {
        this.f28371a = uVar;
        this.f28372b = eVar;
    }

    @Override // io.reactivex.s
    protected void b(t<? super T> tVar) {
        this.f28371a.a(new a(tVar));
    }
}
