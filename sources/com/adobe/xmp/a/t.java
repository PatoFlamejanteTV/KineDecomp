package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.util.GregorianCalendar;
import java.util.Iterator;

/* compiled from: XMPNodeUtils.java */
/* loaded from: classes.dex */
public class t implements com.adobe.xmp.a {
    public static s a(s sVar, String str, String str2, boolean z) throws XMPException {
        s a2 = sVar.a(str);
        if (a2 == null && z) {
            com.adobe.xmp.b.e eVar = new com.adobe.xmp.b.e();
            eVar.i(true);
            a2 = new s(str, eVar);
            a2.e(true);
            String a3 = com.adobe.xmp.h.b().a(str);
            if (a3 == null) {
                if (str2 != null && str2.length() != 0) {
                    a3 = com.adobe.xmp.h.b().a(str, str2);
                } else {
                    throw new XMPException("Unregistered schema namespace URI", 101);
                }
            }
            a2.d(a3);
            sVar.a(a2);
        }
        return a2;
    }

    public static s b(s sVar, String str, boolean z) throws XMPException {
        return a(sVar, str, (String) null, z);
    }

    private static int c(s sVar, String str, boolean z) throws XMPException {
        try {
            int parseInt = Integer.parseInt(str.substring(1, str.length() - 1));
            if (parseInt >= 1) {
                if (z && parseInt == sVar.e() + 1) {
                    s sVar2 = new s("[]", null);
                    sVar2.e(true);
                    sVar.a(sVar2);
                }
                return parseInt;
            }
            throw new XMPException("Array index must be larger than zero", 102);
        } catch (NumberFormatException unused) {
            throw new XMPException("Array index not digits.", 102);
        }
    }

