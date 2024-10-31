package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {

    /* renamed from: b */
    final io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> f28251b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.j<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4375739915521278546L;
        final io.reactivex.j<? super R> downstream;
        final io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> mapper;
        io.reactivex.disposables.b upstream;

        /* loaded from: classes3.dex */
        final class a implements io.reactivex.j<R> {
            a() {
            }

            @Override // io.reactivex.j
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // io.reactivex.j
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // io.reactivex.j
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // io.reactivex.j
            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }
        }

        FlatMapMaybeObserver(io.reactivex.j<? super R> jVar, io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> fVar) {
            this.downstream = jVar;
            this.mapper = fVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
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
            this.downstream.onError(th);
        }

        @Override // io.reactivex.j
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            try {
                io.reactivex.k<? extends R> apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null MaybeSource");
                io.reactivex.k<? extends R> kVar = apply;
                if (isDisposed()) {
                    return;
                }
                kVar.a(new a());
            } catch (Exception e2) {
                io.reactivex.exceptions.a.b(e2);
                this.downstream.onError(e2);
            }
        }
    }

    public MaybeFlatten(io.reactivex.k<T> kVar, io.reactivex.c.f<? super T, ? extends io.reactivex.k<? extends R>> fVar) {
        super(kVar);
        this.f28251b = fVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.j<? super R> jVar) {
        this.f28264a.a(new FlatMapMaybeObserver(jVar, this.f28251b));
    }
}
