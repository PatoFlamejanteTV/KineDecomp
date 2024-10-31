package org.apache.commons.io;

import java.io.File;

/* compiled from: FilenameUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public static final String f29315a = Character.toString('.');

    /* renamed from: b */
    private static final char f29316b = File.separatorChar;

    /* renamed from: c */
    private static final char f29317c;

    static {
        if (a()) {
            f29317c = '/';
        } else {
            f29317c = '\\';
        }
    }

    public static boolean a() {
        return f29316b == '\\';
    }

    private static boolean a(char c2) {
        return c2 == '/' || c2 == '\\';
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        int h2 = h(str);
        return h2 == -1 ? "" : str.substring(h2 + 1);
    }

    public static String c(String str) {
        return a(str, true);
    }

    public static String d(String str) {
        return a(str, false);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(i(str) + 1);
    }

    public static String f(String str) {
        int g2;
        if (str == null || (g2 = g(str)) < 0) {
            return null;
        }
        if (g2 > str.length()) {
            return str + '/';
        }
        return str.substring(0, g2);
    }

    public static int g(String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return a(charAt) ? 1 : 0;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            min = Math.min(indexOf, indexOf2);
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                return (length == 2 || !a(str.charAt(2))) ? 2 : 3;
            }
            if (!a(charAt) || !a(charAt2)) {
                return a(charAt) ? 1 : 0;
            }
            int indexOf3 = str.indexOf(47, 2);
            int indexOf4 = str.indexOf(92, 2);
            if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                return -1;
            }
            if (indexOf3 == -1) {
                indexOf3 = indexOf4;
            }
            if (indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            min = Math.min(indexOf3, indexOf4);
        }
        return min + 1;
    }

    public static int h(String str) {
        int lastIndexOf;
        if (str != null && i(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int i(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static String j(String str) {
        return a(str, f29316b, true);
    }

    public static String k(String str) {
        return a(str, f29316b, false);
    }

    public static String l(String str) {
        if (str == null) {
            return null;
        }
        int h2 = h(str);
        return h2 == -1 ? str : str.substring(0, h2);
    }

    private static String a(String str, char c2, boolean z) {
        int i;
        boolean z2;
        int i2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int g2 = g(str);
        if (g2 < 0) {
            return null;
        }
        char[] cArr = new char[length + 2];
        str.getChars(0, str.length(), cArr, 0);
        char c3 = f29316b;
        if (c2 == c3) {
            c3 = f29317c;
        }
        for (int i3 = 0; i3 < cArr.length; i3++) {
            if (cArr[i3] == c3) {
                cArr[i3] = c2;
            }
        }
        if (cArr[length - 1] != c2) {
            i = length + 1;
            cArr[length] = c2;
            z2 = false;
        } else {
            i = length;
            z2 = true;
        }
        int i4 = g2 + 1;
        int i5 = i;
        int i6 = i4;
        while (i6 < i5) {
            if (cArr[i6] == c2) {
                int i7 = i6 - 1;
                if (cArr[i7] == c2) {
                    System.arraycopy(cArr, i6, cArr, i7, i5 - i6);
                    i5--;
                    i6--;
                }
            }
            i6++;
        }
        int i8 = i4;
        while (i8 < i5) {
            if (cArr[i8] == c2) {
                int i9 = i8 - 1;
                if (cArr[i9] == '.' && (i8 == i4 || cArr[i8 - 2] == c2)) {
                    if (i8 == i5 - 1) {
                        z2 = true;
                    }
                    System.arraycopy(cArr, i8 + 1, cArr, i9, i5 - i8);
                    i5 -= 2;
                    i8--;
                }
            }
            i8++;
        }
        int i10 = g2 + 2;
        boolean z3 = z2;
        int i11 = i10;
        while (i11 < i5) {
            if (cArr[i11] != c2 || cArr[i11 - 1] != '.' || cArr[i11 - 2] != '.' || (i11 != i10 && cArr[i11 - 3] != c2)) {
                i2 = i11;
            } else {
                if (i11 == i10) {
                    return null;
                }
                if (i11 == i5 - 1) {
                    z3 = true;
                }
                int i12 = i11 - 4;
                while (true) {
                    if (i12 >= g2) {
                        if (cArr[i12] == c2) {
                            i2 = i12 + 1;
                            System.arraycopy(cArr, i11 + 1, cArr, i2, i5 - i11);
                            i5 -= i11 - i12;
                            break;
                        }
                        i12--;
                    } else {
                        int i13 = i11 + 1;
                        System.arraycopy(cArr, i13, cArr, g2, i5 - i11);
                        i5 -= i13 - g2;
                        i2 = i4;
                        break;
                    }
                }
            }
            i11 = i2 + 1;
        }
        if (i5 <= 0) {
            return "";
        }
        if (i5 <= g2) {
            return new String(cArr, 0, i5);
        }
        if (z3 && z) {
            return new String(cArr, 0, i5);
        }
        return new String(cArr, 0, i5 - 1);
    }

    public static String a(String str, String str2) {
        int g2 = g(str2);
        if (g2 < 0) {
            return null;
        }
        if (g2 > 0) {
            return j(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return j(str2);
        }
        if (a(str.charAt(length - 1))) {
            return j(str + str2);
        }
        return j(str + '/' + str2);
    }

    private static String a(String str, boolean z) {
        int g2;
        if (str == null || (g2 = g(str)) < 0) {
            return null;
        }
        if (g2 >= str.length()) {
            return z ? f(str) : str;
        }
        int i = i(str);
        if (i < 0) {
            return str.substring(0, g2);
        }
        int i2 = i + (z ? 1 : 0);
        if (i2 == 0) {
            i2++;
        }
        return str.substring(0, i2);
    }

    public static String a(String str) {
        return l(e(str));
    }
}