    private static s d(s sVar, String str, boolean z) throws XMPException {
        s b2 = sVar.b(str);
        if (b2 != null || !z) {
            return b2;
        }
        s sVar2 = new s(str, null);
        sVar2.e(true);
        sVar.b(sVar2);
        return sVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(s sVar) {
        if (sVar.i().f() && sVar.l()) {
            boolean z = false;
            Iterator p = sVar.p();
            while (true) {
                if (!p.hasNext()) {
                    break;
                } else if (((s) p.next()).i().c()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                sVar.i().b(true);
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(s sVar, String str, String str2) throws XMPException {
        if (sVar.i().e()) {
            if (!sVar.l()) {
                Object[] objArr = new Object[2];
                objArr[0] = new Integer(0);
                return objArr;
            }
            Iterator p = sVar.p();
            s sVar2 = null;
            s sVar3 = null;
            int i = 0;
            while (p.hasNext()) {
                s sVar4 = (s) p.next();
                if (!sVar4.i().h()) {
                    if (sVar4.m() && "xml:lang".equals(sVar4.g(1).h())) {
                        String value = sVar4.g(1).getValue();
                        if (str2.equals(value)) {
                            return new Object[]{new Integer(1), sVar4};
                        }
                        if (str != null && value.startsWith(str)) {
                            if (sVar2 == null) {
                                sVar2 = sVar4;
                            }
                            i++;
                        } else if ("x-default".equals(value)) {
                            sVar3 = sVar4;
                        }
                    } else {
                        throw new XMPException("Alt-text array item has no language qualifier", 102);
                    }
                } else {
                    throw new XMPException("Alt-text array item is not simple", 102);
                }
            }
            if (i == 1) {
                return new Object[]{new Integer(2), sVar2};
            }
            if (i > 1) {
                return new Object[]{new Integer(3), sVar2};
            }
            if (sVar3 != null) {
                return new Object[]{new Integer(4), sVar3};
            }
            return new Object[]{new Integer(5), sVar.f(1)};
        }
        throw new XMPException("Localized text array is not alt-text", 102);
    }

    private static int c(s sVar, String str, String str2) throws XMPException {
        int i = -1;
        for (int i2 = 1; i2 <= sVar.e() && i < 0; i2++) {
            s f2 = sVar.f(i2);
            if (!f2.i().m()) {
                throw new XMPException("Field selector must be used on array of struct", 102);
            }
            int i3 = 1;
            while (true) {
                if (i3 > f2.e()) {
                    break;
                }
                s f3 = f2.f(i3);
                if (str.equals(f3.h()) && str2.equals(f3.getValue())) {
                    i = i2;
                    break;
                }
                i3++;
            }
        }
        return i;
    }

    public static s a(s sVar, String str, boolean z) throws XMPException {
        if (!sVar.i().k() && !sVar.i().m()) {
            if (sVar.o()) {
                if (sVar.i().d()) {
                    throw new XMPException("Named children not allowed for arrays", 102);
                }
                if (z) {
                    sVar.i().j(true);
                }
            } else {
                throw new XMPException("Named children only allowed for schemas and structs", 102);
            }
        }
        s a2 = sVar.a(str);
        if (a2 != null || !z) {
            return a2;
        }
        s sVar2 = new s(str, new com.adobe.xmp.b.e());
        sVar2.e(true);
        sVar.a(sVar2);
        return sVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(s sVar) {
        if (sVar.i().e()) {
            for (int i = 2; i <= sVar.e(); i++) {
                s f2 = sVar.f(i);
                if (f2.m() && "x-default".equals(f2.g(1).getValue())) {
                    try {
                        sVar.h(i);
                        sVar.a(1, f2);
                    } catch (XMPException unused) {
                    }
                    if (i == 2) {
                        sVar.f(2).d(f2.getValue());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static s a(s sVar, com.adobe.xmp.a.a.b bVar, boolean z, com.adobe.xmp.b.e eVar) throws XMPException {
        s sVar2;
        if (bVar != null && bVar.a() != 0) {
            s b2 = b(sVar, bVar.a(0).c(), z);
            if (b2 == null) {
                return null;
            }
            if (b2.o()) {
                b2.e(false);
                sVar2 = b2;
            } else {
                sVar2 = null;
            }
            s sVar3 = sVar2;
            s sVar4 = b2;
            for (int i = 1; i < bVar.a(); i++) {
                try {
                    sVar4 = a(sVar4, bVar.a(i), z);
                    if (sVar4 == null) {
                        if (z) {
                            a(sVar3);
                        }
                        return null;
                    }
                    if (sVar4.o()) {
                        sVar4.e(false);
                        if (i == 1 && bVar.a(i).d() && bVar.a(i).a() != 0) {
                            sVar4.i().a(bVar.a(i).a(), true);
                        } else if (i < bVar.a() - 1 && bVar.a(i).b() == 1 && !sVar4.i().h()) {
                            sVar4.i().j(true);
                        }
                        if (sVar3 == null) {
                            sVar3 = sVar4;
                        }
                    }
                } catch (XMPException e2) {
                    if (sVar3 != null) {
                        a(sVar3);
                    }
                    throw e2;
                }
            }
            if (sVar3 != null) {
                sVar4.i().a(eVar);
                sVar4.a(sVar4.i());
            }
            return sVar4;
        }
        throw new XMPException("Empty XMPPath", 102);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s sVar) {
        s parent = sVar.getParent();
        if (sVar.i().j()) {
            parent.e(sVar);
        } else {
            parent.d(sVar);
        }
        if (parent.l() || !parent.i().k()) {
            return;
        }
        parent.getParent().d(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s sVar, Object obj) {
        String a2 = a(obj);
        if (sVar.i().j() && "xml:lang".equals(sVar.h())) {
            sVar.d(k.d(a2));
        } else {
            sVar.d(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.adobe.xmp.b.e a(com.adobe.xmp.b.e eVar, Object obj) throws XMPException {
        if (eVar == null) {
            eVar = new com.adobe.xmp.b.e();
        }
        if (eVar.e()) {
            eVar.c(true);
        }
        if (eVar.f()) {
            eVar.d(true);
        }
        if (eVar.g()) {
            eVar.a(true);
        }
        if (eVar.h() && obj != null && obj.toString().length() > 0) {
            throw new XMPException("Structs and arrays can't have values", 103);
        }
        eVar.a(eVar.a());
        return eVar;
    }

    static String a(Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = null;
        } else if (obj instanceof Boolean) {
            obj2 = com.adobe.xmp.k.a(((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            obj2 = com.adobe.xmp.k.a(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            obj2 = com.adobe.xmp.k.a(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            obj2 = com.adobe.xmp.k.a(((Double) obj).doubleValue());
        } else if (obj instanceof com.adobe.xmp.b) {
            obj2 = com.adobe.xmp.k.a((com.adobe.xmp.b) obj);
        } else if (obj instanceof GregorianCalendar) {
            obj2 = com.adobe.xmp.k.a(com.adobe.xmp.c.a((GregorianCalendar) obj));
        } else if (obj instanceof byte[]) {
            obj2 = com.adobe.xmp.k.a((byte[]) obj);
        } else {
            obj2 = obj.toString();
        }
        if (obj2 != null) {
            return k.e(obj2);
        }
        return null;
    }

    private static s a(s sVar, com.adobe.xmp.a.a.d dVar, boolean z) throws XMPException {
        int a2;
        int b2 = dVar.b();
        if (b2 == 1) {
            return a(sVar, dVar.c(), z);
        }
        if (b2 == 2) {
            return d(sVar, dVar.c().substring(1), z);
        }
        if (sVar.i().d()) {
            if (b2 == 3) {
                a2 = c(sVar, dVar.c(), z);
            } else if (b2 == 4) {
                a2 = sVar.e();
            } else if (b2 == 6) {
                String[] f2 = k.f(dVar.c());
                a2 = c(sVar, f2[0], f2[1]);
            } else if (b2 == 5) {
                String[] f3 = k.f(dVar.c());
                a2 = a(sVar, f3[0], f3[1], dVar.a());
            } else {
                throw new XMPException("Unknown array indexing step in FollowXPathStep", 9);
            }
            if (1 > a2 || a2 > sVar.e()) {
                return null;
            }
            return sVar.f(a2);
        }
        throw new XMPException("Indexing applied to non-array", 102);
    }

    private static int a(s sVar, String str, String str2, int i) throws XMPException {
        if ("xml:lang".equals(str)) {
            int a2 = a(sVar, k.d(str2));
            if (a2 >= 0 || (i & 4096) <= 0) {
                return a2;
            }
            s sVar2 = new s("[]", null);
            sVar2.b(new s("xml:lang", "x-default", null));
            sVar.a(1, sVar2);
            return 1;
        }
        for (int i2 = 1; i2 < sVar.e(); i2++) {
            Iterator q = sVar.f(i2).q();
            while (q.hasNext()) {
                s sVar3 = (s) q.next();
                if (str.equals(sVar3.h()) && str2.equals(sVar3.getValue())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s sVar, String str, String str2) throws XMPException {
        s sVar2 = new s("[]", str2, null);
        s sVar3 = new s("xml:lang", str, null);
        sVar2.b(sVar3);
        if (!"x-default".equals(sVar3.getValue())) {
            sVar.a(sVar2);
        } else {
            sVar.a(1, sVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(s sVar, String str) throws XMPException {
        if (sVar.i().d()) {
            for (int i = 1; i <= sVar.e(); i++) {
                s f2 = sVar.f(i);
                if (f2.m() && "xml:lang".equals(f2.g(1).h()) && str.equals(f2.g(1).getValue())) {
                    return i;
                }
            }
            return -1;
        }
        throw new XMPException("Language item must be used on array", 102);
    }
}
