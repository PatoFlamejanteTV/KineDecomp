package com.birbit.android.jobqueue;

import android.content.Context;
import com.birbit.android.jobqueue.g.a;
import com.birbit.android.jobqueue.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobManagerThread.java */
/* loaded from: classes.dex */
public class u implements Runnable, a.InterfaceC0042a {

    /* renamed from: a, reason: collision with root package name */
    final com.birbit.android.jobqueue.i.b f8311a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f8312b;

    /* renamed from: c, reason: collision with root package name */
    private final long f8313c;

    /* renamed from: d, reason: collision with root package name */
    final v f8314d;

    /* renamed from: e, reason: collision with root package name */
    final v f8315e;

    /* renamed from: f, reason: collision with root package name */
    private final com.birbit.android.jobqueue.g.b f8316f;

    /* renamed from: g, reason: collision with root package name */
    private final com.birbit.android.jobqueue.d.a f8317g;

    /* renamed from: h, reason: collision with root package name */
    private final com.birbit.android.jobqueue.messaging.c f8318h;
    final l i;
    private List<f> j;
    private List<com.birbit.android.jobqueue.h.b> k;
    final e m;
    final com.birbit.android.jobqueue.messaging.g q;
    com.birbit.android.jobqueue.h.a r;
    final h l = new h();
    private boolean n = true;
    private boolean o = false;
    private boolean p = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.birbit.android.jobqueue.c.b bVar, com.birbit.android.jobqueue.messaging.g gVar, com.birbit.android.jobqueue.messaging.c cVar) {
        this.q = gVar;
        if (bVar.d() != null) {
            com.birbit.android.jobqueue.f.c.a(bVar.d());
        }
        this.f8318h = cVar;
        this.f8311a = bVar.o();
        this.f8312b = bVar.b();
        this.f8313c = this.f8311a.b();
        this.r = bVar.l();
        if (this.r != null && bVar.a()) {
            com.birbit.android.jobqueue.h.a aVar = this.r;
            if (!(aVar instanceof b)) {
                this.r = new b(aVar, this.f8311a);
            }
        }
        this.f8314d = bVar.k().b(bVar, this.f8313c);
        this.f8315e = bVar.k().a(bVar, this.f8313c);
        this.f8316f = bVar.j();
        this.f8317g = bVar.e();
        com.birbit.android.jobqueue.g.b bVar2 = this.f8316f;
        if (bVar2 instanceof com.birbit.android.jobqueue.g.a) {
            ((com.birbit.android.jobqueue.g.a) bVar2).a(this);
        }
        this.i = new l(this, this.f8311a, cVar, bVar);
        this.m = new e(cVar, this.f8311a);
    }

    private void f() {
        this.f8315e.clear();
        this.f8314d.clear();
    }

    private int g() {
        com.birbit.android.jobqueue.g.b bVar = this.f8316f;
        if (bVar == null) {
            return 2;
        }
        return bVar.a(this.f8312b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<com.birbit.android.jobqueue.h.b> list;
        if (this.r == null || (list = this.k) == null || list.isEmpty() || !this.i.a()) {
            return;
        }
        for (int size = this.k.size() - 1; size >= 0; size--) {
            com.birbit.android.jobqueue.h.b remove = this.k.remove(size);
            this.r.a(remove, c(remove));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.q.a(new s(this));
    }

    private boolean c(com.birbit.android.jobqueue.h.b bVar) {
        if (this.i.a(bVar)) {
            return true;
        }
        this.l.a();
        this.l.a(this.f8311a.b());
        this.l.a(bVar.b());
        return this.f8314d.c(this.l) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return b(g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f8316f instanceof com.birbit.android.jobqueue.g.a;
    }

    private void b(com.birbit.android.jobqueue.h.b bVar) {
        List<com.birbit.android.jobqueue.h.b> list = this.k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size).d().equals(bVar.d())) {
                    list.remove(size);
                }
            }
        }
        if (this.r != null && c(bVar)) {
            this.r.a(bVar);
        }
    }

    int c() {
        return this.f8314d.count() + this.f8315e.count();
    }

    private void c(p pVar) {
        if (pVar.g().isPersistent()) {
            this.f8314d.b(pVar);
        } else {
            this.f8315e.b(pVar);
        }
        this.m.b(pVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.a aVar) {
        Job c2 = aVar.c();
        long b2 = this.f8311a.b();
        long delayInMs = c2.getDelayInMs() > 0 ? (c2.getDelayInMs() * 1000000) + b2 : Long.MIN_VALUE;
        long deadlineInMs = c2.getDeadlineInMs() > 0 ? (c2.getDeadlineInMs() * 1000000) + b2 : Long.MAX_VALUE;
        p.a aVar2 = new p.a();
        aVar2.a(c2.getPriority());
        aVar2.a(c2);
        aVar2.a(c2.getRunGroupId());
        aVar2.a(b2);
        aVar2.b(delayInMs);
        aVar2.b(c2.getId());
        aVar2.a(c2.getTags());
        aVar2.a(c2.isPersistent());
        aVar2.c(0);
        aVar2.a(deadlineInMs, c2.shouldCancelOnDeadline());
        aVar2.b(c2.requiredNetworkType);
        aVar2.d(Long.MIN_VALUE);
        p a2 = aVar2.a();
        p a3 = a(c2.getSingleInstanceId());
        boolean z = a3 == null || this.i.a(a3.e());
        if (z) {
            v vVar = c2.isPersistent() ? this.f8314d : this.f8315e;
            if (a3 != null) {
                this.i.b(TagConstraint.ANY, new String[]{c2.getSingleInstanceId()});
                vVar.a(a2, a3);
            } else {
                vVar.a(a2);
            }
            if (com.birbit.android.jobqueue.f.c.b()) {
                com.birbit.android.jobqueue.f.c.a("added job class: %s priority: %d delay: %d group : %s persistent: %s", c2.getClass().getSimpleName(), Integer.valueOf(c2.getPriority()), Long.valueOf(c2.getDelayInMs()), c2.getRunGroupId(), Boolean.valueOf(c2.isPersistent()));
            }
        } else {
            com.birbit.android.jobqueue.f.c.a("another job with same singleId: %s was already queued", c2.getSingleInstanceId());
        }
        com.birbit.android.jobqueue.d.a aVar3 = this.f8317g;
        if (aVar3 != null) {
            aVar3.a(c2);
        }
        a2.a(this.f8312b);
        a2.g().onAdded();
        this.m.a(a2.g());
        if (z) {
            this.i.e();
            if (c2.isPersistent()) {
                a(a2, b2);
                return;
            }
            return;
        }
        a(a2, 1);
        this.m.b(a2.g());
    }

    private JobStatus b(String str) {
        if (this.i.a(str)) {
            return JobStatus.RUNNING;
        }
        p a2 = this.f8315e.a(str);
        if (a2 == null) {
            a2 = this.f8314d.a(str);
        }
        if (a2 == null) {
            return JobStatus.UNKNOWN;
        }
        int g2 = g();
        long b2 = this.f8311a.b();
        if (g2 < a2.j) {
            return JobStatus.WAITING_NOT_READY;
        }
        if (a2.c() > b2) {
            return JobStatus.WAITING_NOT_READY;
        }
        return JobStatus.WAITING_READY;
    }

    private void b(p pVar) {
        if (!pVar.r()) {
            if (pVar.g().isPersistent()) {
                this.f8314d.d(pVar);
                return;
            } else {
                this.f8315e.d(pVar);
                return;
            }
        }
        com.birbit.android.jobqueue.f.c.a("not re-adding cancelled job " + pVar, new Object[0]);
    }

    private int b(int i) {
        Collection<String> b2 = this.i.m.b();
        this.l.a();
        this.l.a(this.f8311a.b());
        this.l.a(i);
        this.l.a(b2);
        this.l.a(true);
        this.l.a(Long.valueOf(this.f8311a.b()));
        return this.f8315e.c(this.l) + 0 + this.f8314d.c(this.l);
    }

    private void a(p pVar, long j) {
        if (this.r == null) {
            return;
        }
        int i = pVar.j;
        long c2 = pVar.c();
        long b2 = pVar.b();
        long millis = c2 > j ? TimeUnit.NANOSECONDS.toMillis(c2 - j) : 0L;
        Long valueOf = b2 != Long.MAX_VALUE ? Long.valueOf(TimeUnit.NANOSECONDS.toMillis(b2 - j)) : null;
        boolean z = false;
        boolean z2 = c2 > j && millis >= com.umeng.commonsdk.proguard.c.f26227d;
        if (valueOf != null && valueOf.longValue() >= com.umeng.commonsdk.proguard.c.f26227d) {
            z = true;
        }
        if (i != 0 || z2 || z) {
            com.birbit.android.jobqueue.h.b bVar = new com.birbit.android.jobqueue.h.b(UUID.randomUUID().toString());
            bVar.a(i);
            bVar.a(millis);
            bVar.a(valueOf);
            this.r.a(bVar);
            this.o = true;
        }
    }

    private p a(String str) {
        if (str == null) {
            return null;
        }
        this.l.a();
        this.l.a(new String[]{str});
        this.l.a(TagConstraint.ANY);
        this.l.a(2);
        Set<p> a2 = this.f8315e.a(this.l);
        a2.addAll(this.f8314d.a(this.l));
        if (a2.isEmpty()) {
            return null;
        }
        for (p pVar : a2) {
            if (!this.i.a(pVar.e())) {
                return pVar;
            }
        }
        return a2.iterator().next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.k kVar) {
        int d2 = kVar.d();
        if (d2 == 1) {
            a(kVar.c());
        } else {
            if (d2 == 2) {
                b(kVar.c());
                return;
            }
            throw new IllegalArgumentException("Unknown scheduler message with what " + d2);
        }
    }

    private void a(com.birbit.android.jobqueue.h.b bVar) {
        if (!e()) {
            com.birbit.android.jobqueue.h.a aVar = this.r;
            if (aVar != null) {
                aVar.a(bVar, true);
                return;
            }
            return;
        }
        if (!c(bVar)) {
            com.birbit.android.jobqueue.h.a aVar2 = this.r;
            if (aVar2 != null) {
                aVar2.a(bVar, false);
                return;
            }
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(bVar);
        this.i.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.e eVar) {
        if (eVar.d() == 1) {
            this.q.b();
            this.q.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.h hVar) {
        int e2 = hVar.e();
        if (e2 != 101) {
            switch (e2) {
                case 0:
                    hVar.c().a(c());
                    return;
                case 1:
                    hVar.c().a(b(g()));
                    return;
                case 2:
                    com.birbit.android.jobqueue.f.c.a("handling start request...", new Object[0]);
                    if (this.n) {
                        return;
                    }
                    this.n = true;
                    this.i.c();
                    return;
                case 3:
                    com.birbit.android.jobqueue.f.c.a("handling stop request...", new Object[0]);
                    this.n = false;
                    this.i.d();
                    return;
                case 4:
                    hVar.c().a(b(hVar.d()).ordinal());
                    return;
                case 5:
                    f();
                    if (hVar.c() != null) {
                        hVar.c().a(0);
                        return;
                    }
                    return;
                case 6:
                    hVar.c().a(this.i.b());
                    return;
                default:
                    throw new IllegalArgumentException("cannot handle public query with type " + hVar.e());
            }
        }
        hVar.c().a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.birbit.android.jobqueue.messaging.a.c cVar) {
        f fVar = new f(cVar.d(), cVar.e(), cVar.c());
        fVar.a(this, this.i);
        if (fVar.a()) {
            fVar.a(this);
            return;
        }
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.birbit.android.jobqueue.messaging.a.j r6) {
        /*
            r5 = this;
            int r0 = r6.d()
            com.birbit.android.jobqueue.p r1 = r6.c()
            com.birbit.android.jobqueue.e r2 = r5.m
            com.birbit.android.jobqueue.Job r3 = r1.g()
            r2.b(r3, r0)
            r2 = 0
            switch(r0) {
                case 1: goto L4d;
                case 2: goto L45;
                case 3: goto L3d;
                case 4: goto L35;
                case 5: goto L2d;
                case 6: goto L25;
                case 7: goto L1d;
                default: goto L15;
            }
        L15:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "unknown job holder result"
            r6.<init>(r0)
            throw r6
        L1d:
            r3 = 7
            r5.a(r1, r3)
            r5.c(r1)
            goto L50
        L25:
            r3 = 6
            r5.a(r1, r3)
            r5.c(r1)
            goto L50
        L2d:
            r3 = 5
            r5.a(r1, r3)
            r5.c(r1)
            goto L50
        L35:
            com.birbit.android.jobqueue.y r3 = r1.j()
            r5.a(r1)
            goto L51
        L3d:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "running job failed and cancelled, doing nothing. Will be removed after it's onCancel is called by the CancelHandler"
            com.birbit.android.jobqueue.f.c.a(r4, r3)
            goto L50
        L45:
            r3 = 2
            r5.a(r1, r3)
            r5.c(r1)
            goto L50
        L4d:
            r5.c(r1)
        L50:
            r3 = 0
        L51:
            com.birbit.android.jobqueue.l r4 = r5.i
            r4.a(r6, r1, r3)
            com.birbit.android.jobqueue.e r6 = r5.m
            com.birbit.android.jobqueue.Job r3 = r1.g()
            r6.a(r3, r0)
            java.util.List<com.birbit.android.jobqueue.f> r6 = r5.j
            if (r6 == 0) goto L89
            int r6 = r6.size()
        L67:
            if (r2 >= r6) goto L89
            java.util.List<com.birbit.android.jobqueue.f> r3 = r5.j
            java.lang.Object r3 = r3.get(r2)
            com.birbit.android.jobqueue.f r3 = (com.birbit.android.jobqueue.f) r3
            r3.a(r1, r0)
            boolean r4 = r3.a()
            if (r4 == 0) goto L86
            r3.a(r5)
            java.util.List<com.birbit.android.jobqueue.f> r3 = r5.j
            r3.remove(r2)
            int r2 = r2 + (-1)
            int r6 = r6 + (-1)
        L86:
            int r2 = r2 + 1
            goto L67
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.u.a(com.birbit.android.jobqueue.messaging.a.j):void");
    }

    private void a(p pVar, int i) {
        try {
            pVar.a(i);
        } catch (Throwable th) {
            com.birbit.android.jobqueue.f.c.a(th, "job's onCancel did throw an exception, ignoring...", new Object[0]);
        }
        this.m.a(pVar.g(), false, pVar.n());
    }

    private void a(p pVar) {
        y j = pVar.j();
        if (j == null) {
            b(pVar);
            return;
        }
        if (j.b() != null) {
            pVar.b(j.b().intValue());
        }
        long longValue = j.a() != null ? j.a().longValue() : -1L;
        pVar.a(longValue > 0 ? this.f8311a.b() + (longValue * 1000000) : Long.MIN_VALUE);
        b(pVar);
    }

    @Override // com.birbit.android.jobqueue.g.a.InterfaceC0042a
    public void a(int i) {
        this.q.a((com.birbit.android.jobqueue.messaging.a.f) this.f8318h.a(com.birbit.android.jobqueue.messaging.a.f.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Long a(boolean z) {
        Long a2 = this.i.m.a();
        int g2 = g();
        Collection<String> b2 = this.i.m.b();
        this.l.a();
        this.l.a(this.f8311a.b());
        this.l.a(g2);
        this.l.a(b2);
        this.l.a(true);
        Long b3 = this.f8315e.b(this.l);
        Long b4 = this.f8314d.b(this.l);
        if (a2 == null) {
            a2 = null;
        }
        if (b3 != null) {
            a2 = Long.valueOf(a2 == null ? b3.longValue() : Math.min(b3.longValue(), a2.longValue()));
        }
        if (b4 != null) {
            a2 = Long.valueOf(a2 == null ? b4.longValue() : Math.min(b4.longValue(), a2.longValue()));
        }
        if (!z || (this.f8316f instanceof com.birbit.android.jobqueue.g.a)) {
            return a2;
        }
        long b5 = this.f8311a.b() + r.f8303a;
        if (a2 != null) {
            b5 = Math.min(b5, a2.longValue());
        }
        return Long.valueOf(b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p a(Collection<String> collection) {
        return a(collection, false);
    }

    p a(Collection<String> collection, boolean z) {
        boolean z2;
        com.birbit.android.jobqueue.d.a aVar;
        if (!this.n && !z) {
            return null;
        }
        while (true) {
            p pVar = null;
            while (pVar == null) {
                int g2 = g();
                com.birbit.android.jobqueue.f.c.c("looking for next job", new Object[0]);
                this.l.a();
                long b2 = this.f8311a.b();
                this.l.a(b2);
                this.l.a(g2);
                this.l.a(collection);
                this.l.a(true);
                this.l.a(Long.valueOf(b2));
                pVar = this.f8315e.d(this.l);
                com.birbit.android.jobqueue.f.c.c("non persistent result %s", pVar);
                if (pVar == null) {
                    pVar = this.f8314d.d(this.l);
                    com.birbit.android.jobqueue.f.c.c("persistent result %s", pVar);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (pVar == null) {
                    return null;
                }
                if (z2 && (aVar = this.f8317g) != null) {
                    aVar.a(pVar.g());
                }
                pVar.a(this.f8312b);
                pVar.a(pVar.b() <= b2);
                if (pVar.b() > b2 || !pVar.v()) {
                }
            }
            return pVar;
            a(pVar, 7);
            c(pVar);
        }
    }
}
