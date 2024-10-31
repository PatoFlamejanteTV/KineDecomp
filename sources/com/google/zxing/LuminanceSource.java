package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class LuminanceSource {

    /* renamed from: a */
    private final int f18948a;

    /* renamed from: b */
    private final int f18949b;

    public final int a() {
        return this.f18949b;
    }

    public abstract byte[] a(int i, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.f18948a;
    }

    public final String toString() {
        int i = this.f18948a;
        StringBuilder sb = new StringBuilder(this.f18949b * (i + 1));
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < this.f18949b; i2++) {
            bArr = a(i2, bArr);
            for (int i3 = 0; i3 < this.f18948a; i3++) {
                int i4 = bArr[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
