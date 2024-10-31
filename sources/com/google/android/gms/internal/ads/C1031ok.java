package com.google.android.gms.internal.ads;

import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.ok */
/* loaded from: classes2.dex */
final class C1031ok {

    /* renamed from: a */
    private final int f12390a;

    /* renamed from: b */
    private final int f12391b;

    /* renamed from: c */
    private final int f12392c;

    /* renamed from: d */
    private final int f12393d;

    /* renamed from: e */
    private final int f12394e;

    /* renamed from: f */
    private final short[] f12395f;

    /* renamed from: g */
    private int f12396g;

    /* renamed from: h */
    private short[] f12397h;
    private int i;
    private short[] j;
    private int k;
    private short[] l;
    private int m;
    private int n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;

    public C1031ok(int i, int i2) {
        this.f12390a = i;
        this.f12391b = i2;
        this.f12392c = i / 400;
        this.f12393d = i / 65;
        this.f12394e = this.f12393d * 2;
        int i3 = this.f12394e;
        this.f12395f = new short[i3];
        this.f12396g = i3;
        this.f12397h = new short[i3 * i2];
        this.i = i3;
        this.j = new short[i3 * i2];
        this.k = i3;
        this.l = new short[i3 * i2];
        this.m = 0;
        this.n = 0;
        this.u = 0;
        this.o = 1.0f;
        this.p = 1.0f;
    }

