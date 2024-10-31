package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class c extends ByteArrayOutputStream {

    /* renamed from: a */
    final /* synthetic */ d f8372a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, int i) {
        super(i);
        this.f8372a = dVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        Charset charset;
        int i = ((ByteArrayOutputStream) this).count;
        int i2 = (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1;
        try {
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            charset = this.f8372a.f8374b;
            return new String(bArr, 0, i2, charset.name());
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
