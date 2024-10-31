package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Ascii {
    private Ascii() {
    }

    public static String a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (b(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (b(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean a(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static String b(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (a(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (a(c2)) {
                        charArray[i] = (char) (c2 & '_');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean b(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static char c(char c2) {
        return b(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static char d(char c2) {
        return a(c2) ? (char) (c2 & '_') : c2;
    }
}
