package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ByteCountingOutputStream.java */
/* loaded from: classes.dex */
final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    long f2549a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f2549a += i2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f2549a++;
    }
}
