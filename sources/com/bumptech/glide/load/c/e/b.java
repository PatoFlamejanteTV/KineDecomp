package com.bumptech.glide.load.c.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.l;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.resource.bitmap.t;

/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a */
    private final Resources f8726a;

    public b(Resources resources) {
        l.a(resources);
        this.f8726a = resources;
    }

    @Override // com.bumptech.glide.load.c.e.e
    public E<BitmapDrawable> a(E<Bitmap> e2, com.bumptech.glide.load.g gVar) {
        return t.a(this.f8726a, e2);
    }
}
