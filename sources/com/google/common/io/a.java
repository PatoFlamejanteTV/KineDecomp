package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.OutputStream;

/* compiled from: ByteStreams.java */
/* loaded from: classes2.dex */
class a extends OutputStream {
    public String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        Preconditions.a(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        Preconditions.a(bArr);
    }
}
