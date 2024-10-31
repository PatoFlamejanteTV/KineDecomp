package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.a.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f8679a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.load.c.a.a$a */
    /* loaded from: classes.dex */
    public static class C0053a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.a.e.a
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.a.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f8679a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.a.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.a.e
    public ByteBuffer a() {
        this.f8679a.position(0);
        return this.f8679a;
    }
}
