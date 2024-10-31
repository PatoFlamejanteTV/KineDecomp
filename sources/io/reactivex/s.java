package io.reactivex;

import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleToFlowable;

/* compiled from: Single.java */
/* loaded from: classes3.dex */
public abstract class s<T> implements u<T> {
    public static <T> s<T> a(T t) {
        io.reactivex.d.a.b.a((Object) t, "item is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.single.c(t));
    }

    public final s<T> b(io.reactivex.c.e<? super T> eVar) {
        io.reactivex.d.a.b.a(eVar, "onSuccess is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.single.b(this, eVar));
    }

    protected abstract void b(t<? super T> tVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final e<T> c() {
        if (this instanceof io.reactivex.d.b.b) {
            return ((io.reactivex.d.b.b) this).a();
        }
        return io.reactivex.f.a.a(new SingleToFlowable(this));
    }

    public final s<T> a(io.reactivex.c.e<? super Throwable> eVar) {
        io.reactivex.d.a.b.a(eVar, "onError is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.single.a(this, eVar));
    }

    public final i<T> a(io.reactivex.c.h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.maybe.d(this, hVar));
    }

    public final s<T> a(s<? extends T> sVar) {
        io.reactivex.d.a.b.a(sVar, "resumeSingleInCaseOfError is null");
        return a((io.reactivex.c.f) io.reactivex.d.a.a.c(sVar));
    }

    public final s<T> a(io.reactivex.c.f<? super Throwable, ? extends u<? extends T>> fVar) {
        io.reactivex.d.a.b.a(fVar, "resumeFunctionInCaseOfError is null");
        return io.reactivex.f.a.a(new SingleResumeNext(this, fVar));
    }

    @Override // io.reactivex.u
    public final void a(t<? super T> tVar) {
        io.reactivex.d.a.b.a(tVar, "observer is null");
        t<? super T> a2 = io.reactivex.f.a.a(this, tVar);
        io.reactivex.d.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
