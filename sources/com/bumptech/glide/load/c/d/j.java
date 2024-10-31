package com.bumptech.glide.load.c.d;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.E;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.h<InputStream, c> {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f8721a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<ByteBuffer, c> f8722b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f8723c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.h<ByteBuffer, c> hVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f8721a = list;
        this.f8722b = hVar;
        this.f8723c = bVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(InputStream inputStream, com.bumptech.glide.load.g gVar) throws IOException {
        return !((Boolean) gVar.a(i.f8720b)).booleanValue() && com.bumptech.glide.load.b.b(this.f8721a, inputStream, this.f8723c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.h
    public E<c> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f8722b.a(ByteBuffer.wrap(a2), i, i2, gVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }
}
