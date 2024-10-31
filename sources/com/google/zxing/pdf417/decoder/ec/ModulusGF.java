package com.google.zxing.pdf417.decoder.ec;

/* loaded from: classes2.dex */
public final class ModulusGF {

    /* renamed from: a */
    public static final ModulusGF f19202a = new ModulusGF(929, 3);

    /* renamed from: b */
    private final int[] f19203b;

    /* renamed from: c */
    private final int[] f19204c;

    /* renamed from: d */
    private final a f19205d;

    /* renamed from: e */
    private final a f19206e;

    /* renamed from: f */
    private final int f19207f;

    private ModulusGF(int i, int i2) {
        this.f19207f = i;
        this.f19203b = new int[i];
        this.f19204c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f19203b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f19204c[this.f19203b[i5]] = i5;
        }
        this.f19205d = new a(this, new int[]{0});
        this.f19206e = new a(this, new int[]{1});
    }
}
