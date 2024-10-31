package com.fasterxml.jackson.core.io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DataOutputAsStream.java */
/* loaded from: classes.dex */
public class b extends OutputStream {

    /* renamed from: a */
    protected final DataOutput f9755a;

    public b(DataOutput dataOutput) {
        this.f9755a = dataOutput;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f9755a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f9755a.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f9755a.write(bArr, i, i2);
    }
}
