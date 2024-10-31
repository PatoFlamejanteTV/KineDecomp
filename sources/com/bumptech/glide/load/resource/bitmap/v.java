package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.resource.bitmap.m;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class v implements com.bumptech.glide.load.h<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final m f9048a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f9049b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static class a implements m.a {

        /* renamed from: a, reason: collision with root package name */
        private final RecyclableBufferedInputStream f9050a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.g.d f9051b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.bumptech.glide.g.d dVar) {
            this.f9050a = recyclableBufferedInputStream;
            this.f9051b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a() {
            this.f9050a.a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap) throws IOException {
            IOException a2 = this.f9051b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                    throw a2;
                }
                throw a2;
            }
        }
    }

    public v(m mVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f9048a = mVar;
        this.f9049b = bVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(InputStream inputStream, com.bumptech.glide.load.g gVar) {
        return this.f9048a.a(inputStream);
    }

    @Override // com.bumptech.glide.load.h
    public E<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f9049b);
            z = true;
        }
        com.bumptech.glide.g.d a2 = com.bumptech.glide.g.d.a(recyclableBufferedInputStream);
        try {
            return this.f9048a.a(new com.bumptech.glide.g.j(a2), i, i2, gVar, new a(recyclableBufferedInputStream, a2));
        } finally {
            a2.b();
            if (z) {
                recyclableBufferedInputStream.b();
            }
        }
    }
}
