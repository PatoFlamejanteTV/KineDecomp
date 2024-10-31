package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.C0708c;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* renamed from: com.bumptech.glide.load.b.b */
/* loaded from: classes.dex */
class C0707b implements C0708c.b<ByteBuffer> {

    /* renamed from: a */
    final /* synthetic */ C0708c.a f8601a;

    public C0707b(C0708c.a aVar) {
        this.f8601a = aVar;
    }

    @Override // com.bumptech.glide.load.b.C0708c.b
    public ByteBuffer a(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.bumptech.glide.load.b.C0708c.b
    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }
}
