package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;

/* compiled from: LruPoolStrategy.java */
/* loaded from: classes.dex */
interface l {
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);

    Bitmap removeLast();
}
