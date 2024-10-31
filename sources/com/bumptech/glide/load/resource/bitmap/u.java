package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.E;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class u implements com.bumptech.glide.load.h<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.c.b.d f9046a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f9047b;

    public u(com.bumptech.glide.load.c.b.d dVar, com.bumptech.glide.load.engine.a.e eVar) {
        this.f9046a = dVar;
        this.f9047b = eVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(Uri uri, com.bumptech.glide.load.g gVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(Uri uri, int i, int i2, com.bumptech.glide.load.g gVar) {
        E<Drawable> a2 = this.f9046a.a(uri, i, i2, gVar);
        if (a2 == null) {
            return null;
        }
        return o.a(this.f9047b, a2.get(), i, i2);
    }
}
