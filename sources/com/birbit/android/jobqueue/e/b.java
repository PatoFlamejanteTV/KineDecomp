package com.birbit.android.jobqueue.e;

import com.birbit.android.jobqueue.h;
import com.birbit.android.jobqueue.p;
import com.birbit.android.jobqueue.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SimpleInMemoryPriorityQueue.java */
/* loaded from: classes.dex */
public class b implements v {

    /* renamed from: a */
    private final TreeSet<p> f8139a = new TreeSet<>(new a(this));

    /* renamed from: b */
    private final Map<String, p> f8140b = new HashMap();

    /* renamed from: c */
    private final AtomicLong f8141c = new AtomicLong(0);

    /* renamed from: d */
    private final List<String> f8142d = new ArrayList();

    /* renamed from: e */
    private final long f8143e;

    public b(com.birbit.android.jobqueue.c.b bVar, long j) {
        this.f8143e = j;
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean a(p pVar) {
        pVar.b(this.f8141c.incrementAndGet());
        if (this.f8140b.get(pVar.e()) == null) {
            this.f8140b.put(pVar.e(), pVar);
            this.f8139a.add(pVar);
            return true;
        }
        throw new IllegalArgumentException("cannot add a job with the same id twice");
    }

    @Override // com.birbit.android.jobqueue.v
    public void b(p pVar) {
        this.f8140b.remove(pVar.e());
        this.f8139a.remove(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public int c(h hVar) {
        this.f8142d.clear();
        Iterator<p> it = this.f8139a.iterator();
        int i = 0;
        while (it.hasNext()) {
            p next = it.next();
            String d2 = next.d();
            if (d2 == null || !this.f8142d.contains(d2)) {
                if (a(next, hVar, false)) {
                    i++;
                    if (d2 != null) {
                        this.f8142d.add(d2);
                    }
                }
            }
        }
        this.f8142d.clear();
        return i;
    }

    @Override // com.birbit.android.jobqueue.v
    public void clear() {
        this.f8139a.clear();
        this.f8140b.clear();
    }

    @Override // com.birbit.android.jobqueue.v
    public int count() {
        return this.f8139a.size();
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean d(p pVar) {
        if (pVar.f() == null) {
            return a(pVar);
        }
        p pVar2 = this.f8140b.get(pVar.e());
        if (pVar2 != null) {
            b(pVar2);
        }
        this.f8140b.put(pVar.e(), pVar);
        this.f8139a.add(pVar);
        return true;
    }

    @Override // com.birbit.android.jobqueue.v
    public Long b(h hVar) {
        long c2;
        Iterator<p> it = this.f8139a.iterator();
        Long l = null;
        while (it.hasNext()) {
            p next = it.next();
            if (a(next, hVar, true)) {
                boolean z = next.p() && a(next, hVar, false);
                boolean o = next.o();
                if (o == z) {
                    c2 = Math.min(next.b(), next.c());
                } else if (o) {
                    c2 = next.b();
                } else {
                    c2 = next.c();
                }
                if (l == null || c2 < l.longValue()) {
                    l = Long.valueOf(c2);
                }
            }
        }
        return l;
    }

    @Override // com.birbit.android.jobqueue.v
    public void a(p pVar, p pVar2) {
        b(pVar2);
        a(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public void c(p pVar) {
        b(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public p d(h hVar) {
        Iterator<p> it = this.f8139a.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (a(next, hVar, false)) {
                b(next);
                next.c(next.k() + 1);
                next.c(this.f8143e);
                return next;
            }
        }
        return null;
    }

    @Override // com.birbit.android.jobqueue.v
    public p a(String str) {
        return this.f8140b.get(str);
    }

    @Override // com.birbit.android.jobqueue.v
    public Set<p> a(h hVar) {
        HashSet hashSet = new HashSet();
        Iterator<p> it = this.f8139a.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (a(next, hVar, false)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    private static boolean a(p pVar, h hVar, boolean z) {
        if (!(hVar.f() >= pVar.b() || (z && pVar.o())) && hVar.e() < pVar.i()) {
            return false;
        }
        if (hVar.i() != null && pVar.c() > hVar.i().longValue()) {
            return false;
        }
        if ((pVar.d() == null || !hVar.c().contains(pVar.d())) && !hVar.d().contains(pVar.e())) {
            return hVar.g() == null || !(pVar.m() == null || hVar.h().isEmpty() || !hVar.g().matches(hVar.h(), pVar.m()));
        }
        return false;
    }
}
