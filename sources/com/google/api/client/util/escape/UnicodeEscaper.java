package com.google.api.client.util.escape;

/* loaded from: classes.dex */
public abstract class UnicodeEscaper extends Escaper {
    protected abstract int a(CharSequence charSequence, int i, int i2);

    protected abstract char[] a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(String str, int i) {
        int i2;
        int i3;
        int length = str.length();
        char[] a2 = a.a();
        int i4 = 0;
        int i5 = 0;
        while (i < length) {
            int b = b(str, i, length);
            if (b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] a3 = a(b);
            int i6 = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i;
            if (a3 != null) {
                int i7 = i - i4;
                int length2 = i5 + i7 + a3.length;
                if (a2.length < length2) {
                    a2 = a(a2, i5, ((length2 + length) - i) + 32);
                }
                if (i7 > 0) {
                    str.getChars(i4, i, a2, i5);
                    i5 += i7;
                }
                if (a3.length > 0) {
                    System.arraycopy(a3, 0, a2, i5, a3.length);
                    i5 += a3.length;
                }
                i2 = i5;
                i3 = i6;
            } else {
                int i8 = i4;
                i2 = i5;
                i3 = i8;
            }
            i = a(str, i6, length);
            int i9 = i3;
            i5 = i2;
            i4 = i9;
        }
        int i10 = length - i4;
        if (i10 > 0) {
            int i11 = i10 + i5;
            if (a2.length < i11) {
                a2 = a(a2, i5, i11);
            }
            str.getChars(i4, length, a2, i5);
            i5 = i11;
        }
        return new String(a2, 0, i5);
    }

    protected static int b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt >= 55296 && charAt <= 57343) {
                if (charAt <= 56319) {
                    if (i3 == i2) {
                        return -charAt;
                    }
                    char charAt2 = charSequence.charAt(i3);
                    if (Character.isLowSurrogate(charAt2)) {
                        return Character.toCodePoint(charAt, charAt2);
                    }
                    throw new IllegalArgumentException(new StringBuilder(83).append("Expected low surrogate but got char '").append(charAt2).append("' with value ").append((int) charAt2).append(" at index ").append(i3).toString());
                }
                throw new IllegalArgumentException(new StringBuilder(82).append("Unexpected low surrogate character '").append(charAt).append("' with value ").append((int) charAt).append(" at index ").append(i3 - 1).toString());
            }
            return charAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] a(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
