package io.reactivex.internal.operators.completable;

import io.reactivex.c.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class CompletableResumeNext extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c f28155a;

    /* renamed from: b, reason: collision with root package name */
    final f<? super Throwable, ? extends io.reactivex.c> f28156b;

    /* loaded from: classes3.dex */
    static final class ResumeNextObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.b, io.reactivex.disposables.b {
        private static final long serialVersionUID = 5018523762564524046L;
        final io.reactivex.b downstream;
        final f<? super Throwable, ? extends io.reactivex.c> errorMapper;
        boolean once;

        ResumeNextObserver(io.reactivex.b bVar, f<? super Throwable, ? extends io.reactivex.c> fVar) {
            this.downstream = bVar;
            this.errorMapper = fVar;
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
            this.downstream.onComplete();
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            if (this.once) {
                this.downstream.onError(th);
                return;
            }
            this.once = true;
            try {
                io.reactivex.c apply = this.errorMapper.apply(th);
                io.reactivex.d.a.b.a(apply, "The errorMapper returned a null CompletableSource");
                apply.a(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public CompletableResumeNext(io.reactivex.c cVar, f<? super Throwable, ? extends io.reactivex.c> fVar) {
        this.f28155a = cVar;
        this.f28156b = fVar;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(bVar, this.f28156b);
        bVar.onSubscribe(resumeNextObserver);
        this.f28155a.a(resumeNextObserver);
    }
}
