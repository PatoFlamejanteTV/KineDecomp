package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class e implements com.bumptech.glide.load.j<Bitmap> {
    protected abstract Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.j
    public final E<Bitmap> a(Context context, E<Bitmap> e2, int i, int i2) {
        if (com.bumptech.glide.g.n.b(i, i2)) {
            com.bumptech.glide.load.engine.a.e c2 = com.bumptech.glide.c.a(context).c();
            Bitmap bitmap = e2.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a2 = a(c2, bitmap, i, i2);
            return bitmap.equals(a2) ? e2 : d.a(a2, c2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
