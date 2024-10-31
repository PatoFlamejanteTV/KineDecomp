package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;

/* compiled from: MaybeFilterSingle.java */
/* loaded from: classes3.dex */
public final class d<T> extends io.reactivex.i<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<T> f28270a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.h<? super T> f28271b;

    /* compiled from: MaybeFilterSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements t<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28272a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.c.h<? super T> f28273b;

        /* renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f28274c;

        a(io.reactivex.j<? super T> jVar, io.reactivex.c.h<? super T> hVar) {
            this.f28272a = jVar;
            this.f28273b = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f28274c;
            this.f28274c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28274c.isDisposed();
        }

        @Override // io.reactivex.t
        public void onError(Throwable th) {
            this.f28272a.onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28274c, bVar)) {
                this.f28274c = bVar;
                this.f28272a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.t
        public void onSuccess(T t) {
            try {
                if (this.f28273b.test(t)) {
                    this.f28272a.onSuccess(t);
                } else {
                    this.f28272a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28272a.onError(th);
            }
        }
    }

    public d(u<T> uVar, io.reactivex.c.h<? super T> hVar) {
        this.f28270a = uVar;
        this.f28271b = hVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28270a.a(new a(jVar, this.f28271b));
    }
}
