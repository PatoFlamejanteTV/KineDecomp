package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;

/* compiled from: XMPMetaImpl.java */
/* loaded from: classes.dex */
public class p implements com.adobe.xmp.f, com.adobe.xmp.a {

    /* renamed from: a, reason: collision with root package name */
    public s f7545a;

    /* renamed from: b, reason: collision with root package name */
    private String f7546b;

    public p() {
        this.f7546b = null;
        this.f7545a = new s(null, null, null);
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2, com.adobe.xmp.b.e eVar, String str3, com.adobe.xmp.b.e eVar2) throws XMPException {
        g.d(str);
        g.a(str2);
        if (eVar == null) {
            eVar = new com.adobe.xmp.b.e();
        }
        if (eVar.i()) {
            com.adobe.xmp.b.e a2 = t.a(eVar, (Object) null);
            com.adobe.xmp.a.a.b a3 = com.adobe.xmp.a.a.c.a(str, str2);
            s a4 = t.a(this.f7545a, a3, false, (com.adobe.xmp.b.e) null);
            if (a4 != null) {
                if (!a4.i().d()) {
                    throw new XMPException("The named property is not an array", 102);
                }
            } else if (a2.d()) {
                a4 = t.a(this.f7545a, a3, true, a2);
                if (a4 == null) {
                    throw new XMPException("Failure creating array node", 102);
                }
            } else {
                throw new XMPException("Explicit arrayOptions required to create new array", 103);
            }
            a(a4, -1, str3, eVar2, true);
            return;
        }
        throw new XMPException("Only array form flags allowed for arrayOptions", 103);
    }

    @Override // com.adobe.xmp.f
    public com.adobe.xmp.c.b b(String str, String str2) throws XMPException {
        return a(str, str2, 0);
    }

    @Override // com.adobe.xmp.f
    public String c(String str, String str2) throws XMPException {
        return (String) b(str, str2, 0);
    }

    @Override // com.adobe.xmp.f
    public Object clone() {
        return new p((s) this.f7545a.clone());
    }

    @Override // com.adobe.xmp.f
    public boolean d(String str, String str2) {
        try {
            g.d(str);
            g.c(str2);
        } catch (XMPException unused) {
        }
        return t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), false, (com.adobe.xmp.b.e) null) != null;
    }

    @Override // com.adobe.xmp.f
    public com.adobe.xmp.e iterator() throws XMPException {
        return a((String) null, (String) null, (com.adobe.xmp.b.b) null);
    }

    protected Object b(String str, String str2, int i) throws XMPException {
        g.d(str);
        g.c(str2);
        s a2 = t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), false, (com.adobe.xmp.b.e) null);
        if (a2 == null) {
            return null;
        }
        if (i != 0 && a2.i().h()) {
            throw new XMPException("Property must be simple when a value type is requested", 102);
        }
        return a(i, a2);
    }

    public p(s sVar) {
        this.f7546b = null;
        this.f7545a = sVar;
    }

    public void b(String str, String str2, String str3, String str4, String str5, com.adobe.xmp.b.e eVar) throws XMPException {
        g.d(str);
        g.f(str2);
        a(str, String.valueOf(str2) + com.adobe.xmp.i.a(str3, str4), str5, eVar);
    }

    public void b() {
        this.f7545a.C();
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2) {
        try {
            g.d(str);
            g.c(str2);
            s a2 = t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), false, (com.adobe.xmp.b.e) null);
            if (a2 != null) {
                t.a(a2);
            }
        } catch (XMPException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x016e, code lost:            throw new com.adobe.xmp.XMPException("Language qualifier must be first", 102);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:            if (r3 != false) goto L89;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e7, code lost:            if (r3 != false) goto L89;     */
    @Override // com.adobe.xmp.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.adobe.xmp.b.e r13) throws com.adobe.xmp.XMPException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.a.p.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.adobe.xmp.b.e):void");
    }

    protected com.adobe.xmp.c.b a(String str, String str2, int i) throws XMPException {
        g.d(str);
        g.c(str2);
        s a2 = t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), false, (com.adobe.xmp.b.e) null);
        if (a2 == null) {
            return null;
        }
        if (i != 0 && a2.i().h()) {
            throw new XMPException("Property must be simple when a value type is requested", 102);
        }
        return new o(this, a(i, a2), a2);
    }

    @Override // com.adobe.xmp.f
    public com.adobe.xmp.c.b a(String str, String str2, String str3, String str4) throws XMPException {
        g.d(str);
        g.f(str2);
        return b(str, String.valueOf(str2) + com.adobe.xmp.i.a(str3, str4));
    }

    @Override // com.adobe.xmp.f
    public com.adobe.xmp.e a(String str, String str2, com.adobe.xmp.b.b bVar) throws XMPException {
        return new n(this, str, str2, bVar);
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2, int i, String str3, com.adobe.xmp.b.e eVar) throws XMPException {
        g.d(str);
        g.a(str2);
        s a2 = t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), false, (com.adobe.xmp.b.e) null);
        if (a2 != null) {
            a(a2, i, str3, eVar, true);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2, Object obj, com.adobe.xmp.b.e eVar) throws XMPException {
        g.d(str);
        g.c(str2);
        com.adobe.xmp.b.e a2 = t.a(eVar, obj);
        s a3 = t.a(this.f7545a, com.adobe.xmp.a.a.c.a(str, str2), true, a2);
        if (a3 != null) {
            a(a3, obj, a2, false);
            return;
        }
        throw new XMPException("Specified property does not exist", 102);
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2, Object obj) throws XMPException {
        a(str, str2, obj, (com.adobe.xmp.b.e) null);
    }

    @Override // com.adobe.xmp.f
    public void a(String str, String str2, String str3, String str4, String str5) throws XMPException {
        b(str, str2, str3, str4, str5, null);
    }

    public void a(String str) {
        this.f7546b = str;
    }

    public s a() {
        return this.f7545a;
    }

    private void a(s sVar, int i, String str, com.adobe.xmp.b.e eVar, boolean z) throws XMPException {
        s sVar2 = new s("[]", null);
        com.adobe.xmp.b.e a2 = t.a(eVar, str);
        int e2 = z ? sVar.e() + 1 : sVar.e();
        if (i == -1) {
            i = e2;
        }
        if (1 <= i && i <= e2) {
            if (!z) {
                sVar.h(i);
            }
            sVar.a(i, sVar2);
            a(sVar2, (Object) str, a2, false);
            return;
        }
        throw new XMPException("Array index out of bounds", 104);
    }

    void a(s sVar, Object obj, com.adobe.xmp.b.e eVar, boolean z) throws XMPException {
        if (z) {
            sVar.d();
        }
        sVar.i().a(eVar);
        if (!sVar.i().h()) {
            t.a(sVar, obj);
        } else {
            if (obj != null && obj.toString().length() > 0) {
                throw new XMPException("Composite nodes can't have values", 102);
            }
            sVar.t();
        }
    }

    private Object a(int i, s sVar) throws XMPException {
        String value = sVar.getValue();
        switch (i) {
            case 1:
                return new Boolean(com.adobe.xmp.k.a(value));
            case 2:
                return new Integer(com.adobe.xmp.k.d(value));
            case 3:
                return new Long(com.adobe.xmp.k.e(value));
            case 4:
                return new Double(com.adobe.xmp.k.c(value));
            case 5:
                return com.adobe.xmp.k.b(value);
            case 6:
                return com.adobe.xmp.k.b(value).r();
            case 7:
                return com.adobe.xmp.k.f(value);
            default:
                if (value == null && !sVar.i().h()) {
                    value = "";
                }
                return value;
        }
    }
}
