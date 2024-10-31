package com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a */
    private final Bitmap.CompressFormat f8724a;

    /* renamed from: b */
    private final int f8725b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.c.e.e
    public E<byte[]> a(E<Bitmap> e2, com.bumptech.glide.load.g gVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e2.get().compress(this.f8724a, this.f8725b, byteArrayOutputStream);
        e2.b();
        return new com.bumptech.glide.load.c.a.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        this.f8724a = compressFormat;
        this.f8725b = i;
    }
}
