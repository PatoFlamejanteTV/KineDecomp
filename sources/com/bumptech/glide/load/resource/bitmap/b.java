package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.E;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.i<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f9012a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.i<Bitmap> f9013b;

    public b(com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.i<Bitmap> iVar) {
        this.f9012a = eVar;
        this.f9013b = iVar;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(E<BitmapDrawable> e2, File file, com.bumptech.glide.load.g gVar) {
        return this.f9013b.a(new d(e2.get().getBitmap(), this.f9012a), file, gVar);
    }

    @Override // com.bumptech.glide.load.i
    public EncodeStrategy a(com.bumptech.glide.load.g gVar) {
        return this.f9013b.a(gVar);
    }
}
