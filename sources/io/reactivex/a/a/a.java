package io.reactivex.a.a;

import io.reactivex.c.f;
import io.reactivex.r;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private static volatile f<Callable<r>, r> f28090a;

    /* renamed from: b */
    private static volatile f<r, r> f28091b;

    public static r a(r rVar) {
        if (rVar != null) {
            f<r, r> fVar = f28091b;
            return fVar == null ? rVar : (r) a((f<r, R>) fVar, rVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static r b(Callable<r> callable) {
        if (callable != null) {
            f<Callable<r>, r> fVar = f28090a;
            if (fVar == null) {
                return a(callable);
            }
            return a(fVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    static r a(Callable<r> callable) {
        try {
            r call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }

    static r a(f<Callable<r>, r> fVar, Callable<r> callable) {
        r rVar = (r) a((f<Callable<r>, R>) fVar, callable);
        if (rVar != null) {
            return rVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }
}
