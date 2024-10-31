package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Dk {

    /* renamed from: a */
    private static final long[] f11472a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f11473b = new byte[8];

    /* renamed from: c */
    private int f11474c;

    /* renamed from: d */
    private int f11475d;

    public final void a() {
        this.f11474c = 0;
        this.f11475d = 0;
    }

    public final int b() {
        return this.f11475d;
    }

    public final long a(zzia zziaVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.f11474c == 0) {
            if (!zziaVar.zza(this.f11473b, 0, 1, z)) {
                return -1L;
            }
            this.f11475d = a(this.f11473b[0] & 255);
            if (this.f11475d != -1) {
                this.f11474c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f11475d;
        if (i2 > i) {
            this.f11474c = 0;
            return -2L;
        }
        if (i2 != 1) {
            zziaVar.readFully(this.f11473b, 1, i2 - 1);
        }
        this.f11474c = 0;
        return a(this.f11473b, this.f11475d, z2);
    }

    public static int a(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f11472a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= f11472a[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }
}
