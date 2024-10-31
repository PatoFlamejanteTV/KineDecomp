package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class ByteMatrix {

    /* renamed from: a */
    private final byte[][] f19251a;

    /* renamed from: b */
    private final int f19252b;

    /* renamed from: c */
    private final int f19253c;

    public ByteMatrix(int i, int i2) {
        this.f19251a = (byte[][]) Array.newInstance((Class<?>) byte.class, i2, i);
        this.f19252b = i;
        this.f19253c = i2;
    }

    public byte a(int i, int i2) {
        return this.f19251a[i2][i];
    }

    public int b() {
        return this.f19253c;
    }

    public int c() {
        return this.f19252b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f19252b * 2 * this.f19253c) + 2);
        for (int i = 0; i < this.f19253c; i++) {
            for (int i2 = 0; i2 < this.f19252b; i2++) {
                byte b2 = this.f19251a[i][i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.f19251a;
    }

    public void a(int i, int i2, int i3) {
        this.f19251a[i2][i] = (byte) i3;
    }

    public void a(int i, int i2, boolean z) {
        this.f19251a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public void a(byte b2) {
        for (int i = 0; i < this.f19253c; i++) {
            for (int i2 = 0; i2 < this.f19252b; i2++) {
                this.f19251a[i][i2] = b2;
            }
        }
    }
}
