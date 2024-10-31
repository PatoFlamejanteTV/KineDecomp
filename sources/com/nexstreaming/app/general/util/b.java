package com.nexstreaming.app.general.util;

/* compiled from: PathUtil.java */
/* loaded from: classes2.dex */
public class B {
    public static String a(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            return str + "/" + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    public static String b(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf < 0) {
                return str2;
            }
            return str.substring(0, lastIndexOf + 1) + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static String d(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf + 1);
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf < 0 ? "" : str.substring(0, lastIndexOf + 1);
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        return (lastIndexOf2 < lastIndexOf || lastIndexOf2 < 0) ? "" : str.substring(lastIndexOf2 + 1);
    }
}
