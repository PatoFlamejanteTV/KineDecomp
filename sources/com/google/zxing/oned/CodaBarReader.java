package com.google.zxing.oned;

/* loaded from: classes2.dex */
public final class CodaBarReader extends OneDReader {

    /* renamed from: a */
    static final char[] f19136a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b */
    static final int[] f19137b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c */
    private static final char[] f19138c = {'A', 'B', 'C', 'D'};

    /* renamed from: d */
    private final StringBuilder f19139d = new StringBuilder(20);

    /* renamed from: e */
    private int[] f19140e = new int[80];

    /* renamed from: f */
    private int f19141f = 0;

    public static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
