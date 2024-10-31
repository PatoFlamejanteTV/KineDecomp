package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ByteArrayContent extends AbstractInputStreamContent {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2452a;
    private final int b;
    private final int c;

    public ByteArrayContent(String str, byte[] bArr, int i, int i2) {
        super(str);
        this.f2452a = (byte[]) Preconditions.a(bArr);
        Preconditions.a(i >= 0 && i2 >= 0 && i + i2 <= bArr.length, "offset %s, length %s, array length %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.api.client.http.HttpContent
    public long a() {
        return this.c;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean f() {
        return true;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream b() {
        return new ByteArrayInputStream(this.f2452a, this.b, this.c);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteArrayContent a(String str) {
        return (ByteArrayContent) super.a(str);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteArrayContent a(boolean z) {
        return (ByteArrayContent) super.a(z);
    }
}
