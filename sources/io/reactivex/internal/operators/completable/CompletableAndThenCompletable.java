package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class CompletableAndThenCompletable extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c f28151a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c f28152b;

    /* loaded from: classes3.dex */
    static final class SourceObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.b, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4101678820158072998L;
        final io.reactivex.b actualObserver;
        final io.reactivex.c next;

        SourceObserver(io.reactivex.b bVar, io.reactivex.c cVar) {
            this.actualObserver = bVar;
            this.next = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.b
        public void onComplete() {
            this.next.a(new a(this, this.actualObserver));
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class a implements io.reactivex.b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f28153a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.b f28154b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.b bVar) {
            this.f28153a = atomicReference;
            this.f28154b = bVar;
        }

        @Override // io.reactivex.b
        public void onComplete() {
            this.f28154b.onComplete();
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            this.f28154b.onError(th);
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f28153a, bVar);
        }
    }

    public CompletableAndThenCompletable(io.reactivex.c cVar, io.reactivex.c cVar2) {
        this.f28151a = cVar;
        this.f28152b = cVar2;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        this.f28151a.a(new SourceObserver(bVar, this.f28152b));
    }
}