    private final void c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.r;
        float f2 = this.o / this.p;
        double d2 = f2;
        int i8 = 1;
        if (d2 <= 1.00001d && d2 >= 0.99999d) {
            a(this.f12397h, 0, this.q);
            this.q = 0;
        } else {
            int i9 = this.q;
            if (i9 >= this.f12394e) {
                int i10 = 0;
                while (true) {
                    int i11 = this.t;
                    if (i11 > 0) {
                        int min = Math.min(this.f12394e, i11);
                        a(this.f12397h, i10, min);
                        this.t -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.f12397h;
                        int i12 = this.f12390a;
                        int i13 = i12 > 4000 ? i12 / LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT : 1;
                        if (this.f12391b == i8 && i13 == i8) {
                            i = a(sArr, i10, this.f12392c, this.f12393d);
                        } else {
                            b(sArr, i10, i13);
                            int a2 = a(this.f12395f, 0, this.f12392c / i13, this.f12393d / i13);
                            if (i13 != i8) {
                                int i14 = a2 * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.f12392c;
                                if (i16 >= i18) {
                                    i18 = i16;
                                }
                                int i19 = this.f12393d;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.f12391b == i8) {
                                    i = a(sArr, i10, i18, i17);
                                } else {
                                    b(sArr, i10, i8);
                                    i = a(this.f12395f, 0, i18, i17);
                                }
                            } else {
                                i = a2;
                            }
                        }
                        int i20 = this.w;
                        int i21 = i20 != 0 && this.u != 0 && this.x <= i20 * 3 && (i20 << 1) > this.v * 3 ? this.u : i;
                        this.v = this.w;
                        this.u = i;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.f12397h;
                            if (f2 >= 2.0f) {
                                i3 = (int) (i21 / (f2 - 1.0f));
                            } else {
                                this.t = (int) ((i21 * (2.0f - f2)) / (f2 - 1.0f));
                                i3 = i21;
                            }
                            a(i3);
                            int i22 = i3;
                            a(i3, this.f12391b, this.j, this.r, sArr2, i10, sArr2, i10 + i21);
                            this.r += i22;
                            i10 += i21 + i22;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.f12397h;
                            if (f2 < 0.5f) {
                                i2 = (int) ((i23 * f2) / (1.0f - f2));
                            } else {
                                this.t = (int) ((i23 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i2 = i23;
                            }
                            int i24 = i23 + i2;
                            a(i24);
                            int i25 = this.f12391b;
                            System.arraycopy(sArr3, i10 * i25, this.j, this.r * i25, i25 * i23);
                            a(i2, this.f12391b, this.j, this.r + i23, sArr3, i23 + i10, sArr3, i10);
                            this.r += i24;
                            i10 += i2;
                        }
                    }
                    if (this.f12394e + i10 > i9) {
                        break;
                    } else {
                        i8 = 1;
                    }
                }
                int i26 = this.q - i10;
                short[] sArr4 = this.f12397h;
                int i27 = this.f12391b;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.q = i26;
            }
        }
        float f3 = this.p;
        if (f3 == 1.0f || this.r == i7) {
            return;
        }
        int i28 = this.f12390a;
        int i29 = (int) (i28 / f3);
        while (true) {
            if (i29 <= 16384 && i28 <= 16384) {
                break;
            }
            i29 /= 2;
            i28 /= 2;
        }
        int i30 = this.r - i7;
        int i31 = this.s + i30;
        int i32 = this.k;
        if (i31 > i32) {
            this.k = i32 + (i32 / 2) + i30;
            this.l = Arrays.copyOf(this.l, this.k * this.f12391b);
        }
        short[] sArr5 = this.j;
        int i33 = this.f12391b;
        System.arraycopy(sArr5, i7 * i33, this.l, this.s * i33, i33 * i30);
        this.r = i7;
        this.s += i30;
        int i34 = 0;
        while (true) {
            i4 = this.s;
            if (i34 >= i4 - 1) {
                break;
            }
            while (true) {
                i5 = this.m;
                int i35 = (i5 + 1) * i29;
                i6 = this.n;
                if (i35 <= i6 * i28) {
                    break;
                }
                a(1);
                int i36 = 0;
                while (true) {
                    int i37 = this.f12391b;
                    if (i36 < i37) {
                        short[] sArr6 = this.j;
                        int i38 = (this.r * i37) + i36;
                        short[] sArr7 = this.l;
                        int i39 = (i34 * i37) + i36;
                        short s = sArr7[i39];
                        short s2 = sArr7[i39 + i37];
                        int i40 = this.n * i28;
                        int i41 = this.m;
                        int i42 = i41 * i29;
                        int i43 = (i41 + 1) * i29;
                        int i44 = i43 - i40;
                        int i45 = i43 - i42;
                        sArr6[i38] = (short) (((s * i44) + ((i45 - i44) * s2)) / i45);
                        i36++;
                    }
                }
                this.n++;
                this.r++;
            }
            this.m = i5 + 1;
            if (this.m == i28) {
                this.m = 0;
                zzpo.checkState(i6 == i29);
                this.n = 0;
            }
            i34++;
        }
        int i46 = i4 - 1;
        if (i46 != 0) {
            short[] sArr8 = this.l;
            int i47 = this.f12391b;
            System.arraycopy(sArr8, i46 * i47, sArr8, 0, (i4 - i46) * i47);
            this.s -= i46;
        }
    }

    public final void a(float f2) {
        this.o = f2;
    }

    public final void b(float f2) {
        this.p = f2;
    }

    public final void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.f12391b;
        int i2 = remaining / i;
        b(i2);
        shortBuffer.get(this.f12397h, this.q * this.f12391b, ((i * i2) << 1) / 2);
        this.q += i2;
        c();
    }

    public final void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f12391b, this.r);
        shortBuffer.put(this.j, 0, this.f12391b * min);
        this.r -= min;
        short[] sArr = this.j;
        int i = this.f12391b;
        System.arraycopy(sArr, min * i, sArr, 0, this.r * i);
    }

    public final int b() {
        return this.r;
    }

    private final void b(int i) {
        int i2 = this.q + i;
        int i3 = this.f12396g;
        if (i2 > i3) {
            this.f12396g = i3 + (i3 / 2) + i;
            this.f12397h = Arrays.copyOf(this.f12397h, this.f12396g * this.f12391b);
        }
    }

    public final void a() {
        int i;
        int i2 = this.q;
        float f2 = this.o;
        float f3 = this.p;
        int i3 = this.r + ((int) ((((i2 / (f2 / f3)) + this.s) / f3) + 0.5f));
        b((this.f12394e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.f12394e;
            int i5 = this.f12391b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.f12397h[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.q += i * 2;
        c();
        if (this.r > i3) {
            this.r = i3;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    private final void b(short[] sArr, int i, int i2) {
        int i3 = this.f12394e / i2;
        int i4 = this.f12391b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f12395f[i7] = (short) (i8 / i5);
        }
    }

    private final void a(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        if (i2 > i3) {
            this.i = i3 + (i3 / 2) + i;
            this.j = Arrays.copyOf(this.j, this.i * this.f12391b);
        }
    }

    private final void a(short[] sArr, int i, int i2) {
        a(i2);
        int i3 = this.f12391b;
        System.arraycopy(sArr, i * i3, this.j, this.r * i3, i3 * i2);
        this.r += i2;
    }

    private final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f12391b;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.w = i5 / i6;
        this.x = i7 / i8;
        return i6;
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
