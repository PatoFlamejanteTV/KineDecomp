package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class m<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b */
    final p<? extends T> f28359b;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T> {

        /* renamed from: a */
        final q<? super T> f28360a;

        /* renamed from: b */
        final p<? extends T> f28361b;

        /* renamed from: d */
        boolean f28363d = true;

        /* renamed from: c */
        final SequentialDisposable f28362c = new SequentialDisposable();

        a(q<? super T> qVar, p<? extends T> pVar) {
            this.f28360a = qVar;
            this.f28361b = pVar;
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f28363d) {
                this.f28363d = false;
                this.f28361b.a(this);
            } else {
                this.f28360a.onComplete();
            }
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            this.f28360a.onError(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28363d) {
                this.f28363d = false;
            }
            this.f28360a.onNext(t);
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28362c.update(bVar);
        }
    }

    public m(p<T> pVar, p<? extends T> pVar2) {
        super(pVar);
        this.f28359b = pVar2;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        a aVar = new a(qVar, this.f28359b);
        qVar.onSubscribe(aVar.f28362c);
        this.f28315a.a(aVar);
    }
}
