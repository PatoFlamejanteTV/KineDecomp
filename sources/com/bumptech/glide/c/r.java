package com.bumptech.glide.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class r implements j {

    /* renamed from: a */
    private final Set<com.bumptech.glide.request.a.i<?>> f8450a = Collections.newSetFromMap(new WeakHashMap());

    public void a(com.bumptech.glide.request.a.i<?> iVar) {
        this.f8450a.add(iVar);
    }

    public void b(com.bumptech.glide.request.a.i<?> iVar) {
        this.f8450a.remove(iVar);
    }

    @Override // com.bumptech.glide.c.j
    public void onDestroy() {
        Iterator it = com.bumptech.glide.g.n.a(this.f8450a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.a.i) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.c.j
    public void onStart() {
        Iterator it = com.bumptech.glide.g.n.a(this.f8450a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.a.i) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.c.j
    public void onStop() {
        Iterator it = com.bumptech.glide.g.n.a(this.f8450a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.a.i) it.next()).onStop();
        }
    }

    public void a() {
        this.f8450a.clear();
    }

    public List<com.bumptech.glide.request.a.i<?>> b() {
        return com.bumptech.glide.g.n.a(this.f8450a);
    }
}
