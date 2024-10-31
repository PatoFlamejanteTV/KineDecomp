package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.FilterOutputStream;
import java.io.IOException;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class CountingOutputStream extends FilterOutputStream {

    /* renamed from: a */
    private long f15968a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        this.f15968a += i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        this.f15968a++;
    }
}
