package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* compiled from: AbstractHasher.java */
/* loaded from: classes2.dex */
abstract class a implements Hasher {
    @Override // com.google.common.hash.Hasher
    public Hasher a(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            a(charSequence.charAt(i));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public Hasher a(CharSequence charSequence, Charset charset) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(charSequence));
        if (encode.hasArray()) {
            return a(encode.array(), encode.arrayOffset() + encode.position(), encode.arrayOffset() + encode.limit());
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return a(bArr);
    }
}
