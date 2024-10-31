package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeOnErrorNext<T> extends a<T, T> {

    /* renamed from: b */
    final io.reactivex.c.f<? super Throwable, ? extends io.reactivex.k<? extends T>> f28253b;

    /* renamed from: c */
    final boolean f28254c;

    /* loaded from: classes3.dex */
    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final io.reactivex.j<? super T> downstream;
        final io.reactivex.c.f<? super Throwable, ? extends io.reactivex.k<? extends T>> resumeFunction;

        /* loaded from: classes3.dex */
        static final class a<T> implements io.reactivex.j<T> {

            /* renamed from: a */
            final io.reactivex.j<? super T> f28255a;

            /* renamed from: b */
            final AtomicReference<io.reactivex.disposables.b> f28256b;

            a(io.reactivex.j<? super T> jVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
                this.f28255a = jVar;
                this.f28256b = atomicReference;
            }

            @Override // io.reactivex.j
            public void onComplete() {
                this.f28255a.onComplete();
            }

            @Override // io.reactivex.j
            public void onError(Throwable th) {
                this.f28255a.onError(th);
            }

            @Override // io.reactivex.j
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this.f28256b, bVar);
            }

            @Override // io.reactivex.j
            public void onSuccess(T t) {
                this.f28255a.onSuccess(t);
            }
        }

        OnErrorNextMaybeObserver(io.reactivex.j<? super T> jVar, io.reactivex.c.f<? super Throwable, ? extends io.reactivex.k<? extends T>> fVar, boolean z) {
            this.downstream = jVar;
            this.resumeFunction = fVar;
            this.allowFatal = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.j
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                io.reactivex.k<? extends T> apply = this.resumeFunction.apply(th);
                io.reactivex.d.a.b.a(apply, "The resumeFunction returned a null MaybeSource");
                io.reactivex.k<? extends T> kVar = apply;
                DisposableHelper.replace(this, null);
                kVar.a(new a(this.downstream, this));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public MaybeOnErrorNext(io.reactivex.k<T> kVar, io.reactivex.c.f<? super Throwable, ? extends io.reactivex.k<? extends T>> fVar, boolean z) {
        super(kVar);
        this.f28253b = fVar;
        this.f28254c = z;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28264a.a(new OnErrorNextMaybeObserver(jVar, this.f28253b, this.f28254c));
    }
}
