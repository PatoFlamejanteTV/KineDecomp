package com.bumptech.glide.load.c.d;

import com.bumptech.glide.load.engine.z;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class e extends com.bumptech.glide.load.c.b.b<c> implements z {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return ((c) this.f8683a).f();
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
        ((c) this.f8683a).stop();
        ((c) this.f8683a).g();
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<c> c() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.c.b.b, com.bumptech.glide.load.engine.z
    public void d() {
        ((c) this.f8683a).c().prepareToDraw();
    }
}
