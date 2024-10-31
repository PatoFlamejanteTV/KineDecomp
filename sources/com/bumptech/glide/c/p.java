package com.bumptech.glide.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    private final Set<com.bumptech.glide.request.c> f8440a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<com.bumptech.glide.request.c> f8441b = new ArrayList();

    /* renamed from: c */
    private boolean f8442c;

    public boolean a(com.bumptech.glide.request.c cVar) {
        return a(cVar, true);
    }

    public void b(com.bumptech.glide.request.c cVar) {
        this.f8440a.add(cVar);
        if (!this.f8442c) {
            cVar.a();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f8441b.add(cVar);
    }

    public void c() {
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.g.n.a(this.f8440a)) {
            if (!cVar.isComplete() && !cVar.f()) {
                cVar.clear();
                if (!this.f8442c) {
                    cVar.a();
                } else {
                    this.f8441b.add(cVar);
                }
            }
        }
    }

    public void d() {
        this.f8442c = false;
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.g.n.a(this.f8440a)) {
            if (!cVar.isComplete() && !cVar.isRunning()) {
                cVar.a();
            }
        }
        this.f8441b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f8440a.size() + ", isPaused=" + this.f8442c + "}";
    }

    private boolean a(com.bumptech.glide.request.c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f8440a.remove(cVar);
        if (!this.f8441b.remove(cVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            cVar.clear();
            if (z) {
                cVar.b();
            }
        }
        return z2;
    }

    public void a() {
        Iterator it = com.bumptech.glide.g.n.a(this.f8440a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.request.c) it.next(), false);
        }
        this.f8441b.clear();
    }

    public void b() {
        this.f8442c = true;
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.g.n.a(this.f8440a)) {
            if (cVar.isRunning()) {
                cVar.clear();
                this.f8441b.add(cVar);
            }
        }
    }
}
