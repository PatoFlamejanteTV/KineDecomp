package io.reactivex.f;

import io.reactivex.c.b;
import io.reactivex.c.e;
import io.reactivex.c.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.i;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.Callable;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile e<? super Throwable> f28125a;

    /* renamed from: b, reason: collision with root package name */
    static volatile f<? super Runnable, ? extends Runnable> f28126b;

    /* renamed from: c, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f28127c;

    /* renamed from: d, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f28128d;

    /* renamed from: e, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f28129e;

    /* renamed from: f, reason: collision with root package name */
    static volatile f<? super Callable<r>, ? extends r> f28130f;

    /* renamed from: g, reason: collision with root package name */
    static volatile f<? super r, ? extends r> f28131g;

    /* renamed from: h, reason: collision with root package name */
    static volatile f<? super r, ? extends r> f28132h;
    static volatile f<? super r, ? extends r> i;
    static volatile f<? super io.reactivex.e, ? extends io.reactivex.e> j;
    static volatile f<? super io.reactivex.b.a, ? extends io.reactivex.b.a> k;
    static volatile f<? super m, ? extends m> l;
    static volatile f<? super i, ? extends i> m;
    static volatile f<? super s, ? extends s> n;
    static volatile f<? super io.reactivex.a, ? extends io.reactivex.a> o;
    static volatile b<? super io.reactivex.e, ? super g.b.b, ? extends g.b.b> p;
    static volatile b<? super i, ? super j, ? extends j> q;
    static volatile b<? super m, ? super q, ? extends q> r;
    static volatile b<? super s, ? super t, ? extends t> s;
    static volatile b<? super io.reactivex.a, ? super io.reactivex.b, ? extends io.reactivex.b> t;

    public static r a(r rVar) {
        f<? super r, ? extends r> fVar = f28131g;
        return fVar == null ? rVar : (r) a((f<r, R>) fVar, rVar);
    }

    public static r b(Callable<r> callable) {
        io.reactivex.d.a.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f28127c;
        if (fVar == null) {
            return a(callable);
        }
        return a(fVar, callable);
    }

    public static r c(Callable<r> callable) {
        io.reactivex.d.a.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f28129e;
        if (fVar == null) {
            return a(callable);
        }
        return a(fVar, callable);
    }

    public static r d(Callable<r> callable) {
        io.reactivex.d.a.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f28130f;
        if (fVar == null) {
            return a(callable);
        }
        return a(fVar, callable);
    }

    public static r e(Callable<r> callable) {
        io.reactivex.d.a.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<r>, ? extends r> fVar = f28128d;
        if (fVar == null) {
            return a(callable);
        }
        return a(fVar, callable);
    }

    static boolean a(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static void b(Throwable th) {
        e<? super Throwable> eVar = f28125a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new UndeliverableException(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static r c(r rVar) {
        f<? super r, ? extends r> fVar = f28132h;
        return fVar == null ? rVar : (r) a((f<r, R>) fVar, rVar);
    }

    public static Runnable a(Runnable runnable) {
        io.reactivex.d.a.b.a(runnable, "run is null");
        f<? super Runnable, ? extends Runnable> fVar = f28126b;
        return fVar == null ? runnable : (Runnable) a((f<Runnable, R>) fVar, runnable);
    }

    public static <T> g.b.b<? super T> a(io.reactivex.e<T> eVar, g.b.b<? super T> bVar) {
        b<? super io.reactivex.e, ? super g.b.b, ? extends g.b.b> bVar2 = p;
        return bVar2 != null ? (g.b.b) a(bVar2, eVar, bVar) : bVar;
    }

    public static <T> q<? super T> a(m<T> mVar, q<? super T> qVar) {
        b<? super m, ? super q, ? extends q> bVar = r;
        return bVar != null ? (q) a(bVar, mVar, qVar) : qVar;
    }

    public static r b(r rVar) {
        f<? super r, ? extends r> fVar = i;
        return fVar == null ? rVar : (r) a((f<r, R>) fVar, rVar);
    }

    public static <T> t<? super T> a(s<T> sVar, t<? super T> tVar) {
        b<? super s, ? super t, ? extends t> bVar = s;
        return bVar != null ? (t) a(bVar, sVar, tVar) : tVar;
    }

    public static io.reactivex.b a(io.reactivex.a aVar, io.reactivex.b bVar) {
        b<? super io.reactivex.a, ? super io.reactivex.b, ? extends io.reactivex.b> bVar2 = t;
        return bVar2 != null ? (io.reactivex.b) a(bVar2, aVar, bVar) : bVar;
    }

    public static <T> j<? super T> a(i<T> iVar, j<? super T> jVar) {
        b<? super i, ? super j, ? extends j> bVar = q;
        return bVar != null ? (j) a(bVar, iVar, jVar) : jVar;
    }

    public static <T> i<T> a(i<T> iVar) {
        f<? super i, ? extends i> fVar = m;
        return fVar != null ? (i) a((f<i<T>, R>) fVar, iVar) : iVar;
    }

    public static <T> io.reactivex.e<T> a(io.reactivex.e<T> eVar) {
        f<? super io.reactivex.e, ? extends io.reactivex.e> fVar = j;
        return fVar != null ? (io.reactivex.e) a((f<io.reactivex.e<T>, R>) fVar, eVar) : eVar;
    }

    public static <T> io.reactivex.b.a<T> a(io.reactivex.b.a<T> aVar) {
        f<? super io.reactivex.b.a, ? extends io.reactivex.b.a> fVar = k;
        return fVar != null ? (io.reactivex.b.a) a((f<io.reactivex.b.a<T>, R>) fVar, aVar) : aVar;
    }

    public static <T> m<T> a(m<T> mVar) {
        f<? super m, ? extends m> fVar = l;
        return fVar != null ? (m) a((f<m<T>, R>) fVar, mVar) : mVar;
    }

    public static <T> s<T> a(s<T> sVar) {
        f<? super s, ? extends s> fVar = n;
        return fVar != null ? (s) a((f<s<T>, R>) fVar, sVar) : sVar;
    }

    public static io.reactivex.a a(io.reactivex.a aVar) {
        f<? super io.reactivex.a, ? extends io.reactivex.a> fVar = o;
        return fVar != null ? (io.reactivex.a) a((f<io.reactivex.a, R>) fVar, aVar) : aVar;
    }

    static <T, R> R a(f<T, R> fVar, T t2) {
        try {
            return fVar.apply(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static <T, U, R> R a(b<T, U, R> bVar, T t2, U u) {
        try {
            return bVar.apply(t2, u);
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static r a(Callable<r> callable) {
        try {
            r call = callable.call();
            io.reactivex.d.a.b.a(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static r a(f<? super Callable<r>, ? extends r> fVar, Callable<r> callable) {
        Object a2 = a((f<Callable<r>, Object>) fVar, callable);
        io.reactivex.d.a.b.a(a2, "Scheduler Callable result can't be null");
        return (r) a2;
    }
}
