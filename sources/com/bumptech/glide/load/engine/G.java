package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
public final class G implements com.bumptech.glide.load.c {

    /* renamed from: a */
    private static final com.bumptech.glide.g.i<Class<?>, byte[]> f8771a = new com.bumptech.glide.g.i<>(50);

    /* renamed from: b */
    private final com.bumptech.glide.load.engine.a.b f8772b;

    /* renamed from: c */
    private final com.bumptech.glide.load.c f8773c;

    /* renamed from: d */
    private final com.bumptech.glide.load.c f8774d;

    /* renamed from: e */
    private final int f8775e;

    /* renamed from: f */
    private final int f8776f;

    /* renamed from: g */
    private final Class<?> f8777g;

    /* renamed from: h */
    private final com.bumptech.glide.load.g f8778h;
    private final com.bumptech.glide.load.j<?> i;

    public G(com.bumptech.glide.load.engine.a.b bVar, com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2, int i, int i2, com.bumptech.glide.load.j<?> jVar, Class<?> cls, com.bumptech.glide.load.g gVar) {
        this.f8772b = bVar;
        this.f8773c = cVar;
        this.f8774d = cVar2;
        this.f8775e = i;
        this.f8776f = i2;
        this.i = jVar;
        this.f8777g = cls;
        this.f8778h = gVar;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f8772b.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f8775e).putInt(this.f8776f).array();
        this.f8774d.a(messageDigest);
        this.f8773c.a(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.j<?> jVar = this.i;
        if (jVar != null) {
            jVar.a(messageDigest);
        }
        this.f8778h.a(messageDigest);
        messageDigest.update(a());
        this.f8772b.put(bArr);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof G)) {
            return false;
        }
        G g2 = (G) obj;
        return this.f8776f == g2.f8776f && this.f8775e == g2.f8775e && com.bumptech.glide.g.n.b(this.i, g2.i) && this.f8777g.equals(g2.f8777g) && this.f8773c.equals(g2.f8773c) && this.f8774d.equals(g2.f8774d) && this.f8778h.equals(g2.f8778h);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f8773c.hashCode() * 31) + this.f8774d.hashCode()) * 31) + this.f8775e) * 31) + this.f8776f;
        com.bumptech.glide.load.j<?> jVar = this.i;
        if (jVar != null) {
            hashCode = (hashCode * 31) + jVar.hashCode();
        }
        return (((hashCode * 31) + this.f8777g.hashCode()) * 31) + this.f8778h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f8773c + ", signature=" + this.f8774d + ", width=" + this.f8775e + ", height=" + this.f8776f + ", decodedResourceClass=" + this.f8777g + ", transformation='" + this.i + "', options=" + this.f8778h + '}';
    }

    private byte[] a() {
        byte[] a2 = f8771a.a((com.bumptech.glide.g.i<Class<?>, byte[]>) this.f8777g);
        if (a2 != null) {
            return a2;
        }
        byte[] bytes = this.f8777g.getName().getBytes(com.bumptech.glide.load.c.f8677a);
        f8771a.b(this.f8777g, bytes);
        return bytes;
    }
}
