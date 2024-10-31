package com.bumptech.glide.load;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class g implements c {

    /* renamed from: a */
    private final ArrayMap<f<?>, Object> f8989a = new com.bumptech.glide.g.b();

    public void a(g gVar) {
        this.f8989a.putAll((SimpleArrayMap<? extends f<?>, ? extends Object>) gVar.f8989a);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f8989a.equals(((g) obj).f8989a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f8989a.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f8989a + '}';
    }

    public <T> g a(f<T> fVar, T t) {
        this.f8989a.put(fVar, t);
        return this;
    }

    public <T> T a(f<T> fVar) {
        return this.f8989a.containsKey(fVar) ? (T) this.f8989a.get(fVar) : fVar.a();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        for (int i = 0; i < this.f8989a.size(); i++) {
            a(this.f8989a.keyAt(i), this.f8989a.valueAt(i), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(f<T> fVar, Object obj, MessageDigest messageDigest) {
        fVar.a((f<T>) obj, messageDigest);
    }
}
