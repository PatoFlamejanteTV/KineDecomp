package com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.E;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f8727a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f8728b;

    /* renamed from: c, reason: collision with root package name */
    private final e<com.bumptech.glide.load.c.d.c, byte[]> f8729c;

    public c(com.bumptech.glide.load.engine.a.e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.load.c.d.c, byte[]> eVar3) {
        this.f8727a = eVar;
        this.f8728b = eVar2;
        this.f8729c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static E<com.bumptech.glide.load.c.d.c> a(E<Drawable> e2) {
        return e2;
    }

    @Override // com.bumptech.glide.load.c.e.e
    public E<byte[]> a(E<Drawable> e2, com.bumptech.glide.load.g gVar) {
        Drawable drawable = e2.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f8728b.a(com.bumptech.glide.load.resource.bitmap.d.a(((BitmapDrawable) drawable).getBitmap(), this.f8727a), gVar);
        }
        if (!(drawable instanceof com.bumptech.glide.load.c.d.c)) {
            return null;
        }
        e<com.bumptech.glide.load.c.d.c, byte[]> eVar = this.f8729c;
        a(e2);
        return eVar.a(e2, gVar);
    }
}
