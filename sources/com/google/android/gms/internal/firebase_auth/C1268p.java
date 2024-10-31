package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1268p extends zzet {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f13058a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f13059b;

    /* renamed from: c, reason: collision with root package name */
    private int f13060c;

    /* renamed from: d, reason: collision with root package name */
    private int f13061d;

    /* renamed from: e, reason: collision with root package name */
    private int f13062e;

    /* renamed from: f, reason: collision with root package name */
    private int f13063f;

    /* renamed from: g, reason: collision with root package name */
    private int f13064g;

    /* renamed from: h, reason: collision with root package name */
    private int f13065h;
    private InterfaceC1270q i;

    private C1268p(InputStream inputStream, int i) {
        super();
        this.f13065h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = null;
        zzfv.zza(inputStream, "input");
        this.f13058a = inputStream;
        this.f13059b = new byte[i];
        this.f13060c = 0;
        this.f13062e = 0;
        this.f13064g = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:            if (r2[r3] >= 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13062e
            int r1 = r5.f13060c
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f13059b
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f13062e = r3
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
            r5.f13062e = r1
            return r0
        L6b:
            long r0 = r5.zzfx()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.C1268p.a():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.C1268p.b():long");
    }

    private final int c() throws IOException {
        int i = this.f13062e;
        if (this.f13060c - i < 4) {
            b(4);
            i = this.f13062e;
        }
        byte[] bArr = this.f13059b;
        this.f13062e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long d() throws IOException {
        int i = this.f13062e;
        if (this.f13060c - i < 8) {
            b(8);
            i = this.f13062e;
        }
        byte[] bArr = this.f13059b;
        this.f13062e = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final void e() {
        this.f13060c += this.f13061d;
        int i = this.f13064g;
        int i2 = this.f13060c;
        int i3 = i + i2;
        int i4 = this.f13065h;
        if (i3 > i4) {
            this.f13061d = i3 - i4;
            this.f13060c = i2 - this.f13061d;
        } else {
            this.f13061d = 0;
        }
    }

    private final byte f() throws IOException {
        if (this.f13062e == this.f13060c) {
            b(1);
        }
        byte[] bArr = this.f13059b;
        int i = this.f13062e;
        this.f13062e = i + 1;
        return bArr[i];
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
            int i = this.f13060c;
            int i2 = this.f13062e;
            if (a2 <= i - i2) {
                String str = new String(this.f13059b, i2, a2, zzfv.UTF_8);
                this.f13062e += a2;
                return str;
            }
        }
        if (a2 == 0) {
            return "";
        }
        if (a2 <= this.f13060c) {
            b(a2);
            String str2 = new String(this.f13059b, this.f13062e, a2, zzfv.UTF_8);
            this.f13062e += a2;
            return str2;
        }
        return new String(d(a2), zzfv.UTF_8);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfi() throws IOException {
        if (zzfy()) {
            this.f13063f = 0;
            return 0;
        }
        this.f13063f = a();
        int i = this.f13063f;
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
        byte[] d2;
        int a2 = a();
        int i = this.f13062e;
        int i2 = 0;
        if (a2 <= this.f13060c - i && a2 > 0) {
            d2 = this.f13059b;
            this.f13062e = i + a2;
            i2 = i;
        } else {
            if (a2 == 0) {
                return "";
            }
            if (a2 <= this.f13060c) {
                b(a2);
                d2 = this.f13059b;
                this.f13062e = a2;
            } else {
                d2 = d(a2);
            }
        }
        return La.b(d2, i2, a2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final zzeh zzfq() throws IOException {
        int a2 = a();
        int i = this.f13060c;
        int i2 = this.f13062e;
        if (a2 <= i - i2 && a2 > 0) {
            zzeh zzb = zzeh.zzb(this.f13059b, i2, a2);
            this.f13062e += a2;
            return zzb;
        }
        if (a2 == 0) {
            return zzeh.zzso;
        }
        byte[] e2 = e(a2);
        if (e2 != null) {
            return zzeh.zza(e2);
        }
        int i3 = this.f13062e;
        int i4 = this.f13060c;
        int i5 = i4 - i3;
        this.f13064g += i4;
        this.f13062e = 0;
        this.f13060c = 0;
        List<byte[]> f2 = f(a2 - i5);
        ArrayList arrayList = new ArrayList(f2.size() + 1);
        arrayList.add(zzeh.zzb(this.f13059b, i3, i5));
        Iterator<byte[]> it = f2.iterator();
        while (it.hasNext()) {
            arrayList.add(zzeh.zza(it.next()));
        }
        return zzeh.zze(arrayList);
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
        return this.f13062e == this.f13060c && !c(1);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final int zzfz() {
        return this.f13064g + this.f13062e;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final void zzn(int i) throws zzgc {
        if (this.f13063f != i) {
            throw zzgc.zzhu();
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final boolean zzo(int i) throws IOException {
        int zzfi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f13060c - this.f13062e >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f13059b;
                    int i4 = this.f13062e;
                    this.f13062e = i4 + 1;
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
            int i2 = i + this.f13064g + this.f13062e;
            int i3 = this.f13065h;
            if (i2 <= i3) {
                this.f13065h = i2;
                e();
                return i3;
            }
            throw zzgc.zzhq();
        }
        throw zzgc.zzhr();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzet
    public final void zzq(int i) {
        this.f13065h = i;
        e();
    }

    private final List<byte[]> f(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.f13058a.read(bArr, i2, bArr.length - i2);
                if (read != -1) {
                    this.f13064g += read;
                    i2 += read;
                } else {
                    throw zzgc.zzhq();
                }
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final byte[] e(int i) throws IOException {
        if (i == 0) {
            return zzfv.EMPTY_BYTE_ARRAY;
        }
        if (i >= 0) {
            int i2 = this.f13064g;
            int i3 = this.f13062e;
            int i4 = i2 + i3 + i;
            if (i4 - this.zzsz <= 0) {
                int i5 = this.f13065h;
                if (i4 <= i5) {
                    int i6 = this.f13060c - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.f13058a.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f13059b, this.f13062e, bArr, 0, i6);
                    this.f13064g += this.f13060c;
                    this.f13062e = 0;
                    this.f13060c = 0;
                    while (i6 < bArr.length) {
                        int read = this.f13058a.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.f13064g += read;
                            i6 += read;
                        } else {
                            throw zzgc.zzhq();
                        }
                    }
                    return bArr;
                }
                a((i5 - i2) - i3);
                throw zzgc.zzhq();
            }
            throw zzgc.zzhw();
        }
        throw zzgc.zzhr();
    }

    private final boolean c(int i) throws IOException {
        do {
            int i2 = this.f13062e;
            int i3 = i2 + i;
            int i4 = this.f13060c;
            if (i3 > i4) {
                int i5 = this.zzsz;
                int i6 = this.f13064g;
                if (i > (i5 - i6) - i2 || i6 + i2 + i > this.f13065h) {
                    return false;
                }
                if (i2 > 0) {
                    if (i4 > i2) {
                        byte[] bArr = this.f13059b;
                        System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                    }
                    this.f13064g += i2;
                    this.f13060c -= i2;
                    this.f13062e = 0;
                }
                InputStream inputStream = this.f13058a;
                byte[] bArr2 = this.f13059b;
                int i7 = this.f13060c;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zzsz - this.f13064g) - i7));
                if (read == 0 || read < -1 || read > this.f13059b.length) {
                    String valueOf = String.valueOf(this.f13058a.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                }
                if (read <= 0) {
                    return false;
                }
                this.f13060c += read;
                e();
            } else {
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("refillBuffer() called when ");
                sb2.append(i);
                sb2.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb2.toString());
            }
        } while (this.f13060c < i);
        return true;
    }

    private final byte[] d(int i) throws IOException {
        byte[] e2 = e(i);
        if (e2 != null) {
            return e2;
        }
        int i2 = this.f13062e;
        int i3 = this.f13060c;
        int i4 = i3 - i2;
        this.f13064g += i3;
        this.f13062e = 0;
        this.f13060c = 0;
        List<byte[]> f2 = f(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f13059b, i2, bArr, 0, i4);
        for (byte[] bArr2 : f2) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final void a(int i) throws IOException {
        int i2 = this.f13060c;
        int i3 = this.f13062e;
        if (i <= i2 - i3 && i >= 0) {
            this.f13062e = i3 + i;
            return;
        }
        if (i >= 0) {
            int i4 = this.f13064g;
            int i5 = this.f13062e;
            int i6 = i4 + i5 + i;
            int i7 = this.f13065h;
            if (i6 <= i7) {
                this.f13064g = i4 + i5;
                int i8 = this.f13060c - i5;
                this.f13060c = 0;
                this.f13062e = 0;
                while (i8 < i) {
                    try {
                        long j = i - i8;
                        long skip = this.f13058a.skip(j);
                        if (skip < 0 || skip > j) {
                            String valueOf = String.valueOf(this.f13058a.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                        i8 += (int) skip;
                    } finally {
                        this.f13064g += i8;
                        e();
                    }
                }
                return;
            }
            a((i7 - i4) - i5);
            throw zzgc.zzhq();
        }
        throw zzgc.zzhr();
    }

    private final void b(int i) throws IOException {
        if (c(i)) {
            return;
        }
        if (i > (this.zzsz - this.f13064g) - this.f13062e) {
            throw zzgc.zzhw();
        }
        throw zzgc.zzhq();
    }
}
