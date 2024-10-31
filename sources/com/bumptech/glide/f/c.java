package com.bumptech.glide.f;

import com.bumptech.glide.g.l;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.c {

    /* renamed from: a */
    private final Object f8487a;

    public c(Object obj) {
        l.a(obj);
        this.f8487a = obj;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f8487a.toString().getBytes(com.bumptech.glide.load.c.f8677a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f8487a.equals(((c) obj).f8487a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f8487a.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f8487a + '}';
    }
}
