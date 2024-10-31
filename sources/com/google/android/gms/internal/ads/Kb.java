package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Kb extends FilterInputStream {

    /* renamed from: a */
    private final long f11637a;

    /* renamed from: b */
    private long f11638b;

    public Kb(InputStream inputStream, long j) {
        super(inputStream);
        this.f11637a = j;
    }

    public final long a() {
        return this.f11637a - this.f11638b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f11638b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f11638b += read;
        }
        return read;
    }
}
