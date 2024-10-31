package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.FilterOutputStream;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class CountingOutputStream extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f2912a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.f2912a += i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.f2912a++;
    }
}
