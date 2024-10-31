package com.google.zxing.pdf417.encoder;

/* compiled from: BarcodeRow.java */
/* loaded from: classes2.dex */
final class a {

    /* renamed from: a */
    private final byte[] f19230a;

    /* renamed from: b */
    private int f19231b = 0;

    public a(int i) {
        this.f19230a = new byte[i];
    }

    private void a(int i, boolean z) {
        this.f19230a[i] = z ? (byte) 1 : (byte) 0;
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f19231b;
            this.f19231b = i3 + 1;
            a(i3, z);
        }
    }

    public byte[] a(int i) {
        byte[] bArr = new byte[this.f19230a.length * i];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f19230a[i2 / i];
        }
        return bArr;
    }
}
