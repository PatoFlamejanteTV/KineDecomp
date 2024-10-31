package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzoy extends InputStream {
    private final zzov zzagy;
    private final zzoz zzazo;
    private long zzbfs;
    private boolean zzbfr = false;
    private boolean closed = false;
    private final byte[] zzbfq = new byte[1];

    public zzoy(zzov zzovVar, zzoz zzozVar) {
        this.zzagy = zzovVar;
        this.zzazo = zzozVar;
    }

    private final void zzgu() throws IOException {
        if (this.zzbfr) {
            return;
        }
        this.zzagy.zza(this.zzazo);
        this.zzbfr = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.zzagy.close();
        this.closed = true;
    }

    public final void open() throws IOException {
        zzgu();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (read(this.zzbfq) == -1) {
            return -1;
        }
        return this.zzbfq[0] & 255;
    }

    public final long zzgt() {
        return this.zzbfs;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        zzpo.checkState(!this.closed);
        zzgu();
        int read = this.zzagy.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.zzbfs += read;
        return read;
    }
}
