package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.h<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final m f9019a;

    public g(m mVar) {
        this.f9019a = mVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.g gVar) {
        return this.f9019a.a(byteBuffer);
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        return this.f9019a.a(com.bumptech.glide.g.a.b(byteBuffer), i, i2, gVar);
    }
}
