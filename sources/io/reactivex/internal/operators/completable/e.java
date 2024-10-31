package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletablePeek.java */
/* loaded from: classes3.dex */
public final class e extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c f28164a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.e<? super io.reactivex.disposables.b> f28165b;

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.e<? super Throwable> f28166c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.c.a f28167d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.c.a f28168e;

    /* renamed from: f, reason: collision with root package name */
    final io.reactivex.c.a f28169f;

    /* renamed from: g, reason: collision with root package name */
    final io.reactivex.c.a f28170g;

    /* compiled from: CompletablePeek.java */
    /* loaded from: classes3.dex */
    final class a implements io.reactivex.b, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.b f28171a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f28172b;

        a(io.reactivex.b bVar) {
            this.f28171a = bVar;
        }

        void a() {
            try {
                e.this.f28169f.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(th);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            try {
                e.this.f28170g.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(th);
            }
            this.f28172b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28172b.isDisposed();
        }

        @Override // io.reactivex.b
        public void onComplete() {
            if (this.f28172b == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                e.this.f28167d.run();
                e.this.f28168e.run();
                this.f28171a.onComplete();
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f28171a.onError(th);
            }
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            if (this.f28172b == DisposableHelper.DISPOSED) {
                io.reactivex.f.a.b(th);
                return;
            }
            try {
                e.this.f28166c.accept(th);
                e.this.f28168e.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f28171a.onError(th);
            a();
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            try {
                e.this.f28165b.accept(bVar);
                if (DisposableHelper.validate(this.f28172b, bVar)) {
                    this.f28172b = bVar;
                    this.f28171a.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                this.f28172b = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.f28171a);
            }
        }
    }

    public e(io.reactivex.c cVar, io.reactivex.c.e<? super io.reactivex.disposables.b> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3, io.reactivex.c.a aVar4) {
        this.f28164a = cVar;
        this.f28165b = eVar;
        this.f28166c = eVar2;
        this.f28167d = aVar;
        this.f28168e = aVar2;
        this.f28169f = aVar3;
        this.f28170g = aVar4;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        this.f28164a.a(new a(bVar));
    }
}
