package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Dh extends zzbqf {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f11462a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f11463b;

    /* renamed from: c, reason: collision with root package name */
    private int f11464c;

    /* renamed from: d, reason: collision with root package name */
    private int f11465d;

    /* renamed from: e, reason: collision with root package name */
    private int f11466e;

    /* renamed from: f, reason: collision with root package name */
    private int f11467f;

    /* renamed from: g, reason: collision with root package name */
    private int f11468g;

    /* renamed from: h, reason: collision with root package name */
    private int f11469h;

    private Dh(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f11469h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f11462a = bArr;
        this.f11464c = i2 + i;
        this.f11466e = i;
        this.f11467f = this.f11466e;
        this.f11463b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:            if (r2[r3] >= 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f11466e
            int r1 = r5.f11464c
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f11462a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f11466e = r3
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
            r5.f11466e = r1
            return r0
        L6b:
            long r0 = r5.zzalj()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Dh.a():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Dh.b():long");
    }

    private final int c() throws IOException {
        int i = this.f11466e;
        if (this.f11464c - i >= 4) {
            byte[] bArr = this.f11462a;
            this.f11466e = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzbrl.zzanc();
    }

    private final long d() throws IOException {
        int i = this.f11466e;
        if (this.f11464c - i >= 8) {
            byte[] bArr = this.f11462a;
            this.f11466e = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzbrl.zzanc();
    }

    private final void e() {
        this.f11464c += this.f11465d;
        int i = this.f11464c;
        int i2 = i - this.f11467f;
        int i3 = this.f11469h;
        if (i2 > i3) {
            this.f11465d = i2 - i3;
            this.f11464c = i - this.f11465d;
        } else {
            this.f11465d = 0;
        }
    }

    private final byte f() throws IOException {
        int i = this.f11466e;
        if (i != this.f11464c) {
            byte[] bArr = this.f11462a;
            this.f11466e = i + 1;
            return bArr[i];
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(d());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(c());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String readString() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f11464c;
            int i2 = this.f11466e;
            if (a2 <= i - i2) {
                String str = new String(this.f11462a, i2, a2, zzbrf.UTF_8);
                this.f11466e += a2;
                return str;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 < 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final <T extends zzbsl> T zza(zzbsw<T> zzbswVar, zzbqq zzbqqVar) throws IOException {
        int a2 = a();
        if (this.zzflq < this.zzflr) {
            int zzer = zzer(a2);
            this.zzflq++;
            T zza = zzbswVar.zza(this, zzbqqVar);
            zzeo(0);
            this.zzflq--;
            zzes(zzer);
            return zza;
        }
        throw zzbrl.zzani();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzaku() throws IOException {
        if (zzalk()) {
            this.f11468g = 0;
            return 0;
        }
        this.f11468g = a();
        int i = this.f11468g;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzbrl.zzanf();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzakv() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzakw() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzakx() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzaky() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzakz() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzala() throws IOException {
        return b() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzalb() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f11464c;
            int i2 = this.f11466e;
            if (a2 <= i - i2) {
                String b2 = Ri.b(this.f11462a, i2, a2);
                this.f11466e += a2;
                return b2;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 <= 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbpu zzalc() throws IOException {
        byte[] bArr;
        int a2 = a();
        if (a2 > 0) {
            int i = this.f11464c;
            int i2 = this.f11466e;
            if (a2 <= i - i2) {
                zzbpu zzi = zzbpu.zzi(this.f11462a, i2, a2);
                this.f11466e += a2;
                return zzi;
            }
        }
        if (a2 == 0) {
            return zzbpu.zzfli;
        }
        if (a2 > 0) {
            int i3 = this.f11464c;
            int i4 = this.f11466e;
            if (a2 <= i3 - i4) {
                this.f11466e = a2 + i4;
                bArr = Arrays.copyOfRange(this.f11462a, i4, this.f11466e);
                return zzbpu.zzs(bArr);
            }
        }
        if (a2 > 0) {
            throw zzbrl.zzanc();
        }
        if (a2 == 0) {
            bArr = zzbrf.zzfqr;
            return zzbpu.zzs(bArr);
        }
        throw zzbrl.zzand();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzald() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzale() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzalf() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzalg() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzalh() throws IOException {
        return zzbqf.zzeu(a());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzali() throws IOException {
        return zzbqf.zzax(b());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    final long zzalj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((f() & 128) == 0) {
                return j;
            }
        }
        throw zzbrl.zzane();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzalk() throws IOException {
        return this.f11466e == this.f11464c;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzall() {
        return this.f11466e - this.f11467f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzeo(int i) throws zzbrl {
        if (this.f11468g != i) {
            throw zzbrl.zzang();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzep(int i) throws IOException {
        int zzaku;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f11464c - this.f11466e >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f11462a;
                    int i4 = this.f11466e;
                    this.f11466e = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzbrl.zzane();
            }
            while (i3 < 10) {
                if (f() < 0) {
                    i3++;
                }
            }
            throw zzbrl.zzane();
            return true;
        }
        if (i2 == 1) {
            zzet(8);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzet(4);
                    return true;
                }
                throw zzbrl.zzanh();
            }
            do {
                zzaku = zzaku();
                if (zzaku == 0) {
                    break;
                }
            } while (zzep(zzaku));
            zzeo(((i >>> 3) << 3) | 4);
            return true;
        }
        zzet(a());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzer(int i) throws zzbrl {
        if (i >= 0) {
            int zzall = i + zzall();
            int i2 = this.f11469h;
            if (zzall <= i2) {
                this.f11469h = zzall;
                e();
                return i2;
            }
            throw zzbrl.zzanc();
        }
        throw zzbrl.zzand();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzes(int i) {
        this.f11469h = i;
        e();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzet(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f11464c;
            int i3 = this.f11466e;
            if (i <= i2 - i3) {
                this.f11466e = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }
}
