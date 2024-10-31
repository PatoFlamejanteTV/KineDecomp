package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.s;
import io.reactivex.t;

/* compiled from: ObservableAnySingle.java */
/* loaded from: classes3.dex */
public final class b<T> extends s<Boolean> implements io.reactivex.d.b.d<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final p<T> f28316a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.h<? super T> f28317b;

    /* compiled from: ObservableAnySingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements q<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final t<? super Boolean> f28318a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.c.h<? super T> f28319b;

        /* renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f28320c;

        /* renamed from: d, reason: collision with root package name */
        boolean f28321d;

        a(t<? super Boolean> tVar, io.reactivex.c.h<? super T> hVar) {
            this.f28318a = tVar;
            this.f28319b = hVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28320c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28320c.isDisposed();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (this.f28321d) {
                return;
            }
            this.f28321d = true;
            this.f28318a.onSuccess(false);
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.f28321d) {
                io.reactivex.f.a.b(th);
            } else {
                this.f28321d = true;
                this.f28318a.onError(th);
            }
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28321d) {
                return;
            }
            try {
                if (this.f28319b.test(t)) {
                    this.f28321d = true;
                    this.f28320c.dispose();
                    this.f28318a.onSuccess(true);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28320c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28320c, bVar)) {
                this.f28320c = bVar;
                this.f28318a.onSubscribe(this);
            }
        }
    }

    public b(p<T> pVar, io.reactivex.c.h<? super T> hVar) {
        this.f28316a = pVar;
        this.f28317b = hVar;
    }

    @Override // io.reactivex.s
    protected void b(t<? super Boolean> tVar) {
        this.f28316a.a(new a(tVar, this.f28317b));
    }
}
