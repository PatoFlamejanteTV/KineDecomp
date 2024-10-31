package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ByteArrayContent extends AbstractInputStreamContent {

    /* renamed from: c */
    private final byte[] f14728c;

    /* renamed from: d */
    private final int f14729d;

    /* renamed from: e */
    private final int f14730e;

    public ByteArrayContent(String str, byte[] bArr, int i, int i2) {
        super(str);
        Preconditions.a(bArr);
        this.f14728c = bArr;
        Preconditions.a(i >= 0 && i2 >= 0 && i + i2 <= bArr.length, "offset %s, length %s, array length %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        this.f14729d = i;
        this.f14730e = i2;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean a() {
        return true;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream c() {
        return new ByteArrayInputStream(this.f14728c, this.f14729d, this.f14730e);
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f14730e;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public ByteArrayContent a(String str) {
        super.a(str);
        return this;
    }
}
