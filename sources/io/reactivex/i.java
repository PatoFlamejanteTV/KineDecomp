package io.reactivex;

import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import java.util.concurrent.Callable;

/* compiled from: Maybe.java */
/* loaded from: classes3.dex */
public abstract class i<T> implements k<T> {
    public static <T> i<T> a(Callable<? extends T> callable) {
        io.reactivex.d.a.b.a(callable, "callable is null");
        return io.reactivex.f.a.a((i) new io.reactivex.internal.operators.maybe.e(callable));
    }

    public static <T> i<T> b() {
        return io.reactivex.f.a.a((i) io.reactivex.internal.operators.maybe.b.f28265a);
    }

    protected abstract void b(j<? super T> jVar);

    public final <R> m<R> c(io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new MaybeFlatMapObservable(this, fVar));
    }

    public final <R> i<R> d(io.reactivex.c.f<? super T, ? extends R> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.j(this, fVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<T> e() {
        if (this instanceof io.reactivex.d.b.b) {
            return ((io.reactivex.d.b.b) this).a();
        }
        return io.reactivex.f.a.a(new MaybeToFlowable(this));
    }

    public static <T> i<T> b(T t) {
        io.reactivex.d.a.b.a((Object) t, "item is null");
        return io.reactivex.f.a.a((i) new io.reactivex.internal.operators.maybe.i(t));
    }

    public final i<T> a(T t) {
        io.reactivex.d.a.b.a((Object) t, "defaultItem is null");
        return b((k) b(t));
    }

    public final s<Boolean> c() {
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.h(this));
    }

    public final io.reactivex.disposables.b d() {
        return a(io.reactivex.d.a.a.b(), io.reactivex.d.a.a.f28107f, io.reactivex.d.a.a.f28104c);
    }

    public final i<T> b(io.reactivex.c.e<? super T> eVar) {
        io.reactivex.c.e b2 = io.reactivex.d.a.a.b();
        io.reactivex.d.a.b.a(eVar, "onSuccess is null");
        io.reactivex.c.e b3 = io.reactivex.d.a.a.b();
        io.reactivex.c.a aVar = io.reactivex.d.a.a.f28104c;
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.k(this, b2, eVar, b3, aVar, aVar, aVar));
    }

    public final <E extends j<? super T>> E c(E e2) {
        a((j) e2);
        return e2;
    }

    public final i<T> e(io.reactivex.c.f<? super Throwable, ? extends k<? extends T>> fVar) {
        io.reactivex.d.a.b.a(fVar, "resumeFunction is null");
        return io.reactivex.f.a.a(new MaybeOnErrorNext(this, fVar, true));
    }

    public final i<T> a(io.reactivex.c.e<? super Throwable> eVar) {
        io.reactivex.c.e b2 = io.reactivex.d.a.a.b();
        io.reactivex.c.e b3 = io.reactivex.d.a.a.b();
        io.reactivex.d.a.b.a(eVar, "onError is null");
        io.reactivex.c.a aVar = io.reactivex.d.a.a.f28104c;
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.k(this, b2, b3, eVar, aVar, aVar, aVar));
    }

    public final a b(io.reactivex.c.f<? super T, ? extends c> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new MaybeFlatMapCompletable(this, fVar));
    }

    public final i<T> a(io.reactivex.c.h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.c(this, hVar));
    }

    public final i<T> b(k<? extends T> kVar) {
        io.reactivex.d.a.b.a(kVar, "other is null");
        return io.reactivex.f.a.a(new MaybeSwitchIfEmpty(this, kVar));
    }

    public final <R> i<R> a(io.reactivex.c.f<? super T, ? extends k<? extends R>> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new MaybeFlatten(this, fVar));
    }

    public final i<T> a(k<? extends T> kVar) {
        io.reactivex.d.a.b.a(kVar, "next is null");
        return e(io.reactivex.d.a.a.c(kVar));
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar) {
        io.reactivex.d.a.b.a(eVar, "onSuccess is null");
        io.reactivex.d.a.b.a(eVar2, "onError is null");
        io.reactivex.d.a.b.a(aVar, "onComplete is null");
        MaybeCallbackObserver maybeCallbackObserver = new MaybeCallbackObserver(eVar, eVar2, aVar);
        c((i<T>) maybeCallbackObserver);
        return maybeCallbackObserver;
    }

    @Override // io.reactivex.k
    public final void a(j<? super T> jVar) {
        io.reactivex.d.a.b.a(jVar, "observer is null");
        j<? super T> a2 = io.reactivex.f.a.a(this, jVar);
        io.reactivex.d.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b((j) a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final i<T> a(r rVar) {
        io.reactivex.d.a.b.a(rVar, "scheduler is null");
        return io.reactivex.f.a.a(new MaybeSubscribeOn(this, rVar));
    }
}
