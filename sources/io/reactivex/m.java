package io.reactivex;

import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;

/* compiled from: Observable.java */
/* loaded from: classes3.dex */
public abstract class m<T> implements p<T> {
    public static int a() {
        return e.a();
    }

    public static <T> m<T> b() {
        return io.reactivex.f.a.a(io.reactivex.internal.operators.observable.c.f28322a);
    }

    protected abstract void b(q<? super T> qVar);

    public final a c() {
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.g(this));
    }

    public final m<T> d(io.reactivex.c.f<? super Throwable, ? extends p<? extends T>> fVar) {
        io.reactivex.d.a.b.a(fVar, "resumeFunction is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.j(this, fVar, false));
    }

    public final s<T> e() {
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.l(this, null));
    }

    public static <T> m<T> a(o<T> oVar) {
        io.reactivex.d.a.b.a(oVar, "source is null");
        return io.reactivex.f.a.a(new ObservableCreate(oVar));
    }

    public static <T> m<T> b(T t) {
        io.reactivex.d.a.b.a((Object) t, "item is null");
        return io.reactivex.f.a.a((m) new io.reactivex.internal.operators.observable.h(t));
    }

    public final <R> m<R> c(io.reactivex.c.f<? super T, ? extends R> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.i(this, fVar));
    }

    public final i<T> d() {
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.k(this));
    }

    public static <T> m<T> a(Callable<? extends Throwable> callable) {
        io.reactivex.d.a.b.a(callable, "errorSupplier is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.d(callable));
    }

    public final m<T> b(io.reactivex.c.h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.e(this, hVar));
    }

    public static <T> m<T> a(Throwable th) {
        io.reactivex.d.a.b.a(th, "exception is null");
        return a((Callable<? extends Throwable>) io.reactivex.d.a.a.b(th));
    }

    public final a b(io.reactivex.c.f<? super T, ? extends c> fVar) {
        return a((io.reactivex.c.f) fVar, false);
    }

    public final m<T> b(r rVar) {
        io.reactivex.d.a.b.a(rVar, "scheduler is null");
        return io.reactivex.f.a.a(new ObservableSubscribeOn(this, rVar));
    }

    public static <T> m<T> a(Iterable<? extends T> iterable) {
        io.reactivex.d.a.b.a(iterable, "source is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.f(iterable));
    }

    public final s<Boolean> a(io.reactivex.c.h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.b(this, hVar));
    }

    public final <R> m<R> a(io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar) {
        return a(fVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> m<R> a(io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar, int i) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        io.reactivex.d.a.b.a(i, "prefetch");
        if (this instanceof io.reactivex.d.b.l) {
            Object call = ((io.reactivex.d.b.l) this).call();
            if (call == null) {
                return b();
            }
            return ObservableScalarXMap.a(call, fVar);
        }
        return io.reactivex.f.a.a(new ObservableConcatMap(this, fVar, i, ErrorMode.IMMEDIATE));
    }

    public final s<Boolean> a(Object obj) {
        io.reactivex.d.a.b.a(obj, "element is null");
        return a((io.reactivex.c.h) io.reactivex.d.a.a.a(obj));
    }

    public final a a(io.reactivex.c.f<? super T, ? extends c> fVar, boolean z) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new ObservableFlatMapCompletableCompletable(this, fVar, z));
    }

    public final m<T> a(r rVar) {
        return a(rVar, false, a());
    }

    public final m<T> a(r rVar, boolean z, int i) {
        io.reactivex.d.a.b.a(rVar, "scheduler is null");
        io.reactivex.d.a.b.a(i, "bufferSize");
        return io.reactivex.f.a.a(new ObservableObserveOn(this, rVar, z, i));
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar) {
        return a(eVar, io.reactivex.d.a.a.f28107f, io.reactivex.d.a.a.f28104c, io.reactivex.d.a.a.b());
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, io.reactivex.d.a.a.f28104c, io.reactivex.d.a.a.b());
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.e<? super io.reactivex.disposables.b> eVar3) {
        io.reactivex.d.a.b.a(eVar, "onNext is null");
        io.reactivex.d.a.b.a(eVar2, "onError is null");
        io.reactivex.d.a.b.a(aVar, "onComplete is null");
        io.reactivex.d.a.b.a(eVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(eVar, eVar2, aVar, eVar3);
        a((q) lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.p
    public final void a(q<? super T> qVar) {
        io.reactivex.d.a.b.a(qVar, "observer is null");
        try {
            q<? super T> a2 = io.reactivex.f.a.a(this, qVar);
            io.reactivex.d.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b((q) a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final m<T> a(p<? extends T> pVar) {
        io.reactivex.d.a.b.a(pVar, "other is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.observable.m(this, pVar));
    }

    public final e<T> a(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.h hVar = new io.reactivex.internal.operators.flowable.h(this);
        int i = l.f28487a[backpressureStrategy.ordinal()];
        if (i == 1) {
            return hVar.e();
        }
        if (i == 2) {
            return hVar.f();
        }
        if (i == 3) {
            return hVar;
        }
        if (i != 4) {
            return hVar.d();
        }
        return io.reactivex.f.a.a(new FlowableOnBackpressureError(hVar));
    }
}
