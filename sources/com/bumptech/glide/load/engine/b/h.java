package com.bumptech.glide.load.engine.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.engine.b.i;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class h extends com.bumptech.glide.g.i<com.bumptech.glide.load.c, E<?>> implements i {

    /* renamed from: e */
    private i.a f8849e;

    public h(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.b.i
    public /* bridge */ /* synthetic */ E a(com.bumptech.glide.load.c cVar, E e2) {
        return (E) super.b((h) cVar, (com.bumptech.glide.load.c) e2);
    }

    @Override // com.bumptech.glide.g.i
    /* renamed from: b */
    public void a(com.bumptech.glide.load.c cVar, E<?> e2) {
        i.a aVar = this.f8849e;
        if (aVar == null || e2 == null) {
            return;
        }
        aVar.a(e2);
    }

    @Override // com.bumptech.glide.load.engine.b.i
    public /* bridge */ /* synthetic */ E a(com.bumptech.glide.load.c cVar) {
        return (E) super.c(cVar);
    }

    @Override // com.bumptech.glide.load.engine.b.i
    public void a(i.a aVar) {
        this.f8849e = aVar;
    }

    @Override // com.bumptech.glide.g.i
    /* renamed from: a */
    public int b(E<?> e2) {
        if (e2 == null) {
            return super.b(null);
        }
        return e2.a();
    }

    @Override // com.bumptech.glide.load.engine.b.i
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }
}
