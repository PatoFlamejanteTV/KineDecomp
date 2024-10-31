package io.reactivex;

import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import java.util.concurrent.Callable;

/* compiled from: Completable.java */
/* loaded from: classes3.dex */
public abstract class a implements c {
    public static a a() {
        return io.reactivex.f.a.a(io.reactivex.internal.operators.completable.a.f28157a);
    }

    public static a b(io.reactivex.c.a aVar) {
        io.reactivex.d.a.b.a(aVar, "run is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.completable.b(aVar));
    }

    protected abstract void b(b bVar);

    public final io.reactivex.disposables.b c() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> i<T> d() {
        if (this instanceof io.reactivex.d.b.c) {
            return ((io.reactivex.d.b.c) this).b();
        }
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.f(this));
    }

    public static a a(Callable<?> callable) {
        io.reactivex.d.a.b.a(callable, "callable is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.completable.c(callable));
    }

    public final a b() {
        return a(io.reactivex.d.a.a.a());
    }

    private static NullPointerException a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final a a(c cVar) {
        io.reactivex.d.a.b.a(cVar, "next is null");
        return io.reactivex.f.a.a(new CompletableAndThenCompletable(this, cVar));
    }

    public final a a(io.reactivex.c.a aVar) {
        io.reactivex.c.e<? super io.reactivex.disposables.b> b2 = io.reactivex.d.a.a.b();
        io.reactivex.c.e<? super Throwable> b3 = io.reactivex.d.a.a.b();
        io.reactivex.c.a aVar2 = io.reactivex.d.a.a.f28104c;
        return a(b2, b3, aVar, aVar2, aVar2, aVar2);
    }

    public final a a(io.reactivex.c.e<? super Throwable> eVar) {
        io.reactivex.c.e<? super io.reactivex.disposables.b> b2 = io.reactivex.d.a.a.b();
        io.reactivex.c.a aVar = io.reactivex.d.a.a.f28104c;
        return a(b2, eVar, aVar, aVar, aVar, aVar);
    }

    private a a(io.reactivex.c.e<? super io.reactivex.disposables.b> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3, io.reactivex.c.a aVar4) {
        io.reactivex.d.a.b.a(eVar, "onSubscribe is null");
        io.reactivex.d.a.b.a(eVar2, "onError is null");
        io.reactivex.d.a.b.a(aVar, "onComplete is null");
        io.reactivex.d.a.b.a(aVar2, "onTerminate is null");
        io.reactivex.d.a.b.a(aVar3, "onAfterTerminate is null");
        io.reactivex.d.a.b.a(aVar4, "onDispose is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.completable.e(this, eVar, eVar2, aVar, aVar2, aVar3, aVar4));
    }

    public final a a(io.reactivex.c.h<? super Throwable> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.completable.d(this, hVar));
    }

    public final a a(io.reactivex.c.f<? super Throwable, ? extends c> fVar) {
        io.reactivex.d.a.b.a(fVar, "errorMapper is null");
        return io.reactivex.f.a.a(new CompletableResumeNext(this, fVar));
    }

    @Override // io.reactivex.c
    public final void a(b bVar) {
        io.reactivex.d.a.b.a(bVar, "observer is null");
        try {
            b a2 = io.reactivex.f.a.a(this, bVar);
            io.reactivex.d.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
            throw a(th);
        }
    }
}
