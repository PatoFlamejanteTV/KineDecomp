package com.nexstreaming.app.general.util;

/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f3242a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i * 2] = b[(bArr[i] & 240) >> 4];
            cArr[(i * 2) + 1] = b[bArr[i] & 15];
        }
        return new String(cArr);
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }
}
