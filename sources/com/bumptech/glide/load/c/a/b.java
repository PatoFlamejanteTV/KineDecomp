package com.bumptech.glide.load.c.a;

import com.bumptech.glide.g.l;
import com.bumptech.glide.load.engine.E;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements E<byte[]> {

    /* renamed from: a */
    private final byte[] f8680a;

    public b(byte[] bArr) {
        l.a(bArr);
        this.f8680a = bArr;
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return this.f8680a.length;
    }

    @Override // com.bumptech.glide.load.engine.E
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<byte[]> c() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.E
    public byte[] get() {
        return this.f8680a;
    }
}
