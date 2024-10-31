package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
class z implements f.a<Integer> {

    /* renamed from: a */
    private final ByteBuffer f9059a = ByteBuffer.allocate(4);

    @Override // com.bumptech.glide.load.f.a
    public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f9059a) {
            this.f9059a.position(0);
            messageDigest.update(this.f9059a.putInt(num.intValue()).array());
        }
    }
}
