package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: XMPNormalizer.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static Map f7559a;

    static {
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.adobe.xmp.f a(p pVar, com.adobe.xmp.b.d dVar) throws XMPException {
        s a2 = pVar.a();
        a(pVar);
        a(a2, dVar);
        e(a2);
        a(a2);
        return pVar;
    }

    private static void b(s sVar) throws XMPException {
        s a2 = t.a(sVar, "exif:GPSTimeStamp", false);
        if (a2 == null) {
            return;
        }
        try {
            com.adobe.xmp.b b2 = com.adobe.xmp.k.b(a2.getValue());
            if (b2.getYear() == 0 && b2.getMonth() == 0 && b2.getDay() == 0) {
                s a3 = t.a(sVar, "exif:DateTimeOriginal", false);
                if (a3 == null) {
                    a3 = t.a(sVar, "exif:DateTimeDigitized", false);
                }
                com.adobe.xmp.b b3 = com.adobe.xmp.k.b(a3.getValue());
                Calendar r = b2.r();
                r.set(1, b3.getYear());
                r.set(2, b3.getMonth());
                r.set(5, b3.getDay());
                a2.d(com.adobe.xmp.k.a(new l(r)));
            }
        } catch (XMPException unused) {
        }
    }

    private static void c(s sVar) throws XMPException {
        for (int i = 1; i <= sVar.e(); i++) {
            s f2 = sVar.f(i);
            com.adobe.xmp.b.e eVar = (com.adobe.xmp.b.e) f7559a.get(f2.h());
            if (eVar != null) {
                if (f2.i().l()) {
                    s sVar2 = new s(f2.h(), eVar);
                    f2.c("[]");
                    sVar2.a(f2);
                    sVar.b(i, sVar2);
                    if (eVar.e() && !f2.i().c()) {
                        f2.b(new s("xml:lang", "x-default", null));
                    }
                } else {
                    f2.i().a(7680, false);
                    f2.i().a(eVar);
                    if (eVar.e()) {
                        d(f2);
                    }
                }
            }
        }
    }

    private static void d(s sVar) throws XMPException {
        if (sVar == null || !sVar.i().d()) {
            return;
        }
        com.adobe.xmp.b.e i = sVar.i();
        i.d(true);
        i.c(true);
        i.b(true);
        Iterator p = sVar.p();
        while (p.hasNext()) {
            s sVar2 = (s) p.next();
            if (sVar2.i().h()) {
                p.remove();
            } else if (!sVar2.i().c()) {
                String value = sVar2.getValue();
                if (value != null && value.length() != 0) {
                    sVar2.b(new s("xml:lang", "x-repair", null));
                } else {
                    p.remove();
                }
            }
        }
    }

    private static void e(s sVar) throws XMPException {
        if (sVar.h() == null || sVar.h().length() < 36) {
            return;
        }
        String lowerCase = sVar.h().toLowerCase();
        if (lowerCase.startsWith("uuid:")) {
            lowerCase = lowerCase.substring(5);
        }
        if (k.a(lowerCase)) {
            s a2 = t.a(sVar, com.adobe.xmp.a.a.c.a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID"), true, (com.adobe.xmp.b.e) null);
            if (a2 != null) {
                a2.a((com.adobe.xmp.b.e) null);
                a2.d("uuid:" + lowerCase);
                a2.t();
                a2.B();
                sVar.c((String) null);
                return;
            }
            throw new XMPException("Failure creating xmpMM:InstanceID", 9);
        }
    }

    private static void a(p pVar) throws XMPException {
        s a2;
        t.b(pVar.a(), "http://purl.org/dc/elements/1.1/", true);
        Iterator p = pVar.a().p();
        while (p.hasNext()) {
            s sVar = (s) p.next();
            if ("http://purl.org/dc/elements/1.1/".equals(sVar.h())) {
                c(sVar);
            } else if ("http://ns.adobe.com/exif/1.0/".equals(sVar.h())) {
                b(sVar);
                s a3 = t.a(sVar, "exif:UserComment", false);
                if (a3 != null) {
                    d(a3);
                }
            } else if ("http://ns.adobe.com/xmp/1.0/DynamicMedia/".equals(sVar.h())) {
                s a4 = t.a(sVar, "xmpDM:copyright", false);
                if (a4 != null) {
                    a(pVar, a4);
                }
            } else if ("http://ns.adobe.com/xap/1.0/rights/".equals(sVar.h()) && (a2 = t.a(sVar, "xmpRights:UsageTerms", false)) != null) {
                d(a2);
            }
        }
    }

    private static void a(s sVar, com.adobe.xmp.b.d dVar) throws XMPException {
        if (sVar.f()) {
            sVar.c(false);
            boolean g2 = dVar.g();
            for (s sVar2 : sVar.k()) {
                if (sVar2.f()) {
                    Iterator p = sVar2.p();
                    while (p.hasNext()) {
                        s sVar3 = (s) p.next();
                        if (sVar3.n()) {
                            sVar3.b(false);
                            com.adobe.xmp.c.a b2 = com.adobe.xmp.h.b().b(sVar3.h());
                            if (b2 != null) {
                                s sVar4 = null;
                                s a2 = t.a(sVar, b2.getNamespace(), (String) null, true);
                                a2.e(false);
                                s a3 = t.a(a2, String.valueOf(b2.getPrefix()) + b2.a(), false);
                                if (a3 == null) {
                                    if (b2.b().e()) {
                                        sVar3.c(String.valueOf(b2.getPrefix()) + b2.a());
                                        a2.a(sVar3);
                                        p.remove();
                                    } else {
                                        s sVar5 = new s(String.valueOf(b2.getPrefix()) + b2.a(), b2.b().f());
                                        a2.a(sVar5);
                                        a(p, sVar3, sVar5);
                                    }
                                } else if (b2.b().e()) {
                                    if (g2) {
                                        a(sVar3, a3, true);
                                    }
                                    p.remove();
                                } else {
                                    if (b2.b().d()) {
                                        int a4 = t.a(a3, "x-default");
                                        if (a4 != -1) {
                                            sVar4 = a3.f(a4);
                                        }
                                    } else if (a3.l()) {
                                        sVar4 = a3.f(1);
                                    }
                                    if (sVar4 == null) {
                                        a(p, sVar3, a3);
                                    } else {
                                        if (g2) {
                                            a(sVar3, sVar4, true);
                                        }
                                        p.remove();
                                    }
                                }
                            }
                        }
                    }
                    sVar2.c(false);
                }
            }
        }
    }

    private static void a(Iterator it, s sVar, s sVar2) throws XMPException {
        if (sVar2.i().e()) {
            if (!sVar.i().c()) {
                sVar.b(new s("xml:lang", "x-default", null));
            } else {
                throw new XMPException("Alias to x-default already has a language qualifier", 203);
            }
        }
        it.remove();
        sVar.c("[]");
        sVar2.a(sVar);
    }

    private static void a(s sVar) {
        Iterator p = sVar.p();
        while (p.hasNext()) {
            if (!((s) p.next()).l()) {
                p.remove();
            }
        }
    }

    private static void a(s sVar, s sVar2, boolean z) throws XMPException {
        if (sVar.getValue().equals(sVar2.getValue()) && sVar.e() == sVar2.e()) {
            if (!z && (!sVar.h().equals(sVar2.h()) || !sVar.i().equals(sVar2.i()) || sVar.j() != sVar2.j())) {
                throw new XMPException("Mismatch between alias and base nodes", 203);
            }
            Iterator p = sVar.p();
            Iterator p2 = sVar2.p();
            while (p.hasNext() && p2.hasNext()) {
                a((s) p.next(), (s) p2.next(), false);
            }
            Iterator q = sVar.q();
            Iterator q2 = sVar2.q();
            while (q.hasNext() && q2.hasNext()) {
                a((s) q.next(), (s) q2.next(), false);
            }
            return;
        }
        throw new XMPException("Mismatch between alias and base nodes", 203);
    }

    private static void a(com.adobe.xmp.f fVar, s sVar) {
        try {
            s b2 = t.b(((p) fVar).a(), "http://purl.org/dc/elements/1.1/", true);
            String value = sVar.getValue();
            s a2 = t.a(b2, "dc:rights", false);
            if (a2 != null && a2.l()) {
                int a3 = t.a(a2, "x-default");
                if (a3 < 0) {
                    fVar.a("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", a2.f(1).getValue(), null);
                    a3 = t.a(a2, "x-default");
                }
                s f2 = a2.f(a3);
                String value2 = f2.getValue();
                int indexOf = value2.indexOf("\n\n");
                if (indexOf < 0) {
                    if (!value.equals(value2)) {
                        f2.d(String.valueOf(value2) + "\n\n" + value);
                    }
                } else {
                    int i = indexOf + 2;
                    if (!value2.substring(i).equals(value)) {
                        f2.d(String.valueOf(value2.substring(0, i)) + value);
                    }
                }
                sVar.getParent().d(sVar);
            }
            fVar.a("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", "\n\n" + value, null);
            sVar.getParent().d(sVar);
        } catch (XMPException unused) {
        }
    }

    private static void a() {
        f7559a = new HashMap();
        com.adobe.xmp.b.e eVar = new com.adobe.xmp.b.e();
        eVar.a(true);
        f7559a.put("dc:contributor", eVar);
        f7559a.put("dc:language", eVar);
        f7559a.put("dc:publisher", eVar);
        f7559a.put("dc:relation", eVar);
        f7559a.put("dc:subject", eVar);
        f7559a.put("dc:type", eVar);
        com.adobe.xmp.b.e eVar2 = new com.adobe.xmp.b.e();
        eVar2.a(true);
        eVar2.d(true);
        f7559a.put("dc:creator", eVar2);
        f7559a.put("dc:date", eVar2);
        com.adobe.xmp.b.e eVar3 = new com.adobe.xmp.b.e();
        eVar3.a(true);
        eVar3.d(true);
        eVar3.c(true);
        eVar3.b(true);
        f7559a.put("dc:description", eVar3);
        f7559a.put("dc:rights", eVar3);
        f7559a.put("dc:title", eVar3);
    }
}
