package com.google.android.gms.internal.clearcut;

import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1213n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, C1215o c1215o) throws zzco {
        if ((i >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return b(bArr, i2, c1215o);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return a(bArr, i2, c1215o) + c1215o.f12869a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzco.zzbm();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = a(bArr, i2, c1215o);
            i6 = c1215o.f12869a;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, c1215o);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzco.zzbo();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzcn<?> zzcnVar, C1215o c1215o) {
        K k = (K) zzcnVar;
        int a2 = a(bArr, i2, c1215o);
        while (true) {
            k.a(c1215o.f12869a);
            if (a2 >= i3) {
                break;
            }
            int a3 = a(bArr, a2, c1215o);
            if (i != c1215o.f12869a) {
                break;
            }
            a2 = a(bArr, a3, c1215o);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, zzey zzeyVar, C1215o c1215o) throws IOException {
        if ((i >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int b2 = b(bArr, i2, c1215o);
            zzeyVar.zzb(i, Long.valueOf(c1215o.f12870b));
            return b2;
        }
        if (i4 == 1) {
            zzeyVar.zzb(i, Long.valueOf(b(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int a2 = a(bArr, i2, c1215o);
            int i5 = c1215o.f12869a;
            zzeyVar.zzb(i, i5 == 0 ? zzbb.zzfi : zzbb.zzb(bArr, a2, i5));
            return a2 + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzco.zzbm();
            }
            zzeyVar.zzb(i, Integer.valueOf(a(bArr, i2)));
            return i2 + 4;
        }
        zzey zzeb = zzey.zzeb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int a3 = a(bArr, i2, c1215o);
            int i8 = c1215o.f12869a;
            if (i8 == i6) {
                i7 = i8;
                i2 = a3;
                break;
            }
            i7 = i8;
            i2 = a(i8, bArr, a3, i3, zzeb, c1215o);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzco.zzbo();
        }
        zzeyVar.zzb(i, zzeb);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, C1215o c1215o) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i3 = b3 << ap.l;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i3 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                c1215o.f12869a = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            c1215o.f12869a = i7 | i3;
            return i8;
        }
        i4 = b2 << 7;
        c1215o.f12869a = i5 | i4;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, C1215o c1215o) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return a(b2, bArr, i2, c1215o);
        }
        c1215o.f12869a = b2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, zzcn<?> zzcnVar, C1215o c1215o) throws IOException {
        K k = (K) zzcnVar;
        int a2 = a(bArr, i, c1215o);
        int i2 = c1215o.f12869a + a2;
        while (a2 < i2) {
            a2 = a(bArr, a2, c1215o);
            k.a(c1215o.f12869a);
        }
        if (a2 == i2) {
            return a2;
        }
        throw zzco.zzbl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, C1215o c1215o) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c1215o.f12870b = j;
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
        c1215o.f12870b = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i, C1215o c1215o) {
        int a2 = a(bArr, i, c1215o);
        int i2 = c1215o.f12869a;
        if (i2 == 0) {
            c1215o.f12871c = "";
            return a2;
        }
        c1215o.f12871c = new String(bArr, a2, i2, zzci.UTF_8);
        return a2 + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, C1215o c1215o) throws IOException {
        int a2 = a(bArr, i, c1215o);
        int i2 = c1215o.f12869a;
        if (i2 == 0) {
            c1215o.f12871c = "";
            return a2;
        }
        int i3 = a2 + i2;
        if (!Na.a(bArr, a2, i3)) {
            throw zzco.zzbp();
        }
        c1215o.f12871c = new String(bArr, a2, i2, zzci.UTF_8);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, C1215o c1215o) {
        int a2 = a(bArr, i, c1215o);
        int i2 = c1215o.f12869a;
        if (i2 == 0) {
            c1215o.f12871c = zzbb.zzfi;
            return a2;
        }
        c1215o.f12871c = zzbb.zzb(bArr, a2, i2);
        return a2 + i2;
    }
}
