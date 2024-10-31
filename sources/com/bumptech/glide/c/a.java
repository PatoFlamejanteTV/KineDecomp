package com.bumptech.glide.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements i {

    /* renamed from: a */
    private final Set<j> f8416a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f8417b;

    /* renamed from: c */
    private boolean f8418c;

    @Override // com.bumptech.glide.c.i
    public void a(j jVar) {
        this.f8416a.remove(jVar);
    }

    @Override // com.bumptech.glide.c.i
    public void b(j jVar) {
        this.f8416a.add(jVar);
        if (this.f8418c) {
            jVar.onDestroy();
        } else if (this.f8417b) {
            jVar.onStart();
        } else {
            jVar.onStop();
        }
    }

    public void c() {
        this.f8417b = false;
        Iterator it = com.bumptech.glide.g.n.a(this.f8416a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStop();
        }
    }

    public void a() {
        this.f8418c = true;
        Iterator it = com.bumptech.glide.g.n.a(this.f8416a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onDestroy();
        }
    }

    public void b() {
        this.f8417b = true;
        Iterator it = com.bumptech.glide.g.n.a(this.f8416a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStart();
        }
    }
}
