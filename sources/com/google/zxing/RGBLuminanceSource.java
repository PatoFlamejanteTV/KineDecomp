package com.google.zxing;

/* loaded from: classes2.dex */
public final class RGBLuminanceSource extends LuminanceSource {

    /* renamed from: c */
    private final byte[] f18956c;

    /* renamed from: d */
    private final int f18957d;

    /* renamed from: e */
    private final int f18958e;

    /* renamed from: f */
    private final int f18959f;

    /* renamed from: g */
    private final int f18960g;

    @Override // com.google.zxing.LuminanceSource
    public byte[] a(int i, byte[] bArr) {
        if (i >= 0 && i < a()) {
            int c2 = c();
            if (bArr == null || bArr.length < c2) {
                bArr = new byte[c2];
            }
            System.arraycopy(this.f18956c, ((i + this.f18960g) * this.f18957d) + this.f18959f, bArr, 0, c2);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] b() {
        int c2 = c();
        int a2 = a();
        if (c2 == this.f18957d && a2 == this.f18958e) {
            return this.f18956c;
        }
        int i = c2 * a2;
        byte[] bArr = new byte[i];
        int i2 = this.f18960g;
        int i3 = this.f18957d;
        int i4 = (i2 * i3) + this.f18959f;
        if (c2 == i3) {
            System.arraycopy(this.f18956c, i4, bArr, 0, i);
            return bArr;
        }
        for (int i5 = 0; i5 < a2; i5++) {
            System.arraycopy(this.f18956c, i4, bArr, i5 * c2, c2);
            i4 += this.f18957d;
        }
        return bArr;
    }
}