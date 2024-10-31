package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1313ja extends zzqe {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f13241a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13242b;

    /* renamed from: c, reason: collision with root package name */
    private int f13243c;

    /* renamed from: d, reason: collision with root package name */
    private int f13244d;

    /* renamed from: e, reason: collision with root package name */
    private int f13245e;

    /* renamed from: f, reason: collision with root package name */
    private int f13246f;

    /* renamed from: g, reason: collision with root package name */
    private int f13247g;

    /* renamed from: h, reason: collision with root package name */
    private int f13248h;

    private C1313ja(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f13248h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f13241a = bArr;
        this.f13243c = i2 + i;
        this.f13245e = i;
        this.f13246f = this.f13245e;
        this.f13242b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:            if (r2[r3] >= 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13245e
            int r1 = r5.f13243c
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f13241a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f13245e = r3
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
            r5.f13245e = r1
            return r0
        L6b:
            long r0 = r5.zznx()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C1313ja.a():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C1313ja.b():long");
    }

    private final int c() throws IOException {
        int i = this.f13245e;
        if (this.f13243c - i >= 4) {
            byte[] bArr = this.f13241a;
            this.f13245e = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzrk.zzpp();
    }

    private final long d() throws IOException {
        int i = this.f13245e;
        if (this.f13243c - i >= 8) {
            byte[] bArr = this.f13241a;
            this.f13245e = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzrk.zzpp();
    }

    private final void e() {
        this.f13243c += this.f13244d;
        int i = this.f13243c;
        int i2 = i - this.f13246f;
        int i3 = this.f13248h;
        if (i2 > i3) {
            this.f13244d = i2 - i3;
            this.f13243c = i - this.f13244d;
        } else {
            this.f13244d = 0;
        }
    }

    private final byte f() throws IOException {
        int i = this.f13245e;
        if (i != this.f13243c) {
            byte[] bArr = this.f13241a;
            this.f13245e = i + 1;
            return bArr[i];
        }
        throw zzrk.zzpp();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(d());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(c());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String readString() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13243c;
            int i2 = this.f13245e;
            if (a2 <= i - i2) {
                String str = new String(this.f13241a, i2, a2, zzre.UTF_8);
                this.f13245e += a2;
                return str;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 < 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar) throws IOException {
        int a2 = a();
        if (this.zzawf < this.zzawg) {
            int zzaq = zzaq(a2);
            this.zzawf++;
            T zza = zzsuVar.zza(this, zzqpVar);
            zzan(0);
            this.zzawf--;
            zzar(zzaq);
            return zza;
        }
        throw zzrk.zzpu();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzan(int i) throws zzrk {
        if (this.f13247g != i) {
            throw zzrk.zzps();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzao(int i) throws IOException {
        int zzni;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f13243c - this.f13245e >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f13241a;
                    int i4 = this.f13245e;
                    this.f13245e = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzrk.zzpr();
            }
            while (i3 < 10) {
                if (f() < 0) {
                    i3++;
                }
            }
            throw zzrk.zzpr();
            return true;
        }
        if (i2 == 1) {
            zzas(8);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzas(4);
                    return true;
                }
                throw zzrk.zzpt();
            }
            do {
                zzni = zzni();
                if (zzni == 0) {
                    break;
                }
            } while (zzao(zzni));
            zzan(((i >>> 3) << 3) | 4);
            return true;
        }
        zzas(a());
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzaq(int i) throws zzrk {
        if (i >= 0) {
            int zznz = i + zznz();
            int i2 = this.f13248h;
            if (zznz <= i2) {
                this.f13248h = zznz;
                e();
                return i2;
            }
            throw zzrk.zzpp();
        }
        throw zzrk.zzpq();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzar(int i) {
        this.f13248h = i;
        e();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzas(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f13243c;
            int i3 = this.f13245e;
            if (i <= i2 - i3) {
                this.f13245e = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzni() throws IOException {
        if (zzny()) {
            this.f13247g = 0;
            return 0;
        }
        this.f13247g = a();
        int i = this.f13247g;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw new zzrk("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznj() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznk() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznl() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznm() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznn() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzno() throws IOException {
        return b() != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String zznp() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13243c;
            int i2 = this.f13245e;
            if (a2 <= i - i2) {
                String b2 = wb.b(this.f13241a, i2, a2);
                this.f13245e += a2;
                return b2;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 <= 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final zzps zznq() throws IOException {
        byte[] bArr;
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13243c;
            int i2 = this.f13245e;
            if (a2 <= i - i2) {
                zzps zzb = zzps.zzb(this.f13241a, i2, a2);
                this.f13245e += a2;
                return zzb;
            }
        }
        if (a2 == 0) {
            return zzps.zzavx;
        }
        if (a2 > 0) {
            int i3 = this.f13243c;
            int i4 = this.f13245e;
            if (a2 <= i3 - i4) {
                this.f13245e = a2 + i4;
                bArr = Arrays.copyOfRange(this.f13241a, i4, this.f13245e);
                return zzps.zzf(bArr);
            }
        }
        if (a2 > 0) {
            throw zzrk.zzpp();
        }
        if (a2 == 0) {
            bArr = zzre.zzbbh;
            return zzps.zzf(bArr);
        }
        throw zzrk.zzpq();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznr() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzns() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznt() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznu() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznv() throws IOException {
        int a2 = a();
        return (-(a2 & 1)) ^ (a2 >>> 1);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznw() throws IOException {
        long b2 = b();
        return (-(b2 & 1)) ^ (b2 >>> 1);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    final long zznx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((f() & 128) == 0) {
                return j;
            }
        }
        throw zzrk.zzpr();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzny() throws IOException {
        return this.f13245e == this.f13243c;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznz() {
        return this.f13245e - this.f13246f;
    }
}
