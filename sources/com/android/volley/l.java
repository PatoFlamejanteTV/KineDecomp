package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8079a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Request<?>> f8080b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f8081c;

    /* renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f8082d;

    /* renamed from: e, reason: collision with root package name */
    private final com.android.volley.a f8083e;

    /* renamed from: f, reason: collision with root package name */
    private final h f8084f;

    /* renamed from: g, reason: collision with root package name */
    private final n f8085g;

    /* renamed from: h, reason: collision with root package name */
    private final i[] f8086h;
    private c i;
    private final List<a> j;

    /* compiled from: RequestQueue.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(Request<T> request);
    }

    public l(com.android.volley.a aVar, h hVar, int i, n nVar) {
        this.f8079a = new AtomicInteger();
        this.f8080b = new HashSet();
        this.f8081c = new PriorityBlockingQueue<>();
        this.f8082d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.f8083e = aVar;
        this.f8084f = hVar;
        this.f8086h = new i[i];
        this.f8085g = nVar;
    }

    public com.android.volley.a a() {
        return this.f8083e;
    }

    public int b() {
        return this.f8079a.incrementAndGet();
    }

    public void c() {
        d();
        this.i = new c(this.f8081c, this.f8082d, this.f8083e, this.f8085g);
        this.i.start();
        for (int i = 0; i < this.f8086h.length; i++) {
            i iVar = new i(this.f8082d, this.f8084f, this.f8083e, this.f8085g);
            this.f8086h[i] = iVar;
            iVar.start();
        }
    }

    public void d() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.b();
        }
        for (i iVar : this.f8086h) {
            if (iVar != null) {
                iVar.b();
            }
        }
    }

    public <T> Request<T> a(Request<T> request) {
        request.a(this);
        synchronized (this.f8080b) {
            this.f8080b.add(request);
        }
        request.f(b());
        request.a("add-to-queue");
        if (!request.E()) {
            this.f8082d.add(request);
            return request;
        }
        this.f8081c.add(request);
        return request;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void b(Request<T> request) {
        synchronized (this.f8080b) {
            this.f8080b.remove(request);
        }
        synchronized (this.j) {
            Iterator<a> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
    }

    public l(com.android.volley.a aVar, h hVar, int i) {
        this(aVar, hVar, i, new f(new Handler(Looper.getMainLooper())));
    }
}
