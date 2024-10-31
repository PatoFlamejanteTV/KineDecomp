package com.squareup.okhttp;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool.java */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a */
    private static final o f25511a;

    /* renamed from: b */
    private final Executor f25512b;

    /* renamed from: c */
    private final int f25513c;

    /* renamed from: d */
    private final long f25514d;

    /* renamed from: e */
    private Runnable f25515e;

    /* renamed from: f */
    private final Deque<com.squareup.okhttp.a.a.c> f25516f;

    /* renamed from: g */
    final com.squareup.okhttp.a.m f25517g;

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000L;
        if (property != null && !Boolean.parseBoolean(property)) {
            f25511a = new o(0, parseLong);
        } else if (property3 != null) {
            f25511a = new o(Integer.parseInt(property3), parseLong);
        } else {
            f25511a = new o(5, parseLong);
        }
    }

    public o(int i, long j) {
        this(i, j, TimeUnit.MILLISECONDS);
    }

    public static o a() {
        return f25511a;
    }

    public void b(com.squareup.okhttp.a.a.c cVar) {
        if (this.f25516f.isEmpty()) {
            this.f25512b.execute(this.f25515e);
        }
        this.f25516f.add(cVar);
    }

    public o(int i, long j, TimeUnit timeUnit) {
        this.f25512b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.squareup.okhttp.a.o.a("OkHttp ConnectionPool", true));
        this.f25515e = new n(this);
        this.f25516f = new ArrayDeque();
        this.f25517g = new com.squareup.okhttp.a.m();
        this.f25513c = i;
        this.f25514d = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    public com.squareup.okhttp.a.a.c a(C2375a c2375a, com.squareup.okhttp.internal.http.w wVar) {
        for (com.squareup.okhttp.a.a.c cVar : this.f25516f) {
            if (cVar.l.size() < cVar.a() && c2375a.equals(cVar.getRoute().f25124a) && !cVar.m) {
                wVar.a(cVar);
                return cVar;
            }
        }
        return null;
    }

    public boolean a(com.squareup.okhttp.a.a.c cVar) {
        if (!cVar.m && this.f25513c != 0) {
            notifyAll();
            return false;
        }
        this.f25516f.remove(cVar);
        return true;
    }

    public long a(long j) {
        synchronized (this) {
            int i = 0;
            com.squareup.okhttp.a.a.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            for (com.squareup.okhttp.a.a.c cVar2 : this.f25516f) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.n;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f25514d && i <= this.f25513c) {
                if (i > 0) {
                    return this.f25514d - j2;
                }
                if (i2 <= 0) {
                    return -1L;
                }
                return this.f25514d;
            }
            this.f25516f.remove(cVar);
            com.squareup.okhttp.a.o.a(cVar.c());
            return 0L;
        }
    }

    private int a(com.squareup.okhttp.a.a.c cVar, long j) {
        List<Reference<com.squareup.okhttp.internal.http.w>> list = cVar.l;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).get() != null) {
                i++;
            } else {
                com.squareup.okhttp.a.h.f25191a.warning("A connection to " + cVar.getRoute().a().m() + " was leaked. Did you forget to close a response body?");
                list.remove(i);
                cVar.m = true;
                if (list.isEmpty()) {
                    cVar.n = j - this.f25514d;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
