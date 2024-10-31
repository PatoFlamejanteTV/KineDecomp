package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1266o extends zzet {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f13046a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13047b;

    /* renamed from: c, reason: collision with root package name */
    private int f13048c;

    /* renamed from: d, reason: collision with root package name */
    private int f13049d;

    /* renamed from: e, reason: collision with root package name */
    private int f13050e;

    /* renamed from: f, reason: collision with root package name */
    private int f13051f;

    /* renamed from: g, reason: collision with root package name */
    private int f13052g;

    /* renamed from: h, reason: collision with root package name */
    private int f13053h;

    private C1266o(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f13053h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f13046a = bArr;
        this.f13048c = i2 + i;
        this.f13050e = i;
        this.f13051f = this.f13050e;
        this.f13047b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:            if (r2[r3] >= 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13050e
            int r1 = r5.f13048c
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f13046a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f13050e = r3
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
            r5.f13050e = r1
            return r0
        L6b:
            long r0 = r5.zzfx()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.C1266o.a():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.C1266o.b():long");
    }

    private final int c() throws IOException {
        int i = this.f13050e;
        if (this.f13048c - i >= 4) {
            byte[] bArr = this.f13046a;
            this.f13050e = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzgc.zzhq();
    }

    private final long d() throws IOException {
        int i = this.f13050e;
        if (this.f13048c - i >= 8) {
            byte[] bArr = this.f13046a;
            this.f13050e = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzgc.zzhq();
    }

    private final void e() {
        this.f13048c += this.f13049d;
        int i = this.f13048c;
        int i2 = i - this.f13051f;
        int i3 = this.f13053h;
        if (i2 > i3) {
            this.f13049d = i2 - i3;
            this.f13048c = i - this.f13049d;
        } else {
            this.f13049d = 0;
        }
    }

    private final byte f() throws IOException {
        int i = this.f13050e;
        if (i != this.f13048c) {
            byte[] bArr = this.f13046a;
            this.f13050e = i + 1;
            return bArr[i];
        }
        throw zzgc.zzhq();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(d());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(c());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final String readString() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13048c;
            int i2 = this.f13050e;
            if (a2 <= i - i2) {
                String str = new String(this.f13046a, i2, a2, zzfv.UTF_8);
                this.f13050e += a2;
                return str;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 < 0) {
            throw zzgc.zzhr();
        }
        throw zzgc.zzhq();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfi() throws IOException {
        if (zzfy()) {
            this.f13052g = 0;
            return 0;
        }
        this.f13052g = a();
        int i = this.f13052g;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzgc.zzht();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final long zzfj() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final long zzfk() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfl() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final long zzfm() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfn() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final boolean zzfo() throws IOException {
        return b() != 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final String zzfp() throws IOException {
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13048c;
            int i2 = this.f13050e;
            if (a2 <= i - i2) {
                String b2 = La.b(this.f13046a, i2, a2);
                this.f13050e += a2;
                return b2;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 <= 0) {
            throw zzgc.zzhr();
        }
        throw zzgc.zzhq();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final zzeh zzfq() throws IOException {
        byte[] bArr;
        int a2 = a();
        if (a2 > 0) {
            int i = this.f13048c;
            int i2 = this.f13050e;
            if (a2 <= i - i2) {
                zzeh zzb = zzeh.zzb(this.f13046a, i2, a2);
                this.f13050e += a2;
                return zzb;
            }
        }
        if (a2 == 0) {
            return zzeh.zzso;
        }
        if (a2 > 0) {
            int i3 = this.f13048c;
            int i4 = this.f13050e;
            if (a2 <= i3 - i4) {
                this.f13050e = a2 + i4;
                bArr = Arrays.copyOfRange(this.f13046a, i4, this.f13050e);
                return zzeh.zza(bArr);
            }
        }
        if (a2 > 0) {
            throw zzgc.zzhq();
        }
        if (a2 == 0) {
            bArr = zzfv.EMPTY_BYTE_ARRAY;
            return zzeh.zza(bArr);
        }
        throw zzgc.zzhr();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfr() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfs() throws IOException {
        return a();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzft() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final long zzfu() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfv() throws IOException {
        return zzet.zzr(a());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final long zzfw() throws IOException {
        return zzet.zza(b());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    final long zzfx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((f() & 128) == 0) {
                return j;
            }
        }
        throw zzgc.zzhs();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final boolean zzfy() throws IOException {
        return this.f13050e == this.f13048c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfz() {
        return this.f13050e - this.f13051f;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final void zzn(int i) throws zzgc {
        if (this.f13052g != i) {
            throw zzgc.zzhu();
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final boolean zzo(int i) throws IOException {
        int zzfi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f13048c - this.f13050e >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f13046a;
                    int i4 = this.f13050e;
                    this.f13050e = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzgc.zzhs();
            }
            while (i3 < 10) {
                if (f() < 0) {
                    i3++;
                }
            }
            throw zzgc.zzhs();
            return true;
        }
        if (i2 == 1) {
            a(8);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    a(4);
                    return true;
                }
                throw zzgc.zzhv();
            }
            do {
                zzfi = zzfi();
                if (zzfi == 0) {
                    break;
                }
            } while (zzo(zzfi));
            zzn(((i >>> 3) << 3) | 4);
            return true;
        }
        a(a());
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzp(int i) throws zzgc {
        if (i >= 0) {
            int zzfz = i + zzfz();
            int i2 = this.f13053h;
            if (zzfz <= i2) {
                this.f13053h = zzfz;
                e();
                return i2;
            }
            throw zzgc.zzhq();
        }
        throw zzgc.zzhr();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final void zzq(int i) {
        this.f13053h = i;
        e();
    }

    private final void a(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f13048c;
            int i3 = this.f13050e;
            if (i <= i2 - i3) {
                this.f13050e = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzgc.zzhr();
        }
        throw zzgc.zzhq();
    }
}
