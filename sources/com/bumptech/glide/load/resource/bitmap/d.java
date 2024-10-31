package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class d implements E<Bitmap>, com.bumptech.glide.load.engine.z {

    /* renamed from: a */
    private final Bitmap f9017a;

    /* renamed from: b */
    private final com.bumptech.glide.load.engine.a.e f9018b;

    public d(Bitmap bitmap, com.bumptech.glide.load.engine.a.e eVar) {
        com.bumptech.glide.g.l.a(bitmap, "Bitmap must not be null");
        this.f9017a = bitmap;
        com.bumptech.glide.g.l.a(eVar, "BitmapPool must not be null");
        this.f9018b = eVar;
    }

    public static d a(Bitmap bitmap, com.bumptech.glide.load.engine.a.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
        this.f9018b.a(this.f9017a);
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.z
    public void d() {
        this.f9017a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return com.bumptech.glide.g.n.a(this.f9017a);
    }

    @Override // com.bumptech.glide.load.engine.E
    public Bitmap get() {
        return this.f9017a;
    }
}
