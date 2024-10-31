package com.adobe.xmp.a;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class k implements com.adobe.xmp.a {

    /* renamed from: a */
    private static boolean[] f7514a;

    /* renamed from: b */
    private static boolean[] f7515b;

    static {
        a();
    }

    public static boolean a(char c2) {
        return ((c2 > 31 && c2 != 127) || c2 == '\t' || c2 == '\n' || c2 == '\r') ? false : true;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                i2++;
                z = z && (i == 8 || i == 13 || i == 18 || i == 23);
            }
            i++;
        }
        return z && 4 == i2 && 36 == i;
    }

    public static boolean b(String str) {
        if (str.length() > 0 && !c(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!b(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        if (str.length() > 0 && (!c(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!b(str.charAt(i)) || str.charAt(i) == ':') {
                return false;
            }
        }
        return true;
    }

    public static String d(String str) {
        if ("x-default".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '-' || charAt == '_') {
                    stringBuffer.append('-');
                    i++;
                } else if (i != 2) {
                    stringBuffer.append(Character.toLowerCase(str.charAt(i2)));
                } else {
                    stringBuffer.append(Character.toUpperCase(str.charAt(i2)));
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String e(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (a(stringBuffer.charAt(i))) {
                stringBuffer.setCharAt(i, ' ');
            }
        }
        return stringBuffer.toString();
    }

    public static String[] f(String str) {
        int indexOf = str.indexOf(61);
        String substring = str.substring(str.charAt(1) == '?' ? 2 : 1, indexOf);
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = i + 1;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - indexOf);
        while (i2 < length) {
            stringBuffer.append(str.charAt(i2));
            i2++;
            if (str.charAt(i2) == charAt) {
                i2++;
            }
        }
        return new String[]{substring, stringBuffer.toString()};
    }

    public static String a(String str, boolean z, boolean z2) {
        boolean z3;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '<' || charAt == '>' || charAt == '&' || ((z2 && (charAt == '\t' || charAt == '\n' || charAt == '\r')) || (z && charAt == '\"'))) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        if (!z3) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer((str.length() * 4) / 3);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt2 = str.charAt(i2);
            if (z2 && (charAt2 == '\t' || charAt2 == '\n' || charAt2 == '\r')) {
                stringBuffer.append("&#x");
                stringBuffer.append(Integer.toHexString(charAt2).toUpperCase());
                stringBuffer.append(';');
            } else if (charAt2 == '\"') {
                stringBuffer.append(z ? "&quot;" : "\"");
            } else if (charAt2 == '&') {
                stringBuffer.append("&amp;");
            } else if (charAt2 == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt2 != '>') {
                stringBuffer.append(charAt2);
            } else {
                stringBuffer.append("&gt;");
            }
        }
        return stringBuffer.toString();
    }

    private static boolean b(char c2) {
        if ((c2 <= 255 && f7515b[c2]) || c(c2)) {
            return true;
        }
        if (c2 < 768 || c2 > 879) {
            return c2 >= 8255 && c2 <= 8256;
        }
        return true;
    }

    private static boolean c(char c2) {
        if (c2 <= 255 && f7514a[c2]) {
            return true;
        }
        if (c2 >= 256 && c2 <= 767) {
            return true;
        }
        if (c2 >= 880 && c2 <= 893) {
            return true;
        }
        if (c2 >= 895 && c2 <= 8191) {
            return true;
        }
        if (c2 >= 8204 && c2 <= 8205) {
            return true;
        }
        if (c2 >= 8304 && c2 <= 8591) {
            return true;
        }
        if (c2 >= 11264 && c2 <= 12271) {
            return true;
        }
        if (c2 >= 12289 && c2 <= 55295) {
            return true;
        }
        if (c2 >= 63744 && c2 <= 64975) {
            return true;
        }
        if (c2 < 65008 || c2 > 65533) {
            return c2 >= 0 && c2 <= 65535;
        }
        return true;
    }

    private static void a() {
        f7515b = new boolean[256];
        f7514a = new boolean[256];
        char c2 = 0;
        while (c2 < f7515b.length) {
            boolean z = true;
            f7514a[c2] = c2 == ':' || ('A' <= c2 && c2 <= 'Z') || c2 == '_' || (('a' <= c2 && c2 <= 'z') || ((192 <= c2 && c2 <= 214) || ((216 <= c2 && c2 <= 246) || (248 <= c2 && c2 <= 255))));
            boolean[] zArr = f7515b;
            if (!f7514a[c2] && c2 != '-' && c2 != '.' && (('0' > c2 || c2 > '9') && c2 != 183)) {
                z = false;
            }
            zArr[c2] = z;
            c2 = (char) (c2 + 1);
        }
    }
}
