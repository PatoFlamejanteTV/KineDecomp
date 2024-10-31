package com.adobe.xmp;

import com.facebook.internal.ServerProtocol;

/* compiled from: XMPUtils.java */
/* loaded from: classes.dex */
public class k {
    public static String a(boolean z) {
        return z ? "True" : "False";
    }

    public static boolean a(String str) throws XMPException {
        if (str != null && str.length() != 0) {
            String lowerCase = str.toLowerCase();
            try {
                return Integer.parseInt(lowerCase) != 0;
            } catch (NumberFormatException unused) {
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(lowerCase) || com.umeng.commonsdk.proguard.e.ar.equals(lowerCase) || "on".equals(lowerCase) || "yes".equals(lowerCase);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static b b(String str) throws XMPException {
        if (str != null && str.length() != 0) {
            return com.adobe.xmp.a.e.a(str);
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static double c(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Double.parseDouble(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid double string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static int d(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.startsWith("0x")) {
                        return Integer.parseInt(str.substring(2), 16);
                    }
                    return Integer.parseInt(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid integer string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static long e(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.startsWith("0x")) {
                        return Long.parseLong(str.substring(2), 16);
                    }
                    return Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid long string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static byte[] f(String str) throws XMPException {
        try {
            return com.adobe.xmp.a.a.a(str.getBytes());
        } catch (Throwable th) {
            throw new XMPException("Invalid base64 string", 5, th);
        }
    }

    public static String a(int i) {
        return String.valueOf(i);
    }

    public static String a(long j) {
        return String.valueOf(j);
    }

    public static String a(double d2) {
        return String.valueOf(d2);
    }

    public static String a(b bVar) {
        return com.adobe.xmp.a.e.a(bVar);
    }

    public static String a(byte[] bArr) {
        return new String(com.adobe.xmp.a.a.b(bArr));
    }
}
