package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.s;
import io.reactivex.t;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes3.dex */
public final class l<T> extends s<T> {

    /* renamed from: a, reason: collision with root package name */
    final p<? extends T> f28352a;

    /* renamed from: b, reason: collision with root package name */
    final T f28353b;

    /* compiled from: ObservableSingleSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final t<? super T> f28354a;

        /* renamed from: b, reason: collision with root package name */
        final T f28355b;

        /* renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f28356c;

        /* renamed from: d, reason: collision with root package name */
        T f28357d;

        /* renamed from: e, reason: collision with root package name */
        boolean f28358e;

        a(t<? super T> tVar, T t) {
            this.f28354a = tVar;
            this.f28355b = t;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28356c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28356c.isDisposed();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f28358e) {
                return;
            }
            this.f28358e = true;
            T t = this.f28357d;
            this.f28357d = null;
            if (t == null) {
                t = this.f28355b;
            }
            if (t != null) {
                this.f28354a.onSuccess(t);
            } else {
                this.f28354a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.f28358e) {
                io.reactivex.f.a.b(th);
            } else {
                this.f28358e = true;
                this.f28354a.onError(th);
            }
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28358e) {
                return;
            }
            if (this.f28357d != null) {
                this.f28358e = true;
                this.f28356c.dispose();
                this.f28354a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f28357d = t;
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28356c, bVar)) {
                this.f28356c = bVar;
                this.f28354a.onSubscribe(this);
            }
        }
    }

    public l(p<? extends T> pVar, T t) {
        this.f28352a = pVar;
        this.f28353b = t;
    }

    @Override // io.reactivex.s
    public void b(t<? super T> tVar) {
        this.f28352a.a(new a(tVar, this.f28353b));
    }
}
