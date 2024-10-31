package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CallbackManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    final com.birbit.android.jobqueue.messaging.h f8132a;

    /* renamed from: c, reason: collision with root package name */
    private final com.birbit.android.jobqueue.messaging.c f8134c;

    /* renamed from: e, reason: collision with root package name */
    private final com.birbit.android.jobqueue.i.b f8136e;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f8135d = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f8137f = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.birbit.android.jobqueue.b.a> f8133b = new CopyOnWriteArrayList<>();

    public e(com.birbit.android.jobqueue.messaging.c cVar, com.birbit.android.jobqueue.i.b bVar) {
        this.f8136e = bVar;
        this.f8132a = new com.birbit.android.jobqueue.messaging.h(bVar, cVar, "jq_callback");
        this.f8134c = cVar;
    }

    private void c() {
        if (this.f8137f.getAndSet(true)) {
            return;
        }
        b();
    }

    private void d(Job job, int i) {
        Iterator<com.birbit.android.jobqueue.b.a> it = this.f8133b.iterator();
        while (it.hasNext()) {
            it.next().a(job, i);
        }
    }

    private void b() {
        new Thread(new d(this), "job-manager-callbacks").start();
    }

    private void c(Job job, int i) {
        Iterator<com.birbit.android.jobqueue.b.a> it = this.f8133b.iterator();
        while (it.hasNext()) {
            it.next().b(job, i);
        }
    }

    private void d(Job job) {
        Iterator<com.birbit.android.jobqueue.b.a> it = this.f8133b.iterator();
        while (it.hasNext()) {
            it.next().a(job);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.d dVar) {
        dVar.c().a(dVar.d());
        c();
    }

    private void b(Job job, boolean z, Throwable th) {
        Iterator<com.birbit.android.jobqueue.b.a> it = this.f8133b.iterator();
        while (it.hasNext()) {
            it.next().a(job, z, th);
        }
    }

    private void c(Job job) {
        Iterator<com.birbit.android.jobqueue.b.a> it = this.f8133b.iterator();
        while (it.hasNext()) {
            it.next().b(job);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.b bVar) {
        int f2 = bVar.f();
        if (f2 == 1) {
            c(bVar.c());
            return;
        }
        if (f2 == 2) {
            d(bVar.c(), bVar.d());
            return;
        }
        if (f2 == 3) {
            b(bVar.c(), bVar.g(), bVar.e());
        } else if (f2 == 4) {
            d(bVar.c());
        } else {
            if (f2 != 5) {
                return;
            }
            c(bVar.c(), bVar.d());
        }
    }

    public void b(Job job, int i) {
        if (a()) {
            com.birbit.android.jobqueue.messaging.a.b bVar = (com.birbit.android.jobqueue.messaging.a.b) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.b.class);
            bVar.a(job, 2, i);
            this.f8132a.a(bVar);
        }
    }

    public void b(Job job) {
        if (a()) {
            com.birbit.android.jobqueue.messaging.a.b bVar = (com.birbit.android.jobqueue.messaging.a.b) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.b.class);
            bVar.a(job, 4);
            this.f8132a.a(bVar);
        }
    }

    private boolean a() {
        return this.f8135d.get() > 0;
    }

    public void a(Job job, int i) {
        if (a()) {
            com.birbit.android.jobqueue.messaging.a.b bVar = (com.birbit.android.jobqueue.messaging.a.b) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.b.class);
            bVar.a(job, 5, i);
            this.f8132a.a(bVar);
        }
    }

    public void a(Job job, boolean z, Throwable th) {
        if (a()) {
            com.birbit.android.jobqueue.messaging.a.b bVar = (com.birbit.android.jobqueue.messaging.a.b) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.b.class);
            bVar.a(job, 3, z, th);
            this.f8132a.a(bVar);
        }
    }

    public void a(Job job) {
        if (a()) {
            com.birbit.android.jobqueue.messaging.a.b bVar = (com.birbit.android.jobqueue.messaging.a.b) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.b.class);
            bVar.a(job, 1);
            this.f8132a.a(bVar);
        }
    }

    public void a(g gVar, g.a aVar) {
        com.birbit.android.jobqueue.messaging.a.d dVar = (com.birbit.android.jobqueue.messaging.a.d) this.f8134c.a(com.birbit.android.jobqueue.messaging.a.d.class);
        dVar.a(aVar, gVar);
        this.f8132a.a(dVar);
        c();
    }
}
