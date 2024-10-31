package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.C0708c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteArrayLoader.java */
/* renamed from: com.bumptech.glide.load.b.d */
/* loaded from: classes.dex */
class C0709d implements C0708c.b<InputStream> {

    /* renamed from: a */
    final /* synthetic */ C0708c.d f8605a;

    public C0709d(C0708c.d dVar) {
        this.f8605a = dVar;
    }

    @Override // com.bumptech.glide.load.b.C0708c.b
    public InputStream a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @Override // com.bumptech.glide.load.b.C0708c.b
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
