package com.google.android.gms.internal.ads;

import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.th, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1097th {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, C1111uh c1111uh) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 >= 0) {
            c1111uh.f12581a = b2;
            return i2;
        }
        return a(b2, bArr, i2, c1111uh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, C1111uh c1111uh) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c1111uh.f12582b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        c1111uh.f12582b = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, C1111uh c1111uh) throws zzbrl {
        int a2 = a(bArr, i, c1111uh);
        int i2 = c1111uh.f12581a;
        if (i2 >= 0) {
            if (i2 > bArr.length - a2) {
                throw zzbrl.zzanc();
            }
            if (i2 == 0) {
                c1111uh.f12583c = zzbpu.zzfli;
                return a2;
            }
            c1111uh.f12583c = zzbpu.zzi(bArr, a2, i2);
            return a2 + i2;
        }
        throw zzbrl.zzand();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i, C1111uh c1111uh) throws zzbrl {
        int a2 = a(bArr, i, c1111uh);
        int i2 = c1111uh.f12581a;
        if (i2 < 0) {
            throw zzbrl.zzand();
        }
        if (i2 == 0) {
            c1111uh.f12583c = "";
            return a2;
        }
        c1111uh.f12583c = new String(bArr, a2, i2, zzbrf.UTF_8);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, C1111uh c1111uh) throws zzbrl {
        int a2 = a(bArr, i, c1111uh);
        int i2 = c1111uh.f12581a;
        if (i2 < 0) {
            throw zzbrl.zzand();
        }
        if (i2 == 0) {
            c1111uh.f12583c = "";
            return a2;
        }
        c1111uh.f12583c = Ri.b(bArr, a2, i2);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, C1111uh c1111uh) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            c1111uh.f12581a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            c1111uh.f12581a = i5 | (b3 << ap.l);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            c1111uh.f12581a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            c1111uh.f12581a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c1111uh.f12581a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzbrk<?> zzbrkVar, C1111uh c1111uh) {
        Sh sh = (Sh) zzbrkVar;
        int a2 = a(bArr, i2, c1111uh);
        sh.a(c1111uh.f12581a);
        while (a2 < i3) {
            int a3 = a(bArr, a2, c1111uh);
            if (i != c1111uh.f12581a) {
                break;
            }
            a2 = a(bArr, a3, c1111uh);
            sh.a(c1111uh.f12581a);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzbrk<?> zzbrkVar, C1111uh c1111uh) throws IOException {
        Sh sh = (Sh) zzbrkVar;
        int a2 = a(bArr, i, c1111uh);
        int i2 = c1111uh.f12581a + a2;
        while (a2 < i2) {
            a2 = a(bArr, a2, c1111uh);
            sh.a(c1111uh.f12581a);
        }
        if (a2 == i2) {
            return a2;
        }
        throw zzbrl.zzanc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzbtv zzbtvVar, C1111uh c1111uh) throws zzbrl {
        if ((i >>> 3) == 0) {
            throw zzbrl.zzanf();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int b2 = b(bArr, i2, c1111uh);
            zzbtvVar.zzc(i, Long.valueOf(c1111uh.f12582b));
            return b2;
        }
        if (i4 == 1) {
            zzbtvVar.zzc(i, Long.valueOf(b(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int a2 = a(bArr, i2, c1111uh);
            int i5 = c1111uh.f12581a;
            if (i5 >= 0) {
                if (i5 > bArr.length - a2) {
                    throw zzbrl.zzanc();
                }
                if (i5 == 0) {
                    zzbtvVar.zzc(i, zzbpu.zzfli);
                } else {
                    zzbtvVar.zzc(i, zzbpu.zzi(bArr, a2, i5));
                }
                return a2 + i5;
            }
            throw zzbrl.zzand();
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzbtvVar.zzc(i, Integer.valueOf(a(bArr, i2)));
                return i2 + 4;
            }
            throw zzbrl.zzanf();
        }
        zzbtv zzapa = zzbtv.zzapa();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int a3 = a(bArr, i2, c1111uh);
            int i8 = c1111uh.f12581a;
            if (i8 == i6) {
                i7 = i8;
                i2 = a3;
                break;
            }
            i7 = i8;
            i2 = a(i8, bArr, a3, i3, zzapa, c1111uh);
        }
        if (i2 <= i3 && i7 == i6) {
            zzbtvVar.zzc(i, zzapa);
            return i2;
        }
        throw zzbrl.zzanj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, C1111uh c1111uh) throws zzbrl {
        if ((i >>> 3) == 0) {
            throw zzbrl.zzanf();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return b(bArr, i2, c1111uh);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return a(bArr, i2, c1111uh) + c1111uh.f12581a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzbrl.zzanf();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = a(bArr, i2, c1111uh);
            i6 = c1111uh.f12581a;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, c1111uh);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzbrl.zzanj();
        }
        return i2;
    }
}
