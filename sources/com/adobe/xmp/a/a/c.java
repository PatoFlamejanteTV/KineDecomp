package com.adobe.xmp.a.a;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.a.k;
import com.adobe.xmp.h;

/* compiled from: XMPPathParser.java */
/* loaded from: classes.dex */
public final class c {
    public static b a(String str, String str2) throws XMPException {
        d a2;
        if (str != null && str2 != null) {
            b bVar = new b();
            a aVar = new a();
            aVar.f7492a = str2;
            a(str, aVar, bVar);
            while (aVar.f7496e < str2.length()) {
                aVar.f7495d = aVar.f7496e;
                a(str2, aVar);
                int i = aVar.f7495d;
                aVar.f7496e = i;
                if (str2.charAt(i) != '[') {
                    a2 = b(aVar);
                } else {
                    a2 = a(aVar);
                }
                if (a2.b() == 1) {
                    if (a2.c().charAt(0) == '@') {
                        a2.a("?" + a2.c().substring(1));
                        if (!"?xml:lang".equals(a2.c())) {
                            throw new XMPException("Only xml:lang allowed with '@'", 102);
                        }
                    }
                    if (a2.c().charAt(0) == '?') {
                        aVar.f7493b++;
                        a2.b(2);
                    }
                    a(aVar.f7492a.substring(aVar.f7493b, aVar.f7494c));
                } else if (a2.b() != 6) {
                    continue;
                } else {
                    if (a2.c().charAt(1) == '@') {
                        a2.a("[?" + a2.c().substring(2));
                        if (!a2.c().startsWith("[?xml:lang=")) {
                            throw new XMPException("Only xml:lang allowed with '@'", 102);
                        }
                    }
                    if (a2.c().charAt(1) == '?') {
                        aVar.f7493b++;
                        a2.b(5);
                        a(aVar.f7492a.substring(aVar.f7493b, aVar.f7494c));
                    }
                }
                bVar.a(a2);
            }
            return bVar;
        }
        throw new XMPException("Parameter must not be null", 4);
    }

    private static d b(a aVar) throws XMPException {
        aVar.f7493b = aVar.f7495d;
        while (aVar.f7496e < aVar.f7492a.length() && "/[*".indexOf(aVar.f7492a.charAt(aVar.f7496e)) < 0) {
            aVar.f7496e++;
        }
        int i = aVar.f7496e;
        aVar.f7494c = i;
        int i2 = aVar.f7495d;
        if (i != i2) {
            return new d(aVar.f7492a.substring(i2, i), 1);
        }
        throw new XMPException("Empty XMPPath segment", 102);
    }

    private static void b(String str) throws XMPException {
        if (!k.b(str)) {
            throw new XMPException("Bad XML name", 102);
        }
    }

    private static String b(String str, String str2) throws XMPException {
        if (str != null && str.length() != 0) {
            if (str2.charAt(0) != '?' && str2.charAt(0) != '@') {
                if (str2.indexOf(47) < 0 && str2.indexOf(91) < 0) {
                    String a2 = h.b().a(str);
                    if (a2 != null) {
                        int indexOf = str2.indexOf(58);
                        if (indexOf < 0) {
                            b(str2);
                            return String.valueOf(a2) + str2;
                        }
                        b(str2.substring(0, indexOf));
                        b(str2.substring(indexOf));
                        String substring = str2.substring(0, indexOf + 1);
                        String a3 = h.b().a(str);
                        if (a3 != null) {
                            if (substring.equals(a3)) {
                                return str2;
                            }
                            throw new XMPException("Schema namespace URI and prefix mismatch", 101);
                        }
                        throw new XMPException("Unknown schema namespace prefix", 101);
                    }
                    throw new XMPException("Unregistered schema namespace URI", 101);
                }
                throw new XMPException("Top level name must be simple", 102);
            }
            throw new XMPException("Top level name must not be a qualifier", 102);
        }
        throw new XMPException("Schema namespace URI is required", 101);
    }

    private static void a(String str, a aVar) throws XMPException {
        if (str.charAt(aVar.f7495d) == '/') {
            aVar.f7495d++;
            if (aVar.f7495d >= str.length()) {
                throw new XMPException("Empty XMPPath segment", 102);
            }
        }
        if (str.charAt(aVar.f7495d) == '*') {
            aVar.f7495d++;
            if (aVar.f7495d >= str.length() || str.charAt(aVar.f7495d) != '[') {
                throw new XMPException("Missing '[' after '*'", 102);
            }
        }
    }

