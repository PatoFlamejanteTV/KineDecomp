package com.google.zxing.oned;

/* loaded from: classes2.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {

    /* renamed from: a */
    private static final char[] f19142a = {'A', 'B', 'C', 'D'};

    /* renamed from: b */
    private static final char[] f19143b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f19144c = {'/', ':', '+', '.'};

    /* renamed from: d */
    private static final char f19145d = f19142a[0];

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] a(String str) {
        int i;
        if (str.length() < 2) {
            str = f19145d + str + f19145d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a2 = CodaBarReader.a(f19142a, upperCase);
            boolean a3 = CodaBarReader.a(f19142a, upperCase2);
            boolean a4 = CodaBarReader.a(f19143b, upperCase);
            boolean a5 = CodaBarReader.a(f19143b, upperCase2);
            if (a2) {
                if (!a3) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a4) {
                if (!a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else {
                if (a3 || a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                str = f19145d + str + f19145d;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else {
                if (!CodaBarReader.a(f19144c, str.charAt(i3))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                }
                i2 += 10;
            }
        }
        boolean[] zArr = new boolean[i2 + (str.length() - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr = CodaBarReader.f19136a;
                if (i6 >= cArr.length) {
                    i = 0;
                    break;
                }
                if (upperCase3 == cArr[i6]) {
                    i = CodaBarReader.f19137b[i6];
                    break;
                }
                i6++;
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i7] = z;
                    i7++;
                    if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
