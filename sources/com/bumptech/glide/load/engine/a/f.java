package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.a.e
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
