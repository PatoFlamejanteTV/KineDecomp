package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: MaybePeek.java */
/* loaded from: classes3.dex */
public final class k<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.e<? super io.reactivex.disposables.b> f28289b;

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.e<? super T> f28290c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.c.e<? super Throwable> f28291d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.c.a f28292e;

    /* renamed from: f, reason: collision with root package name */
    final io.reactivex.c.a f28293f;

    /* renamed from: g, reason: collision with root package name */
    final io.reactivex.c.a f28294g;

    public k(io.reactivex.k<T> kVar, io.reactivex.c.e<? super io.reactivex.disposables.b> eVar, io.reactivex.c.e<? super T> eVar2, io.reactivex.c.e<? super Throwable> eVar3, io.reactivex.c.a aVar, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3) {
        super(kVar);
        this.f28289b = eVar;
        this.f28290c = eVar2;
        this.f28291d = eVar3;
        this.f28292e = aVar;
        this.f28293f = aVar2;
        this.f28294g = aVar3;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super T> jVar) {
        this.f28264a.a(new a(jVar, this));
    }

    /* compiled from: MaybePeek.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements io.reactivex.j<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.j<? super T> f28295a;

        /* renamed from: b, reason: collision with root package name */
        final k<T> f28296b;

        /* renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f28297c;

        a(io.reactivex.j<? super T> jVar, k<T> kVar) {
            this.f28295a = jVar;
            this.f28296b = kVar;
        }

        void a(Throwable th) {
            try {
                this.f28296b.f28291d.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f28297c = DisposableHelper.DISPOSED;
            this.f28295a.onError(th);
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            try {
                this.f28296b.f28294g.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(th);
            }
            this.f28297c.dispose();
            this.f28297c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28297c.isDisposed();
        }

        @Override // io.reactivex.j
        public void onComplete() {
            if (this.f28297c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.f28296b.f28292e.run();
                this.f28297c = DisposableHelper.DISPOSED;
                this.f28295a.onComplete();
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            if (this.f28297c == DisposableHelper.DISPOSED) {
                io.reactivex.f.a.b(th);
            } else {
                a(th);
            }
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f28297c, bVar)) {
                try {
                    this.f28296b.f28289b.accept(bVar);
                    this.f28297c = bVar;
                    this.f28295a.onSubscribe(this);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    this.f28297c = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.f28295a);
                }
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            if (this.f28297c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.f28296b.f28290c.accept(t);
                this.f28297c = DisposableHelper.DISPOSED;
                this.f28295a.onSuccess(t);
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        void a() {
            try {
                this.f28296b.f28293f.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(th);
            }
        }
    }
}
