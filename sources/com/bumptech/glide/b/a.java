package com.bumptech.glide.b;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.b.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0045a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        byte[] a(int i);

        int[] b(int i);
    }

    Bitmap a();

    void a(Bitmap.Config config);

    void advance();

    int b();

    int c();

    void clear();

    void d();

    int e();

    int f();

    ByteBuffer getData();
}
