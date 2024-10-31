package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class y implements f.a<Long> {

    /* renamed from: a */
    private final ByteBuffer f9058a = ByteBuffer.allocate(8);

    @Override // com.bumptech.glide.load.f.a
    public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.f9058a) {
            this.f9058a.position(0);
            messageDigest.update(this.f9058a.putLong(l.longValue()).array());
        }
    }
}
