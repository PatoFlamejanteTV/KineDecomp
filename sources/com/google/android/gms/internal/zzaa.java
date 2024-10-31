package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class zzaa extends ByteArrayOutputStream {
    private final zzu zzar;

    public zzaa(zzu zzuVar, int i) {
        this.zzar = zzuVar;
        this.buf = this.zzar.zzb(Math.max(i, 256));
    }

    private void zzd(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] zzb = this.zzar.zzb((this.count + i) * 2);
        System.arraycopy(this.buf, 0, zzb, 0, this.count);
        this.zzar.zza(this.buf);
        this.buf = zzb;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzar.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.zzar.zza(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        zzd(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        zzd(i2);
        super.write(bArr, i, i2);
    }
}
