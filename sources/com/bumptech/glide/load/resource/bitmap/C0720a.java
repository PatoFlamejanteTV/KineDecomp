package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.E;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* loaded from: classes.dex */
public class C0720a<DataType> implements com.bumptech.glide.load.h<DataType, BitmapDrawable> {

    /* renamed from: a */
    private final com.bumptech.glide.load.h<DataType, Bitmap> f9010a;

    /* renamed from: b */
    private final Resources f9011b;

    public C0720a(Resources resources, com.bumptech.glide.load.h<DataType, Bitmap> hVar) {
        com.bumptech.glide.g.l.a(resources);
        this.f9011b = resources;
        com.bumptech.glide.g.l.a(hVar);
        this.f9010a = hVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(DataType datatype, com.bumptech.glide.load.g gVar) throws IOException {
        return this.f9010a.a(datatype, gVar);
    }

    @Override // com.bumptech.glide.load.h
    public E<BitmapDrawable> a(DataType datatype, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        return t.a(this.f9011b, this.f9010a.a(datatype, i, i2, gVar));
    }
}
