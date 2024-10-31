package com.bumptech.glide.load.c.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;

/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.h<com.bumptech.glide.b.a, Bitmap> {

    /* renamed from: a */
    private final com.bumptech.glide.load.engine.a.e f8718a;

    public h(com.bumptech.glide.load.engine.a.e eVar) {
        this.f8718a = eVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(com.bumptech.glide.b.a aVar, com.bumptech.glide.load.g gVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(com.bumptech.glide.b.a aVar, int i, int i2, com.bumptech.glide.load.g gVar) {
        return com.bumptech.glide.load.resource.bitmap.d.a(aVar.a(), this.f8718a);
    }
}
