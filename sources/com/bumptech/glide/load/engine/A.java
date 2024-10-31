package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class A {

    /* renamed from: a */
    private final Map<com.bumptech.glide.load.c, u<?>> f8736a = new HashMap();

    /* renamed from: b */
    private final Map<com.bumptech.glide.load.c, u<?>> f8737b = new HashMap();

    public u<?> a(com.bumptech.glide.load.c cVar, boolean z) {
        return a(z).get(cVar);
    }

    public void b(com.bumptech.glide.load.c cVar, u<?> uVar) {
        Map<com.bumptech.glide.load.c, u<?>> a2 = a(uVar.f());
        if (uVar.equals(a2.get(cVar))) {
            a2.remove(cVar);
        }
    }

    public void a(com.bumptech.glide.load.c cVar, u<?> uVar) {
        a(uVar.f()).put(cVar, uVar);
    }

    private Map<com.bumptech.glide.load.c, u<?>> a(boolean z) {
        return z ? this.f8737b : this.f8736a;
    }
}
