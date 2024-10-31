package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheKey.java */
/* renamed from: com.bumptech.glide.load.engine.f */
/* loaded from: classes.dex */
public final class C0716f implements com.bumptech.glide.load.c {

    /* renamed from: a */
    private final com.bumptech.glide.load.c f8904a;

    /* renamed from: b */
    private final com.bumptech.glide.load.c f8905b;

    public C0716f(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.f8904a = cVar;
        this.f8905b = cVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        this.f8904a.a(messageDigest);
        this.f8905b.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof C0716f)) {
            return false;
        }
        C0716f c0716f = (C0716f) obj;
        return this.f8904a.equals(c0716f.f8904a) && this.f8905b.equals(c0716f.f8905b);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f8904a.hashCode() * 31) + this.f8905b.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f8904a + ", signature=" + this.f8905b + '}';
    }
}
