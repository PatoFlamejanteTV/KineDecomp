package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* loaded from: classes.dex */
public class i extends e {

    /* renamed from: a */
    private static final byte[] f9021a = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(com.bumptech.glide.load.c.f8677a);

    @Override // com.bumptech.glide.load.resource.bitmap.e
    protected Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        return w.b(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f9021a);
    }
}
