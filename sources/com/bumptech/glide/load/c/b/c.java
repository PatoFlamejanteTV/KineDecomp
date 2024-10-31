package com.bumptech.glide.load.c.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.E;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    public static E<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<Drawable> c() {
        return this.f8683a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return Math.max(1, this.f8683a.getIntrinsicWidth() * this.f8683a.getIntrinsicHeight() * 4);
    }
}
