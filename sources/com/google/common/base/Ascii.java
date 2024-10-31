package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Ascii {
    private Ascii() {
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(a(str.charAt(i)));
        }
        return sb.toString();
    }

    public static char a(char c) {
        return d(c) ? (char) (c ^ ' ') : c;
    }

    public static String b(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(b(str.charAt(i)));
        }
        return sb.toString();
    }

    public static char b(char c) {
        return c(c) ? (char) (c & '_') : c;
    }

    public static boolean c(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean d(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
