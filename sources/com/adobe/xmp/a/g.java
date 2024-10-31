package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterAsserts.java */
/* loaded from: classes.dex */
public class g implements com.adobe.xmp.a {
    public static void a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty array name", 4);
        }
    }

    public static void b(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty prefix", 4);
        }
    }

    public static void c(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty property name", 4);
        }
    }

    public static void d(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty schema namespace URI", 4);
        }
    }

    public static void e(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty specific language", 4);
        }
    }

    public static void f(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty array name", 4);
        }
    }

    public static void a(Object obj) throws XMPException {
        if (obj != null) {
            if ((obj instanceof String) && ((String) obj).length() == 0) {
                throw new XMPException("Parameter must not be null or empty", 4);
            }
            return;
        }
        throw new XMPException("Parameter must not be null", 4);
    }
}
