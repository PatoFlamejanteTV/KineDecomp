package com.bumptech.glide.load.c.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.g.l;
import com.bumptech.glide.load.engine.E;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.j<c> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.j<Bitmap> f8704a;

    public f(com.bumptech.glide.load.j<Bitmap> jVar) {
        l.a(jVar);
        this.f8704a = jVar;
    }

    @Override // com.bumptech.glide.load.j
    public E<c> a(Context context, E<c> e2, int i, int i2) {
        c cVar = e2.get();
        E<Bitmap> dVar = new com.bumptech.glide.load.resource.bitmap.d(cVar.c(), com.bumptech.glide.c.a(context).c());
        E<Bitmap> a2 = this.f8704a.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.b();
        }
        cVar.a(this.f8704a, a2.get());
        return e2;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f8704a.equals(((f) obj).f8704a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f8704a.hashCode();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        this.f8704a.a(messageDigest);
    }
}
