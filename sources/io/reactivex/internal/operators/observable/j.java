package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes3.dex */
public final class j<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.f<? super Throwable, ? extends p<? extends T>> f28339b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f28340c;

    /* compiled from: ObservableOnErrorNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T> {

        /* renamed from: a, reason: collision with root package name */
        final q<? super T> f28341a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.c.f<? super Throwable, ? extends p<? extends T>> f28342b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f28343c;

        /* renamed from: d, reason: collision with root package name */
        final SequentialDisposable f28344d = new SequentialDisposable();

        /* renamed from: e, reason: collision with root package name */
        boolean f28345e;

        /* renamed from: f, reason: collision with root package name */
        boolean f28346f;

        a(q<? super T> qVar, io.reactivex.c.f<? super Throwable, ? extends p<? extends T>> fVar, boolean z) {
            this.f28341a = qVar;
            this.f28342b = fVar;
            this.f28343c = z;
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f28346f) {
                return;
            }
            this.f28346f = true;
            this.f28345e = true;
            this.f28341a.onComplete();
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.f28345e) {
                if (this.f28346f) {
                    io.reactivex.f.a.b(th);
                    return;
                } else {
                    this.f28341a.onError(th);
                    return;
                }
            }
            this.f28345e = true;
            if (this.f28343c && !(th instanceof Exception)) {
                this.f28341a.onError(th);
                return;
            }
            try {
                p<? extends T> apply = this.f28342b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.f28341a.onError(nullPointerException);
                    return;
                }
                apply.a(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28341a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28346f) {
                return;
            }
            this.f28341a.onNext(t);
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28344d.replace(bVar);
        }
    }

    public j(p<T> pVar, io.reactivex.c.f<? super Throwable, ? extends p<? extends T>> fVar, boolean z) {
        super(pVar);
        this.f28339b = fVar;
        this.f28340c = z;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        a aVar = new a(qVar, this.f28339b, this.f28340c);
        qVar.onSubscribe(aVar.f28344d);
        this.f28315a.a(aVar);
    }
}
