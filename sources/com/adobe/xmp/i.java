package com.adobe.xmp;

/* compiled from: XMPPathFactory.java */
/* loaded from: classes.dex */
public final class i {
    public static String a(String str, int i) throws XMPException {
        if (i > 0) {
            return String.valueOf(str) + '[' + i + ']';
        }
        if (i == -1) {
            return String.valueOf(str) + "[last()]";
        }
        throw new XMPException("Array index must be larger than zero", 104);
    }

    private static void b(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty f name", 102);
        }
    }

    public static String a(String str, String str2) throws XMPException {
        a(str);
        b(str2);
        com.adobe.xmp.a.a.b a2 = com.adobe.xmp.a.a.c.a(str, str2);
        if (a2.a() == 2) {
            return String.valueOf('/') + a2.a(1).c();
        }
        throw new XMPException("The field name must be simple", 102);
    }

    private static void a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty field namespace URI", 101);
        }
    }
}
