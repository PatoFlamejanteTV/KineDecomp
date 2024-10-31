package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
class w implements com.bumptech.glide.load.c {

    /* renamed from: a */
    private final Object f8969a;

    /* renamed from: b */
    private final int f8970b;

    /* renamed from: c */
    private final int f8971c;

    /* renamed from: d */
    private final Class<?> f8972d;

    /* renamed from: e */
    private final Class<?> f8973e;

    /* renamed from: f */
    private final com.bumptech.glide.load.c f8974f;

    /* renamed from: g */
    private final Map<Class<?>, com.bumptech.glide.load.j<?>> f8975g;

    /* renamed from: h */
    private final com.bumptech.glide.load.g f8976h;
    private int i;

    public w(Object obj, com.bumptech.glide.load.c cVar, int i, int i2, Map<Class<?>, com.bumptech.glide.load.j<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.g gVar) {
        com.bumptech.glide.g.l.a(obj);
        this.f8969a = obj;
        com.bumptech.glide.g.l.a(cVar, "Signature must not be null");
        this.f8974f = cVar;
        this.f8970b = i;
        this.f8971c = i2;
        com.bumptech.glide.g.l.a(map);
        this.f8975g = map;
        com.bumptech.glide.g.l.a(cls, "Resource class must not be null");
        this.f8972d = cls;
        com.bumptech.glide.g.l.a(cls2, "Transcode class must not be null");
        this.f8973e = cls2;
        com.bumptech.glide.g.l.a(gVar);
        this.f8976h = gVar;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f8969a.equals(wVar.f8969a) && this.f8974f.equals(wVar.f8974f) && this.f8971c == wVar.f8971c && this.f8970b == wVar.f8970b && this.f8975g.equals(wVar.f8975g) && this.f8972d.equals(wVar.f8972d) && this.f8973e.equals(wVar.f8973e) && this.f8976h.equals(wVar.f8976h);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.i == 0) {
            this.i = this.f8969a.hashCode();
            this.i = (this.i * 31) + this.f8974f.hashCode();
            this.i = (this.i * 31) + this.f8970b;
            this.i = (this.i * 31) + this.f8971c;
            this.i = (this.i * 31) + this.f8975g.hashCode();
            this.i = (this.i * 31) + this.f8972d.hashCode();
            this.i = (this.i * 31) + this.f8973e.hashCode();
            this.i = (this.i * 31) + this.f8976h.hashCode();
        }
        return this.i;
    }

    public String toString() {
        return "EngineKey{model=" + this.f8969a + ", width=" + this.f8970b + ", height=" + this.f8971c + ", resourceClass=" + this.f8972d + ", transcodeClass=" + this.f8973e + ", signature=" + this.f8974f + ", hashCode=" + this.i + ", transformations=" + this.f8975g + ", options=" + this.f8976h + '}';
    }
}
