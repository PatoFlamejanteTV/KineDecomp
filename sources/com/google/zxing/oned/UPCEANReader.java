package com.google.zxing.oned;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public abstract class UPCEANReader extends OneDReader {

    /* renamed from: a */
    static final int[] f19166a = {1, 1, 1};

    /* renamed from: b */
    static final int[] f19167b = {1, 1, 1, 1, 1};

    /* renamed from: c */
    static final int[] f19168c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d */
    static final int[][] f19169d = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: e */
    static final int[][] f19170e = new int[20];

    /* renamed from: f */
    private final StringBuilder f19171f = new StringBuilder(20);

    /* renamed from: g */
    private final d f19172g = new d();

    /* renamed from: h */
    private final a f19173h = new a();

    static {
        System.arraycopy(f19169d, 0, f19170e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f19169d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f19170e[i] = iArr2;
        }
    }

    public static boolean a(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += charAt2;
        }
        return i3 % 10 == 0;
    }
}
