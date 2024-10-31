package com.mixpanel.android.util;

/* compiled from: Base64Coder.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f3074a = new char[64];
    private static byte[] b;

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f3074a[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f3074a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f3074a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        int i2 = i + 1;
        f3074a[i] = '+';
        int i3 = i2 + 1;
        f3074a[i2] = '/';
        b = new byte[128];
        for (int i4 = 0; i4 < b.length; i4++) {
            b[i4] = -1;
        }
        for (int i5 = 0; i5 < 64; i5++) {
            b[f3074a[i5]] = (byte) i5;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static char[] a(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4 = ((i * 4) + 2) / 3;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i5 = 0;
        int i6 = 0;
        while (i6 < i) {
            int i7 = i6 + 1;
            int i8 = bArr[i6] & 255;
            if (i7 < i) {
                i2 = bArr[i7] & 255;
                i7++;
            } else {
                i2 = 0;
            }
            if (i7 < i) {
                i6 = i7 + 1;
                i3 = bArr[i7] & 255;
            } else {
                i6 = i7;
                i3 = 0;
            }
            int i9 = i8 >>> 2;
            int i10 = ((i8 & 3) << 4) | (i2 >>> 4);
            int i11 = ((i2 & 15) << 2) | (i3 >>> 6);
            int i12 = i3 & 63;
            int i13 = i5 + 1;
            cArr[i5] = f3074a[i9];
            int i14 = i13 + 1;
            cArr[i13] = f3074a[i10];
            cArr[i14] = i14 < i4 ? f3074a[i11] : '=';
            int i15 = i14 + 1;
            cArr[i15] = i15 < i4 ? f3074a[i12] : '=';
            i5 = i15 + 1;
        }
        return cArr;
    }
}