    private static d a(a aVar) throws XMPException {
        d dVar;
        aVar.f7496e++;
        if ('0' <= aVar.f7492a.charAt(aVar.f7496e) && aVar.f7492a.charAt(aVar.f7496e) <= '9') {
            while (aVar.f7496e < aVar.f7492a.length() && '0' <= aVar.f7492a.charAt(aVar.f7496e) && aVar.f7492a.charAt(aVar.f7496e) <= '9') {
                aVar.f7496e++;
            }
            dVar = new d(null, 3);
        } else {
            while (aVar.f7496e < aVar.f7492a.length() && aVar.f7492a.charAt(aVar.f7496e) != ']' && aVar.f7492a.charAt(aVar.f7496e) != '=') {
                aVar.f7496e++;
            }
            if (aVar.f7496e < aVar.f7492a.length()) {
                if (aVar.f7492a.charAt(aVar.f7496e) == ']') {
                    if ("[last()".equals(aVar.f7492a.substring(aVar.f7495d, aVar.f7496e))) {
                        dVar = new d(null, 4);
                    } else {
                        throw new XMPException("Invalid non-numeric array index", 102);
                    }
                } else {
                    aVar.f7493b = aVar.f7495d + 1;
                    int i = aVar.f7496e;
                    aVar.f7494c = i;
                    aVar.f7496e = i + 1;
                    char charAt = aVar.f7492a.charAt(aVar.f7496e);
                    if (charAt != '\'' && charAt != '\"') {
                        throw new XMPException("Invalid quote in array selector", 102);
                    }
                    aVar.f7496e++;
                    while (aVar.f7496e < aVar.f7492a.length()) {
                        if (aVar.f7492a.charAt(aVar.f7496e) == charAt) {
                            if (aVar.f7496e + 1 >= aVar.f7492a.length() || aVar.f7492a.charAt(aVar.f7496e + 1) != charAt) {
                                break;
                            }
                            aVar.f7496e++;
                        }
                        aVar.f7496e++;
                    }
                    if (aVar.f7496e < aVar.f7492a.length()) {
                        aVar.f7496e++;
                        dVar = new d(null, 6);
                    } else {
                        throw new XMPException("No terminating quote for array selector", 102);
                    }
                }
            } else {
                throw new XMPException("Missing ']' or '=' for array index", 102);
            }
        }
        if (aVar.f7496e < aVar.f7492a.length() && aVar.f7492a.charAt(aVar.f7496e) == ']') {
            aVar.f7496e++;
            dVar.a(aVar.f7492a.substring(aVar.f7495d, aVar.f7496e));
            return dVar;
        }
        throw new XMPException("Missing ']' for array index", 102);
    }

    private static void a(String str, a aVar, b bVar) throws XMPException {
        while (aVar.f7496e < aVar.f7492a.length() && "/[*".indexOf(aVar.f7492a.charAt(aVar.f7496e)) < 0) {
            aVar.f7496e++;
        }
        int i = aVar.f7496e;
        int i2 = aVar.f7495d;
        if (i != i2) {
            String b2 = b(str, aVar.f7492a.substring(i2, i));
            com.adobe.xmp.c.a b3 = h.b().b(b2);
            if (b3 == null) {
                bVar.a(new d(str, Integer.MIN_VALUE));
                bVar.a(new d(b2, 1));
                return;
            }
            bVar.a(new d(b3.getNamespace(), Integer.MIN_VALUE));
            d dVar = new d(b(b3.getNamespace(), b3.a()), 1);
            dVar.a(true);
            dVar.a(b3.b().a());
            bVar.a(dVar);
            if (b3.b().d()) {
                d dVar2 = new d("[?xml:lang='x-default']", 5);
                dVar2.a(true);
                dVar2.a(b3.b().a());
                bVar.a(dVar2);
                return;
            }
            if (b3.b().c()) {
                d dVar3 = new d("[1]", 3);
                dVar3.a(true);
                dVar3.a(b3.b().a());
                bVar.a(dVar3);
                return;
            }
            return;
        }
        throw new XMPException("Empty initial XMPPath step", 102);
    }

    private static void a(String str) throws XMPException {
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (k.c(substring)) {
                if (h.b().getNamespaceURI(substring) == null) {
                    throw new XMPException("Unknown namespace prefix for qualified name", 102);
                }
                return;
            }
        }
        throw new XMPException("Ill-formed qualified name", 102);
    }
}
