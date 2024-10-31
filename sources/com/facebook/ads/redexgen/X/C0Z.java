package com.facebook.ads.redexgen.X;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.facebook.ads.redexgen.X.0Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0Z extends BufferedInputStream {
    public int A00;
    public int A01;
    public boolean A02;

    public C0Z(InputStream inputStream) {
        super(inputStream);
        this.A00 = Integer.MAX_VALUE;
    }

    public final boolean A00() {
        return this.A02;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.A00 = i;
        super.mark(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:            return r2;     */
    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int read() throws java.io.IOException {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r0 = r3.A01
            int r1 = r0 + 1
            int r0 = r3.A00
            if (r1 <= r0) goto L25
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L27;
                case 4: goto L17;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            r0 = 1
            r3.A02 = r0
            r2 = -1
            r0 = 3
            goto Lb
        L17:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            int r0 = r3.A01
            int r0 = r0 + 1
            r3.A01 = r0
            int r2 = super.read()
            r0 = 3
            goto Lb
        L25:
            r0 = 4
            goto Lb
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Z.read():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:            return r2;     */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int read(byte[] r5) throws java.io.IOException {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            int r1 = r3.A01
            int r0 = r5.length
            int r1 = r1 + r0
            int r0 = r3.A00
            if (r1 <= r0) goto L21
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L23;
                case 4: goto L17;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            r0 = 1
            r3.A02 = r0
            r2 = -1
            r0 = 3
            goto Lb
        L17:
            com.facebook.ads.redexgen.X.0Z r3 = (com.facebook.ads.redexgen.X.C0Z) r3
            byte[] r5 = (byte[]) r5
            int r2 = super.read(r5)
            r0 = 3
            goto Lb
        L21:
            r0 = 4
            goto Lb
        L23:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0Z.read(byte[]):int");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.A01 + i2 > this.A00) {
            this.A02 = true;
            read = -1;
        } else {
            read = super.read(bArr, i, i2);
            this.A01 += read;
        }
        return read;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.A00 = Integer.MAX_VALUE;
        super.reset();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) throws IOException {
        long skip;
        if (this.A01 + j > this.A00) {
            this.A02 = true;
            skip = 0;
        } else {
            this.A01 = (int) (this.A01 + j);
            skip = super.skip(j);
        }
        return skip;
    }
}
