package com.fasterxml.jackson.core.io;

import java.util.Arrays;

/* compiled from: CharTypes.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f433a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    private static final char[] h = "0123456789ABCDEF".toCharArray();
    private static final byte[] i;

    static {
        int i2;
        int length = h.length;
        i = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            i[i3] = (byte) h[i3];
        }
        int[] iArr = new int[256];
        for (int i4 = 0; i4 < 32; i4++) {
            iArr[i4] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f433a = iArr;
        int[] iArr2 = new int[f433a.length];
        System.arraycopy(f433a, 0, iArr2, 0, f433a.length);
        for (int i5 = 128; i5 < 256; i5++) {
            if ((i5 & 224) == 192) {
                i2 = 2;
            } else if ((i5 & 240) == 224) {
                i2 = 3;
            } else {
                i2 = (i5 & 248) == 240 ? 4 : -1;
            }
            iArr2[i5] = i2;
        }
        b = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i6 = 33; i6 < 256; i6++) {
            if (Character.isJavaIdentifierPart((char) i6)) {
                iArr3[i6] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        c = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(c, 0, iArr4, 0, c.length);
        Arrays.fill(iArr4, 128, 128, 0);
        d = iArr4;
        e = new int[256];
        System.arraycopy(b, 128, e, 128, 128);
        Arrays.fill(e, 0, 32, -1);
        e[9] = 0;
        e[10] = 10;
        e[13] = 13;
        e[42] = 42;
        int[] iArr5 = new int[128];
        for (int i7 = 0; i7 < 32; i7++) {
            iArr5[i7] = -1;
        }
        iArr5[34] = 34;
        iArr5[92] = 92;
        iArr5[8] = 98;
        iArr5[9] = 116;
        iArr5[12] = 102;
        iArr5[10] = 110;
        iArr5[13] = 114;
        f = iArr5;
        g = new int[128];
        Arrays.fill(g, -1);
        for (int i8 = 0; i8 < 10; i8++) {
            g[i8 + 48] = i8;
        }
        for (int i9 = 0; i9 < 6; i9++) {
            g[i9 + 97] = i9 + 10;
            g[i9 + 65] = i9 + 10;
        }
    }

    public static int[] a() {
        return f433a;
    }

    public static int[] b() {
        return b;
    }

    public static int[] c() {
        return c;
    }

    public static int[] d() {
        return d;
    }

    public static int[] e() {
        return e;
    }

    public static int[] f() {
        return f;
    }

    public static int a(int i2) {
        if (i2 > 127) {
            return -1;
        }
        return g[i2];
    }

    public static void a(StringBuilder sb, String str) {
        int[] iArr = f;
        int length = iArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= length || iArr[charAt] == 0) {
                sb.append(charAt);
            } else {
                sb.append('\\');
                int i3 = iArr[charAt];
                if (i3 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    int i4 = -(i3 + 1);
                    sb.append(h[i4 >> 4]);
                    sb.append(h[i4 & 15]);
                } else {
                    sb.append((char) i3);
                }
            }
        }
    }

    public static char[] g() {
        return (char[]) h.clone();
    }

    public static byte[] h() {
        return (byte[]) i.clone();
    }
}
