package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.E;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class t implements E<BitmapDrawable>, com.bumptech.glide.load.engine.z {

    /* renamed from: a */
    private final Resources f9044a;

    /* renamed from: b */
    private final E<Bitmap> f9045b;

    private t(Resources resources, E<Bitmap> e2) {
        com.bumptech.glide.g.l.a(resources);
        this.f9044a = resources;
        com.bumptech.glide.g.l.a(e2);
        this.f9045b = e2;
    }

    public static E<BitmapDrawable> a(Resources resources, E<Bitmap> e2) {
        if (e2 == null) {
            return null;
        }
        return new t(resources, e2);
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
        this.f9045b.b();
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.z
    public void d() {
        E<Bitmap> e2 = this.f9045b;
        if (e2 instanceof com.bumptech.glide.load.engine.z) {
            ((com.bumptech.glide.load.engine.z) e2).d();
        }
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return this.f9045b.a();
    }

    @Override // com.bumptech.glide.load.engine.E
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f9044a, this.f9045b.get());
    }
}
