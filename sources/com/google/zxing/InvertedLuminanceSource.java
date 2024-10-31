package com.google.zxing;

/* loaded from: classes2.dex */
public final class InvertedLuminanceSource extends LuminanceSource {

    /* renamed from: c */
    private final LuminanceSource f18947c;

    @Override // com.google.zxing.LuminanceSource
    public byte[] a(int i, byte[] bArr) {
        byte[] a2 = this.f18947c.a(i, bArr);
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            a2[i2] = (byte) (255 - (a2[i2] & 255));
        }
        return a2;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] b() {
        byte[] b2 = this.f18947c.b();
        int c2 = c() * a();
        byte[] bArr = new byte[c2];
        for (int i = 0; i < c2; i++) {
            bArr[i] = (byte) (255 - (b2[i] & 255));
        }
        return bArr;
    }
}
