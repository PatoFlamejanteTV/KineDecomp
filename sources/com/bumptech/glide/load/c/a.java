package com.bumptech.glide.load.c;

import com.bumptech.glide.g.l;
import com.bumptech.glide.load.engine.E;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class a<T> implements E<T> {

    /* renamed from: a */
    protected final T f8678a;

    public a(T t) {
        l.a(t);
        this.f8678a = t;
    }

    @Override // com.bumptech.glide.load.engine.E
    public final int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<T> c() {
        return (Class<T>) this.f8678a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.E
    public final T get() {
        return this.f8678a;
    }
}
