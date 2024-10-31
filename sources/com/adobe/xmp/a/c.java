package com.adobe.xmp.a;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: CountOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a */
    private final OutputStream f7505a;

    /* renamed from: b */
    private int f7506b = 0;

    public c(OutputStream outputStream) {
        this.f7505a = outputStream;
    }

    public int a() {
        return this.f7506b;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f7505a.write(bArr, i, i2);
        this.f7506b += i2;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f7505a.write(bArr);
        this.f7506b += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f7505a.write(i);
        this.f7506b++;
    }
}
