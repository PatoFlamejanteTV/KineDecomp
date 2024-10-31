package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CancelHandler.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f8144a;

    /* renamed from: b, reason: collision with root package name */
    private final TagConstraint f8145b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f8146c;

    /* renamed from: d, reason: collision with root package name */
    private final Collection<p> f8147d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Collection<p> f8148e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final g.a f8149f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TagConstraint tagConstraint, String[] strArr, g.a aVar) {
        this.f8145b = tagConstraint;
        this.f8146c = strArr;
        this.f8149f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u uVar, l lVar) {
        this.f8144a = lVar.a(this.f8145b, this.f8146c);
        h hVar = uVar.l;
        hVar.a();
        hVar.a(uVar.f8311a.b());
        hVar.a(this.f8145b);
        hVar.b(this.f8144a);
        hVar.a(this.f8146c);
        hVar.a(true);
        hVar.a(2);
        Set<p> a2 = uVar.f8315e.a(hVar);
        Set<p> a3 = uVar.f8314d.a(hVar);
        for (p pVar : a2) {
            pVar.t();
            this.f8147d.add(pVar);
            uVar.f8315e.c(pVar);
        }
        for (p pVar2 : a3) {
            pVar2.t();
            this.f8147d.add(pVar2);
            uVar.f8314d.c(pVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u uVar) {
        for (p pVar : this.f8147d) {
            try {
                pVar.a(3);
            } catch (Throwable th) {
                com.birbit.android.jobqueue.f.c.a(th, "job's on cancel has thrown an exception. Ignoring...", new Object[0]);
            }
            if (pVar.g().isPersistent()) {
                uVar.f8314d.b(pVar);
            }
        }
        if (this.f8149f != null) {
            ArrayList arrayList = new ArrayList(this.f8147d.size());
            ArrayList arrayList2 = new ArrayList(this.f8148e.size());
            Iterator<p> it = this.f8147d.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().g());
            }
            Iterator<p> it2 = this.f8148e.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().g());
            }
            uVar.m.a(new g(arrayList, arrayList2), this.f8149f);
        }
        for (p pVar2 : this.f8147d) {
            uVar.m.a(pVar2.g(), true, pVar2.n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar, int i) {
        if (this.f8144a.remove(pVar.e())) {
            if (i == 3) {
                this.f8147d.add(pVar);
            } else {
                this.f8148e.add(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f8144a.isEmpty();
    }
}
