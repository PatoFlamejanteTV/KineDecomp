package com.bumptech.glide.g;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private Class<?> f8515a;

    /* renamed from: b */
    private Class<?> f8516b;

    /* renamed from: c */
    private Class<?> f8517c;

    public k() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f8515a = cls;
        this.f8516b = cls2;
        this.f8517c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f8515a.equals(kVar.f8515a) && this.f8516b.equals(kVar.f8516b) && n.b(this.f8517c, kVar.f8517c);
    }

    public int hashCode() {
        int hashCode = ((this.f8515a.hashCode() * 31) + this.f8516b.hashCode()) * 31;
        Class<?> cls = this.f8517c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f8515a + ", second=" + this.f8516b + '}';
    }

    public k(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
