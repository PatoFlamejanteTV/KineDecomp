package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.E;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class p implements com.bumptech.glide.load.j<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.j<Bitmap> f9037a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9038b;

    public p(com.bumptech.glide.load.j<Bitmap> jVar, boolean z) {
        this.f9037a = jVar;
        this.f9038b = z;
    }

    @Override // com.bumptech.glide.load.j
    public E<Drawable> a(Context context, E<Drawable> e2, int i, int i2) {
        com.bumptech.glide.load.engine.a.e c2 = com.bumptech.glide.c.a(context).c();
        Drawable drawable = e2.get();
        E<Bitmap> a2 = o.a(c2, drawable, i, i2);
        if (a2 == null) {
            if (!this.f9038b) {
                return e2;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        E<Bitmap> a3 = this.f9037a.a(context, a2, i, i2);
        if (a3.equals(a2)) {
            a3.b();
            return e2;
        }
        return a(context, a3);
    }

    public com.bumptech.glide.load.j<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f9037a.equals(((p) obj).f9037a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f9037a.hashCode();
    }

    private E<Drawable> a(Context context, E<Bitmap> e2) {
        return t.a(context.getResources(), e2);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        this.f9037a.a(messageDigest);
    }
}
