package io.reactivex.internal.subscribers;

import g.b.c;
import io.reactivex.c.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class LambdaSubscriber<T> extends AtomicReference<c> implements h<T>, c, io.reactivex.disposables.b, io.reactivex.e.a {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.c.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super c> onSubscribe;

    public LambdaSubscriber(e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.c.a aVar, e<? super c> eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
    }

    @Override // g.b.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.d.a.a.f28107f;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.b.b
    public void onComplete() {
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.f.a.b(th);
            }
        }
    }

    @Override // g.b.b
    public void onError(Throwable th) {
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                io.reactivex.f.a.b(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.f.a.b(th);
    }

    @Override // g.b.b
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.h, g.b.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // g.b.c
    public void request(long j) {
        get().request(j);
    }
}
