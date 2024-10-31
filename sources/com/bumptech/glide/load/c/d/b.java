package com.bumptech.glide.load.c.d;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0045a {

    /* renamed from: a */
    private final com.bumptech.glide.load.engine.a.e f8693a;

    /* renamed from: b */
    private final com.bumptech.glide.load.engine.a.b f8694b;

    public b(com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f8693a = eVar;
        this.f8694b = bVar;
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f8693a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public int[] b(int i) {
        com.bumptech.glide.load.engine.a.b bVar = this.f8694b;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.a(i, int[].class);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public void a(Bitmap bitmap) {
        this.f8693a.a(bitmap);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public byte[] a(int i) {
        com.bumptech.glide.load.engine.a.b bVar = this.f8694b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.a(i, byte[].class);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public void a(byte[] bArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f8694b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0045a
    public void a(int[] iArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f8694b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
