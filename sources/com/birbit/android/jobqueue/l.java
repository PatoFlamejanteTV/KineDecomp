package com.birbit.android.jobqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerManager.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    private final int f8179c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8180d;

    /* renamed from: e, reason: collision with root package name */
    private final long f8181e;

    /* renamed from: f, reason: collision with root package name */
    private final int f8182f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8183g;
    private final u i;
    private final com.birbit.android.jobqueue.i.b j;
    private final com.birbit.android.jobqueue.messaging.c k;
    final z m;
    private final ThreadFactory n;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f8177a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f8178b = new ArrayList();
    private final CopyOnWriteArrayList<Runnable> o = new CopyOnWriteArrayList<>();
    private final Map<String, p> l = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final ThreadGroup f8184h = new ThreadGroup("JobConsumers");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConsumerManager.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        static final com.birbit.android.jobqueue.messaging.d f8185a = new j();

        /* renamed from: b, reason: collision with root package name */
        final com.birbit.android.jobqueue.messaging.h f8186b;

        /* renamed from: c, reason: collision with root package name */
        final com.birbit.android.jobqueue.messaging.e f8187c;

        /* renamed from: d, reason: collision with root package name */
        final com.birbit.android.jobqueue.messaging.c f8188d;

        /* renamed from: e, reason: collision with root package name */
        final com.birbit.android.jobqueue.i.b f8189e;

        /* renamed from: f, reason: collision with root package name */
        boolean f8190f;

        /* renamed from: g, reason: collision with root package name */
        long f8191g;

        /* renamed from: h, reason: collision with root package name */
        final com.birbit.android.jobqueue.messaging.f f8192h = new k(this);

        public a(com.birbit.android.jobqueue.messaging.e eVar, com.birbit.android.jobqueue.messaging.h hVar, com.birbit.android.jobqueue.messaging.c cVar, com.birbit.android.jobqueue.i.b bVar) {
            this.f8186b = hVar;
            this.f8188d = cVar;
            this.f8187c = eVar;
            this.f8189e = bVar;
            this.f8191g = bVar.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f8186b.b(f8185a);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8186b.a(this.f8192h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.birbit.android.jobqueue.messaging.a.e eVar) {
            int d2 = eVar.d();
            if (d2 == 1) {
                this.f8186b.c();
            } else {
                if (d2 != 2) {
                    return;
                }
                com.birbit.android.jobqueue.f.c.a("Consumer has been poked.", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.birbit.android.jobqueue.messaging.a.i iVar) {
            com.birbit.android.jobqueue.f.c.a("running job %s", iVar.c().getClass().getSimpleName());
            p c2 = iVar.c();
            int a2 = c2.a(c2.k(), this.f8189e);
            com.birbit.android.jobqueue.messaging.a.j jVar = (com.birbit.android.jobqueue.messaging.a.j) this.f8188d.a(com.birbit.android.jobqueue.messaging.a.j.class);
            jVar.a(c2);
            jVar.a(a2);
            jVar.a(this);
            this.f8187c.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(u uVar, com.birbit.android.jobqueue.i.b bVar, com.birbit.android.jobqueue.messaging.c cVar, com.birbit.android.jobqueue.c.b bVar2) {
        this.i = uVar;
        this.j = bVar;
        this.k = cVar;
        this.f8183g = bVar2.g();
        this.f8180d = bVar2.i();
        this.f8179c = bVar2.h();
        this.f8181e = bVar2.c() * 1000 * 1000000;
        this.f8182f = bVar2.n();
        this.n = bVar2.m();
        this.m = new z(bVar);
    }

    private boolean a(boolean z) {
        com.birbit.android.jobqueue.f.c.a("considering adding a new consumer. Should poke all waiting? %s isRunning? %s waiting workers? %d", Boolean.valueOf(z), Boolean.valueOf(this.i.e()), Integer.valueOf(this.f8177a.size()));
        if (!this.i.e()) {
            com.birbit.android.jobqueue.f.c.a("jobqueue is not running, no consumers will be added", new Object[0]);
            return false;
        }
        if (this.f8177a.size() > 0) {
            com.birbit.android.jobqueue.f.c.a("there are waiting workers, will poke them instead", new Object[0]);
            for (int size = this.f8177a.size() - 1; size >= 0; size--) {
                a remove = this.f8177a.remove(size);
                com.birbit.android.jobqueue.messaging.a.e eVar = (com.birbit.android.jobqueue.messaging.a.e) this.k.a(com.birbit.android.jobqueue.messaging.a.e.class);
                eVar.a(2);
                remove.f8186b.a(eVar);
                if (!z) {
                    break;
                }
            }
            com.birbit.android.jobqueue.f.c.a("there were waiting workers, poked them and I'm done", new Object[0]);
            return true;
        }
        boolean g2 = g();
        com.birbit.android.jobqueue.f.c.a("nothing has been poked. are we above load factor? %s", Boolean.valueOf(g2));
        if (!g2) {
            return false;
        }
        f();
        return true;
    }

    private void f() {
        Thread thread;
        com.birbit.android.jobqueue.f.c.a("adding another consumer", new Object[0]);
        a aVar = new a(this.i.q, new com.birbit.android.jobqueue.messaging.h(this.j, this.k, "consumer"), this.k, this.j);
        ThreadFactory threadFactory = this.n;
        if (threadFactory != null) {
            thread = threadFactory.newThread(aVar);
        } else {
            thread = new Thread(this.f8184h, aVar, "job-queue-worker-" + UUID.randomUUID());
            thread.setPriority(this.f8182f);
        }
        this.f8178b.add(aVar);
        thread.start();
    }

    private boolean g() {
        int size = this.f8178b.size();
        if (size >= this.f8179c) {
            com.birbit.android.jobqueue.f.c.a("too many consumers, clearly above load factor %s", Integer.valueOf(size));
            return false;
        }
        int d2 = this.i.d();
        int size2 = this.l.size();
        int i = d2 + size2;
        boolean z = this.f8183g * size < i || (size < this.f8180d && size < i);
        com.birbit.android.jobqueue.f.c.a("check above load factor: totalCons:%s minCons:%s maxConsCount: %s, loadFactor %s remainingJobs: %s running holders: %s. isAbove:%s", Integer.valueOf(size), Integer.valueOf(this.f8180d), Integer.valueOf(this.f8179c), Integer.valueOf(this.f8183g), Integer.valueOf(d2), Integer.valueOf(size2), Boolean.valueOf(z));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> b(TagConstraint tagConstraint, String[] strArr) {
        return a(tagConstraint, strArr, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Iterator<a> it = this.f8178b.iterator();
        while (it.hasNext()) {
            com.birbit.android.jobqueue.messaging.h hVar = it.next().f8186b;
            com.birbit.android.jobqueue.messaging.a.e eVar = (com.birbit.android.jobqueue.messaging.a.e) this.k.a(com.birbit.android.jobqueue.messaging.a.e.class);
            eVar.a(2);
            hVar.a(eVar);
        }
        if (this.f8178b.isEmpty()) {
            Iterator<Runnable> it2 = this.o.iterator();
            while (it2.hasNext()) {
                it2.next().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        a(false);
    }

    public int b() {
        return this.f8178b.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.birbit.android.jobqueue.messaging.a.g gVar) {
        CopyOnWriteArrayList<Runnable> copyOnWriteArrayList;
        a aVar = (a) gVar.d();
        if (aVar.f8190f) {
            return true;
        }
        boolean e2 = this.i.e();
        p a2 = e2 ? this.i.a(this.m.b()) : null;
        if (a2 != null) {
            aVar.f8190f = true;
            this.m.a(a2.d());
            com.birbit.android.jobqueue.messaging.a.i iVar = (com.birbit.android.jobqueue.messaging.a.i) this.k.a(com.birbit.android.jobqueue.messaging.a.i.class);
            iVar.a(a2);
            this.l.put(a2.g().getId(), a2);
            if (a2.d() != null) {
                this.m.a(a2.d());
            }
            aVar.f8186b.a(iVar);
            return true;
        }
        long c2 = gVar.c() + this.f8181e;
        com.birbit.android.jobqueue.f.c.a("keep alive: %s", Long.valueOf(c2));
        boolean z = this.f8178b.size() > this.f8180d;
        boolean z2 = !e2 || (z && c2 < this.j.b());
        com.birbit.android.jobqueue.f.c.a("Consumer idle, will kill? %s . isRunning: %s", Boolean.valueOf(z2), Boolean.valueOf(e2));
        if (z2) {
            com.birbit.android.jobqueue.messaging.a.e eVar = (com.birbit.android.jobqueue.messaging.a.e) this.k.a(com.birbit.android.jobqueue.messaging.a.e.class);
            eVar.a(1);
            aVar.f8186b.a(eVar);
            this.f8177a.remove(aVar);
            this.f8178b.remove(aVar);
            com.birbit.android.jobqueue.f.c.a("killed consumers. remaining consumers %d", Integer.valueOf(this.f8178b.size()));
            if (this.f8178b.isEmpty() && (copyOnWriteArrayList = this.o) != null) {
                Iterator<Runnable> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        } else {
            if (!this.f8177a.contains(aVar)) {
                this.f8177a.add(aVar);
            }
            if (z || !this.i.b()) {
                com.birbit.android.jobqueue.messaging.a.e eVar2 = (com.birbit.android.jobqueue.messaging.a.e) this.k.a(com.birbit.android.jobqueue.messaging.a.e.class);
                eVar2.a(2);
                long b2 = !z ? this.j.b() + this.f8181e : c2;
                aVar.f8186b.a(eVar2, b2);
                com.birbit.android.jobqueue.f.c.a("poke consumer manager at %s", Long.valueOf(b2));
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> a(TagConstraint tagConstraint, String[] strArr) {
        return a(tagConstraint, strArr, false);
    }

    private Set<String> a(TagConstraint tagConstraint, String[] strArr, boolean z) {
        HashSet hashSet = new HashSet();
        for (p pVar : this.l.values()) {
            com.birbit.android.jobqueue.f.c.a("checking job tag %s. tags of job: %s", pVar.g(), pVar.g().getTags());
            if (pVar.q() && !pVar.r() && tagConstraint.matches(strArr, pVar.m())) {
                hashSet.add(pVar.e());
                if (z) {
                    pVar.u();
                } else {
                    pVar.t();
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.birbit.android.jobqueue.messaging.a.j jVar, p pVar, y yVar) {
        a aVar = (a) jVar.e();
        if (aVar.f8190f) {
            aVar.f8190f = false;
            this.l.remove(pVar.g().getId());
            if (pVar.d() != null) {
                this.m.b(pVar.d());
                if (yVar == null || !yVar.d() || yVar.a().longValue() <= 0) {
                    return;
                }
                this.m.a(pVar.d(), this.j.b() + (yVar.a().longValue() * 1000000));
                return;
            }
            return;
        }
        throw new IllegalStateException("this worker should not have a job");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return this.l.get(str) != null;
    }

    public boolean a(com.birbit.android.jobqueue.h.b bVar) {
        for (p pVar : this.l.values()) {
            if (pVar.g().isPersistent() && bVar.b() >= pVar.j) {
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        return this.f8177a.size() == this.f8178b.size();
    }
}
