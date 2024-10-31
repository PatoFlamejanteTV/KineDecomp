package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteCountingOutputStream.java */
/* loaded from: classes2.dex */
public final class c extends OutputStream {

    /* renamed from: a */
    long f14982a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f14982a += i2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f14982a++;
    }
}
