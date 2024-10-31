package com.fasterxml.jackson.core.io;

import java.util.Arrays;

/* compiled from: CharTypes.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final char[] f9747a = "0123456789ABCDEF".toCharArray();

    /* renamed from: b */
    private static final byte[] f9748b;

    /* renamed from: c */
    private static final int[] f9749c;

    /* renamed from: d */
    private static final int[] f9750d;

    /* renamed from: e */
    private static final int[] f9751e;

    /* renamed from: f */
    private static final int[] f9752f;

    /* renamed from: g */
    private static final int[] f9753g;

    /* renamed from: h */
    private static final int[] f9754h;
    private static final int[] i;
    private static final int[] j;

    static {
        int length = f9747a.length;
        f9748b = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            f9748b[i2] = (byte) f9747a[i2];
        }
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr[i3] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f9749c = iArr;
        int[] iArr2 = f9749c;
        int[] iArr3 = new int[iArr2.length];
        System.arraycopy(iArr2, 0, iArr3, 0, iArr3.length);
        for (int i4 = 128; i4 < 256; i4++) {
            iArr3[i4] = (i4 & 224) == 192 ? 2 : (i4 & 240) == 224 ? 3 : (i4 & 248) == 240 ? 4 : -1;
        }
        f9750d = iArr3;
        int[] iArr4 = new int[256];
        Arrays.fill(iArr4, -1);
        for (int i5 = 33; i5 < 256; i5++) {
            if (Character.isJavaIdentifierPart((char) i5)) {
                iArr4[i5] = 0;
            }
        }
        iArr4[64] = 0;
        iArr4[35] = 0;
        iArr4[42] = 0;
        iArr4[45] = 0;
        iArr4[43] = 0;
        f9751e = iArr4;
        int[] iArr5 = new int[256];
        System.arraycopy(f9751e, 0, iArr5, 0, iArr5.length);
        Arrays.fill(iArr5, 128, 128, 0);
        f9752f = iArr5;
        int[] iArr6 = new int[256];
        System.arraycopy(f9750d, 128, iArr6, 128, 128);
        Arrays.fill(iArr6, 0, 32, -1);
        iArr6[9] = 0;
        iArr6[10] = 10;
        iArr6[13] = 13;
        iArr6[42] = 42;
        f9753g = iArr6;
        int[] iArr7 = new int[256];
        System.arraycopy(f9750d, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        f9754h = iArr7;
        int[] iArr8 = new int[128];
        for (int i6 = 0; i6 < 32; i6++) {
            iArr8[i6] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        i = iArr8;
        j = new int[128];
        Arrays.fill(j, -1);
        for (int i7 = 0; i7 < 10; i7++) {
            j[i7 + 48] = i7;
        }
        for (int i8 = 0; i8 < 6; i8++) {
            int[] iArr9 = j;
            int i9 = i8 + 10;
            iArr9[i8 + 97] = i9;
            iArr9[i8 + 65] = i9;
        }
    }

    public static int a(int i2) {
        if (i2 > 127) {
            return -1;
        }
        return j[i2];
    }

    public static char[] b() {
        return (char[]) f9747a.clone();
    }

    public static int[] c() {
        return i;
    }

    public static int[] d() {
        return f9753g;
    }

    public static int[] e() {
        return f9749c;
    }

    public static int[] f() {
        return f9751e;
    }

    public static int[] g() {
        return f9750d;
    }

    public static int[] h() {
        return f9752f;
    }

    public static void a(StringBuilder sb, String str) {
        int[] iArr = i;
        int length = iArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < length && iArr[charAt] != 0) {
                sb.append('\\');
                int i3 = iArr[charAt];
                if (i3 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    sb.append(f9747a[charAt >> 4]);
                    sb.append(f9747a[charAt & 15]);
                } else {
                    sb.append((char) i3);
                }
            } else {
                sb.append(charAt);
            }
        }
    }

    public static byte[] a() {
        return (byte[]) f9748b.clone();
    }
}
