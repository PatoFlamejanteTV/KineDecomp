package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToListSingle.java */
/* loaded from: classes3.dex */
public final class l<T, U extends Collection<? super T>> extends s<U> implements io.reactivex.d.b.b<U> {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.e<T> f28244a;

    /* renamed from: b, reason: collision with root package name */
    final Callable<U> f28245b;

    /* compiled from: FlowableToListSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements io.reactivex.h<T>, io.reactivex.disposables.b {

        /* renamed from: a, reason: collision with root package name */
        final t<? super U> f28246a;

        /* renamed from: b, reason: collision with root package name */
        g.b.c f28247b;

        /* renamed from: c, reason: collision with root package name */
        U f28248c;

        a(t<? super U> tVar, U u) {
            this.f28246a = tVar;
            this.f28248c = u;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28247b.cancel();
            this.f28247b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28247b == SubscriptionHelper.CANCELLED;
        }

        @Override // g.b.b
        public void onComplete() {
            this.f28247b = SubscriptionHelper.CANCELLED;
            this.f28246a.onSuccess(this.f28248c);
        }

        @Override // g.b.b
        public void onError(Throwable th) {
            this.f28248c = null;
            this.f28247b = SubscriptionHelper.CANCELLED;
            this.f28246a.onError(th);
        }

        @Override // g.b.b
        public void onNext(T t) {
            this.f28248c.add(t);
        }

        @Override // io.reactivex.h, g.b.b
        public void onSubscribe(g.b.c cVar) {
            if (SubscriptionHelper.validate(this.f28247b, cVar)) {
                this.f28247b = cVar;
                this.f28246a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public l(io.reactivex.e<T> eVar) {
        this(eVar, ArrayListSupplier.asCallable());
    }

    @Override // io.reactivex.d.b.b
    public io.reactivex.e<U> a() {
        return io.reactivex.f.a.a(new FlowableToList(this.f28244a, this.f28245b));
    }

    @Override // io.reactivex.s
    protected void b(t<? super U> tVar) {
        try {
            U call = this.f28245b.call();
            io.reactivex.d.a.b.a(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f28244a.a((io.reactivex.h) new a(tVar, call));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, tVar);
        }
    }

    public l(io.reactivex.e<T> eVar, Callable<U> callable) {
        this.f28244a = eVar;
        this.f28245b = callable;
    }
}
