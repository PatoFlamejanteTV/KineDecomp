package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class UnicodeEscaper extends Escaper {
    @Override // com.google.common.escape.Escaper
    public String a(String str) {
        Preconditions.a(str);
        int length = str.length();
        int b2 = b(str, 0, length);
        return b2 == length ? str : a(str, b2);
    }

    protected abstract char[] a(int i);

    protected int b(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int a2 = a(charSequence, i, i2);
            if (a2 < 0 || a(a2) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(a2) ? 2 : 1;
        }
        return i;
    }

    public final String a(String str, int i) {
        int i2;
        int length = str.length();
        char[] a2 = e.a();
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            int a3 = a(str, i, length);
            if (a3 >= 0) {
                char[] a4 = a(a3);
                int i5 = (Character.isSupplementaryCodePoint(a3) ? 2 : 1) + i;
                if (a4 != null) {
                    int i6 = i - i3;
                    int i7 = i4 + i6;
                    int length2 = a4.length + i7;
                    if (a2.length < length2) {
                        a2 = a(a2, i4, length2 + (length - i) + 32);
                    }
                    if (i6 > 0) {
                        str.getChars(i3, i, a2, i4);
                        i4 = i7;
                    }
                    if (a4.length > 0) {
                        System.arraycopy(a4, 0, a2, i4, a4.length);
                        i4 += a4.length;
                    }
                    i3 = i5;
                }
                i = b(str, i5, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i8 = length - i3;
        if (i8 > 0) {
            i2 = i8 + i4;
            if (a2.length < i2) {
                a2 = a(a2, i4, i2);
            }
            str.getChars(i3, length, a2, i4);
        } else {
            i2 = i4;
        }
        return new String(a2, 0, i2);
    }

    protected static int a(CharSequence charSequence, int i, int i2) {
        Preconditions.a(charSequence);
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i3 - 1);
                sb.append(" in '");
                sb.append((Object) charSequence);
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            }
            if (i3 == i2) {
                return -charAt;
            }
            char charAt2 = charSequence.charAt(i3);
            if (Character.isLowSurrogate(charAt2)) {
                return Character.toCodePoint(charAt, charAt2);
            }
            throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i3 + " in '" + ((Object) charSequence) + "'");
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
