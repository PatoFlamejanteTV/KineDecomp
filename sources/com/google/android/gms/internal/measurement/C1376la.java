package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.la, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1376la extends zztq {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f13475a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13476b;

    /* renamed from: c, reason: collision with root package name */
    private int f13477c;

    /* renamed from: d, reason: collision with root package name */
    private int f13478d;

    /* renamed from: e, reason: collision with root package name */
    private int f13479e;

    /* renamed from: f, reason: collision with root package name */
    private int f13480f;

    /* renamed from: g, reason: collision with root package name */
    private int f13481g;

    /* renamed from: h, reason: collision with root package name */
    private int f13482h;

    private C1376la(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f13482h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f13475a = bArr;
        this.f13477c = i2 + i;
        this.f13479e = i;
        this.f13480f = this.f13479e;
        this.f13476b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:            if (r2[r3] >= 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13479e
            int r1 = r5.f13477c
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f13475a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f13479e = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.f13479e = r1
            return r0
        L6b:
            long r0 = r5.zzuy()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1376la.a():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:            if (r2[r0] >= 0) goto L39;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long b() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1376la.b():long");
    }

    private final int c() throws IOException {
        int i = this.f13479e;
        if (this.f13477c - i >= 4) {
            byte[] bArr = this.f13475a;
            this.f13479e = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzuv.zzwq();
    }

    private final long d() throws IOException {
        int i = this.f13479e;
        if (this.f13477c - i >= 8) {
            byte[] bArr = this.f13475a;
            this.f13479e = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzuv.zzwq();
    }

    private final void e() {
        this.f13477c += this.f13478d;
        int i = this.f13477c;
        int i2 = i - this.f13480f;
        int i3 = this.f13482h;
        if (i2 > i3) {
            this.f13478d = i2 - i3;
            this.f13477c = i - this.f13478d;
        } else {
            this.f13478d = 0;
        }
    }

    private final byte f() throws IOException {
        int i = this.f13479e;
        if (i != this.f13477c) {
            byte[] bArr = this.f13475a;
            this.f13479e = i + 1;
            return bArr[i];
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(d());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(c());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String readString() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13477c;
            int i2 = this.f13479e;
            if (a2 <= i - i2) {
                String str = new String(this.f13475a, i2, a2, zzuq.UTF_8);
                this.f13479e += a2;
                return str;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 < 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final <T extends zzvv> T zza(zzwf<T> zzwfVar, zzub zzubVar) throws IOException {
        int a2 = a();
        if (this.zzbty < this.zzbtz) {
            int zzas = zzas(a2);
            this.zzbty++;
            T zza = zzwfVar.zza(this, zzubVar);
            zzap(0);
            this.zzbty--;
            zzat(zzas);
            return zza;
        }
        throw zzuv.zzwv();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzap(int i) throws zzuv {
        if (this.f13481g != i) {
            throw zzuv.zzwt();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f13477c - this.f13479e >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f13475a;
                    int i4 = this.f13479e;
                    this.f13479e = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzuv.zzws();
            }
            while (i3 < 10) {
                if (f() < 0) {
                    i3++;
                }
            }
            throw zzuv.zzws();
            return true;
        }
        if (i2 == 1) {
            zzau(8);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzau(4);
                    return true;
                }
                throw zzuv.zzwu();
            }
            do {
                zzuj = zzuj();
                if (zzuj == 0) {
                    break;
                }
            } while (zzaq(zzuj));
            zzap(((i >>> 3) << 3) | 4);
            return true;
        }
        zzau(a());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzas(int i) throws zzuv {
        if (i >= 0) {
            int zzva = i + zzva();
            int i2 = this.f13482h;
            if (zzva <= i2) {
                this.f13482h = zzva;
                e();
                return i2;
            }
            throw zzuv.zzwq();
        }
        throw zzuv.zzwr();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzat(int i) {
        this.f13482h = i;
        e();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzau(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f13477c;
            int i3 = this.f13479e;
            if (i <= i2 - i3) {
                this.f13479e = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuj() throws IOException {
        if (zzuz()) {
            this.f13481g = 0;
            return 0;
        }
        this.f13481g = a();
        int i = this.f13481g;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuk() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzul() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzum() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzun() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuo() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzup() throws IOException {
        return b() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String zzuq() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13477c;
            int i2 = this.f13479e;
            if (a2 <= i - i2) {
                String b2 = zb.b(this.f13475a, i2, a2);
                this.f13479e += a2;
                return b2;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 <= 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final zzte zzur() throws IOException {
        byte[] bArr;
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13477c;
            int i2 = this.f13479e;
            if (a2 <= i - i2) {
                zzte zzb = zzte.zzb(this.f13475a, i2, a2);
                this.f13479e += a2;
                return zzb;
            }
        }
        if (a2 == 0) {
            return zzte.zzbtq;
        }
        if (a2 > 0) {
            int i3 = this.f13477c;
            int i4 = this.f13479e;
            if (a2 <= i3 - i4) {
                this.f13479e = a2 + i4;
                bArr = Arrays.copyOfRange(this.f13475a, i4, this.f13479e);
                return zzte.zzi(bArr);
            }
        }
        if (a2 > 0) {
            throw zzuv.zzwq();
        }
        if (a2 == 0) {
            bArr = zzuq.zzbza;
            return zzte.zzi(bArr);
        }
        throw zzuv.zzwr();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzus() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzut() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuu() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuv() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuw() throws IOException {
        int a2 = a();
        return (-(a2 & 1)) ^ (a2 >>> 1);
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzux() throws IOException {
        long b2 = b();
        return (-(b2 & 1)) ^ (b2 >>> 1);
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    final long zzuy() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((f() & 128) == 0) {
                return j;
            }
        }
        throw zzuv.zzws();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzuz() throws IOException {
        return this.f13479e == this.f13477c;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzva() {
        return this.f13479e - this.f13480f;
    }
}
