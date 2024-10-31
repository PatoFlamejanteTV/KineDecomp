package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: XMPSerializerRDF.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    static final Set f7569a = new HashSet(Arrays.asList("xml:lang", "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID"));

    /* renamed from: b, reason: collision with root package name */
    private p f7570b;

    /* renamed from: c, reason: collision with root package name */
    private c f7571c;

    /* renamed from: d, reason: collision with root package name */
    private OutputStreamWriter f7572d;

    /* renamed from: e, reason: collision with root package name */
    private com.adobe.xmp.b.f f7573e;

    /* renamed from: f, reason: collision with root package name */
    private int f7574f = 1;

    /* renamed from: g, reason: collision with root package name */
    private int f7575g;

    private String b() throws IOException, XMPException {
        int i = 0;
        if (!this.f7573e.k()) {
            f(0);
            a("<?xpacket begin=\"\ufeff\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>");
            c();
        }
        if (!this.f7573e.m()) {
            f(0);
            a("<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"");
            if (!this.f7573e.l()) {
                a(com.adobe.xmp.h.c().getMessage());
            }
            a("\">");
            c();
            i = 1;
        }
        f(i);
        a("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">");
        c();
        if (this.f7573e.q()) {
            c(i);
        } else {
            d(i);
        }
        f(i);
        a("</rdf:RDF>");
        c();
        if (!this.f7573e.m()) {
            f(i - 1);
            a("</x:xmpmeta>");
            c();
        }
        String str = "";
        if (this.f7573e.k()) {
            return "";
        }
        for (int c2 = this.f7573e.c(); c2 > 0; c2--) {
            str = String.valueOf(str) + this.f7573e.i();
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(str) + "<?xpacket end=\""));
        sb.append(this.f7573e.o() ? 'r' : 'w');
        return String.valueOf(sb.toString()) + "\"?>";
    }

    private void c(int i) throws IOException, XMPException {
        if (this.f7570b.a().e() > 0) {
            e(this.f7570b.a(), i);
            Iterator p = this.f7570b.a().p();
            while (p.hasNext()) {
                a((s) p.next(), i);
            }
            b(i);
            return;
        }
        f(i + 1);
        a("<rdf:Description rdf:about=");
        d();
        a("/>");
        c();
    }

    private void d() throws IOException {
        e(34);
        String h2 = this.f7570b.a().h();
        if (h2 != null) {
            a(h2, true);
        }
        e(34);
    }

    private void e(s sVar, int i) throws IOException {
        f(i + 1);
        a("<rdf:Description rdf:about=");
        d();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        a(sVar, hashSet, i + 3);
        e(62);
        c();
    }

    private void f(int i) throws IOException {
        for (int c2 = this.f7573e.c() + i; c2 > 0; c2--) {
            this.f7572d.write(this.f7573e.i());
        }
    }

    public void a(com.adobe.xmp.f fVar, OutputStream outputStream, com.adobe.xmp.b.f fVar2) throws XMPException {
        try {
            this.f7571c = new c(outputStream);
            this.f7572d = new OutputStreamWriter(this.f7571c, fVar2.f());
            this.f7570b = (p) fVar;
            this.f7573e = fVar2;
            this.f7575g = fVar2.n();
            this.f7572d = new OutputStreamWriter(this.f7571c, fVar2.f());
            a();
            String b2 = b();
            this.f7572d.flush();
            a(b2.length());
            a(b2);
            this.f7572d.flush();
            this.f7571c.close();
        } catch (IOException unused) {
            throw new XMPException("Error writing to the OutputStream", 0);
        }
    }

    private void d(int i) throws IOException, XMPException {
        int i2 = i + 1;
        f(i2);
        a("<rdf:Description rdf:about=");
        d();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        Iterator p = this.f7570b.a().p();
        while (p.hasNext()) {
            a((s) p.next(), hashSet, i + 3);
        }
        Iterator p2 = this.f7570b.a().p();
        boolean z = true;
        while (p2.hasNext()) {
            z &= c((s) p2.next(), i + 2);
        }
        if (!z) {
            e(62);
            c();
            Iterator p3 = this.f7570b.a().p();
            while (p3.hasNext()) {
                d((s) p3.next(), i + 2);
            }
            f(i2);
            a("</rdf:Description>");
            c();
            return;
        }
        a("/>");
        c();
    }

    private void e(int i) throws IOException {
        this.f7572d.write(i);
    }

    private boolean c(s sVar, int i) throws IOException {
        Iterator p = sVar.p();
        boolean z = true;
        while (p.hasNext()) {
            s sVar2 = (s) p.next();
            if (a(sVar2)) {
                c();
                f(i);
                a(sVar2.h());
                a("=\"");
                a(sVar2.getValue(), true);
                e(34);
            } else {
                z = false;
            }
        }
        return z;
    }

    private void a(int i) throws XMPException, IOException {
        if (this.f7573e.g()) {
            int a2 = this.f7571c.a() + (i * this.f7574f);
            int i2 = this.f7575g;
            if (a2 <= i2) {
                this.f7575g = i2 - a2;
            } else {
                throw new XMPException("Can't fit into specified packet size", 107);
            }
        }
        this.f7575g /= this.f7574f;
        int length = this.f7573e.j().length();
        int i3 = this.f7575g;
        if (i3 >= length) {
            this.f7575g = i3 - length;
            while (true) {
                int i4 = this.f7575g;
                int i5 = length + 100;
                if (i4 < i5) {
                    a(i4, ' ');
                    c();
                    return;
                } else {
                    a(100, ' ');
                    c();
                    this.f7575g -= i5;
                }
            }
        } else {
            a(i3, ' ');
        }
    }

    private void c() throws IOException {
        this.f7572d.write(this.f7573e.j());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.adobe.xmp.a.s r11, int r12) throws java.io.IOException, com.adobe.xmp.XMPException {
        /*
            r10 = this;
            java.util.Iterator r11 = r11.p()
        L4:
            boolean r0 = r11.hasNext()
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Object r0 = r11.next()
            com.adobe.xmp.a.s r0 = (com.adobe.xmp.a.s) r0
            boolean r1 = r10.a(r0)
            if (r1 == 0) goto L18
            goto L4
        L18:
            java.lang.String r1 = r0.h()
            java.lang.String r2 = "[]"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L26
            java.lang.String r1 = "rdf:li"
        L26:
            r10.f(r12)
            r2 = 60
            r10.e(r2)
            r10.a(r1)
            java.util.Iterator r2 = r0.q()
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 0
        L39:
            boolean r7 = r2.hasNext()
            if (r7 != 0) goto L91
            if (r5 == 0) goto L45
            r10.a(r12, r0)
            goto L72
        L45:
            com.adobe.xmp.b.e r2 = r0.i()
            boolean r2 = r2.h()
            if (r2 != 0) goto L65
            java.lang.Object[] r0 = r10.b(r0)
            r2 = r0[r3]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0 = r0[r4]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r4 = r0.booleanValue()
            r0 = r2
            goto L78
        L65:
            com.adobe.xmp.b.e r2 = r0.i()
            boolean r2 = r2.d()
            if (r2 == 0) goto L74
            r10.b(r0, r12)
        L72:
            r0 = 1
            goto L78
        L74:
            boolean r0 = r10.a(r0, r12, r6)
        L78:
            if (r0 == 0) goto L4
            if (r4 == 0) goto L7f
            r10.f(r12)
        L7f:
            java.lang.String r0 = "</"
            r10.a(r0)
            r10.a(r1)
            r0 = 62
            r10.e(r0)
            r10.c()
            goto L4
        L91:
            java.lang.Object r7 = r2.next()
            com.adobe.xmp.a.s r7 = (com.adobe.xmp.a.s) r7
            java.util.Set r8 = com.adobe.xmp.a.y.f7569a
            java.lang.String r9 = r7.h()
            boolean r8 = r8.contains(r9)
            if (r8 != 0) goto La5
            r5 = 1
            goto L39
        La5:
            java.lang.String r6 = r7.h()
            java.lang.String r8 = "rdf:resource"
            boolean r6 = r8.equals(r6)
            r8 = 32
            r10.e(r8)
            java.lang.String r8 = r7.h()
            r10.a(r8)
            java.lang.String r8 = "=\""
            r10.a(r8)
            java.lang.String r7 = r7.getValue()
            r10.a(r7, r4)
            r7 = 34
            r10.e(r7)
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.a.y.d(com.adobe.xmp.a.s, int):void");
    }

    private Object[] b(s sVar) throws IOException {
        Boolean bool;
        Boolean bool2 = Boolean.TRUE;
        if (sVar.i().n()) {
            a(" rdf:resource=\"");
            a(sVar.getValue(), true);
            a("\"/>");
            c();
            bool = Boolean.FALSE;
        } else if (sVar.getValue() != null && sVar.getValue().length() != 0) {
            e(62);
            a(sVar.getValue(), false);
            bool2 = Boolean.FALSE;
            bool = bool2;
        } else {
            a("/>");
            c();
            bool = Boolean.FALSE;
        }
        return new Object[]{bool, bool2};
    }

    protected void a() throws XMPException {
        if (this.f7573e.d() | this.f7573e.e()) {
            this.f7574f = 2;
        }
        if (this.f7573e.g()) {
            if (!(this.f7573e.k() | this.f7573e.h())) {
                if ((this.f7573e.n() & (this.f7574f - 1)) != 0) {
                    throw new XMPException("Exact size must be a multiple of the Unicode element", 103);
                }
                return;
            }
            throw new XMPException("Inconsistent options for exact size serialize", 103);
        }
        if (this.f7573e.o()) {
            if (!(this.f7573e.k() | this.f7573e.h())) {
                this.f7575g = 0;
                return;
            }
            throw new XMPException("Inconsistent options for read-only packet", 103);
        }
        if (this.f7573e.k()) {
            if (!this.f7573e.h()) {
                this.f7575g = 0;
                return;
            }
            throw new XMPException("Inconsistent options for non-packet serialize", 103);
        }
        if (this.f7575g == 0) {
            this.f7575g = this.f7574f * 2048;
        }
        if (!this.f7573e.h() || this.f7570b.d("http://ns.adobe.com/xap/1.0/", "Thumbnails")) {
            return;
        }
        this.f7575g += this.f7574f * io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
    }

    private void b(s sVar, int i) throws IOException, XMPException {
        e(62);
        c();
        int i2 = i + 1;
        a(sVar, true, i2);
        if (sVar.i().e()) {
            t.c(sVar);
        }
        d(sVar, i + 2);
        a(sVar, false, i2);
    }

    private boolean a(s sVar, int i, boolean z) throws XMPException, IOException {
        Iterator p = sVar.p();
        boolean z2 = false;
        boolean z3 = false;
        while (p.hasNext()) {
            if (a((s) p.next())) {
                z2 = true;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                break;
            }
        }
        if (z && z3) {
            throw new XMPException("Can't mix rdf:resource qualifier and element fields", 202);
        }
        if (!sVar.l()) {
            a(" rdf:parseType=\"Resource\"/>");
            c();
            return false;
        }
        if (!z3) {
            c(sVar, i + 1);
            a("/>");
            c();
            return false;
        }
        if (!z2) {
            a(" rdf:parseType=\"Resource\">");
            c();
            d(sVar, i + 1);
        } else {
            e(62);
            c();
            int i2 = i + 1;
            f(i2);
            a("<rdf:Description");
            c(sVar, i + 2);
            a(">");
            c();
            d(sVar, i2);
            f(i2);
            a("</rdf:Description>");
            c();
        }
        return true;
    }

    private void b(int i) throws IOException {
        f(i + 1);
        a("</rdf:Description>");
        c();
    }

    private void a(int i, s sVar) throws IOException, XMPException {
        a(" rdf:parseType=\"Resource\">");
        c();
        int i2 = i + 1;
        a(sVar, false, true, i2);
        Iterator q = sVar.q();
        while (q.hasNext()) {
            a((s) q.next(), false, false, i2);
        }
    }

    private void a(s sVar, int i) throws IOException, XMPException {
        Iterator p = sVar.p();
        while (p.hasNext()) {
            a((s) p.next(), this.f7573e.q(), false, i + 2);
        }
    }

    private void a(s sVar, Set set, int i) throws IOException {
        if (sVar.i().k()) {
            a(sVar.getValue().substring(0, sVar.getValue().length() - 1), sVar.h(), set, i);
        } else if (sVar.i().m()) {
            Iterator p = sVar.p();
            while (p.hasNext()) {
                a(((s) p.next()).h(), (String) null, set, i);
            }
        }
        Iterator p2 = sVar.p();
        while (p2.hasNext()) {
            a((s) p2.next(), set, i);
        }
        Iterator q = sVar.q();
        while (q.hasNext()) {
            s sVar2 = (s) q.next();
            a(sVar2.h(), (String) null, set, i);
            a(sVar2, set, i);
        }
    }

    private void a(String str, String str2, Set set, int i) throws IOException {
        if (str2 == null) {
            j jVar = new j(str);
            if (!jVar.b()) {
                return;
            }
            str = jVar.a();
            str2 = com.adobe.xmp.h.b().getNamespaceURI(String.valueOf(str) + ":");
            a(str, str2, set, i);
        }
        if (set.contains(str)) {
            return;
        }
        c();
        f(i);
        a("xmlns:");
        a(str);
        a("=\"");
        a(str2);
        e(34);
        set.add(str);
    }

    private void a(s sVar, boolean z, boolean z2, int i) throws IOException, XMPException {
        int i2;
        int i3 = i;
        String h2 = sVar.h();
        if (z2) {
            h2 = "rdf:value";
        } else if ("[]".equals(h2)) {
            h2 = "rdf:li";
        }
        f(i3);
        e(60);
        a(h2);
        Iterator q = sVar.q();
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = false;
        while (q.hasNext()) {
            s sVar2 = (s) q.next();
            if (f7569a.contains(sVar2.h())) {
                z6 = "rdf:resource".equals(sVar2.h());
                if (!z2) {
                    e(32);
                    a(sVar2.h());
                    a("=\"");
                    a(sVar2.getValue(), true);
                    e(34);
                }
            } else {
                z5 = true;
            }
        }
        if (!z5 || z2) {
            if (!sVar.i().h()) {
                if (sVar.i().n()) {
                    a(" rdf:resource=\"");
                    a(sVar.getValue(), true);
                    a("\"/>");
                    c();
                } else if (sVar.getValue() != null && !"".equals(sVar.getValue())) {
                    e(62);
                    a(sVar.getValue(), false);
                } else {
                    a("/>");
                    c();
                }
            } else {
                if (sVar.i().d()) {
                    e(62);
                    c();
                    int i4 = i3 + 1;
                    a(sVar, true, i4);
                    if (sVar.i().e()) {
                        t.c(sVar);
                    }
                    Iterator p = sVar.p();
                    while (p.hasNext()) {
                        a((s) p.next(), z, false, i3 + 2);
                    }
                    a(sVar, false, i4);
                } else if (!z6) {
                    if (!sVar.l()) {
                        if (z) {
                            a(">");
                            c();
                            f(i3 + 1);
                            a("<rdf:Description/>");
                            z3 = true;
                        } else {
                            a(" rdf:parseType=\"Resource\"/>");
                        }
                        c();
                        z4 = z3;
                    } else {
                        if (z) {
                            a(">");
                            c();
                            i3++;
                            f(i3);
                            a("<rdf:Description");
                            a(">");
                        } else {
                            a(" rdf:parseType=\"Resource\">");
                        }
                        int i5 = i3;
                        c();
                        Iterator p2 = sVar.p();
                        while (p2.hasNext()) {
                            a((s) p2.next(), z, false, i5 + 1);
                        }
                        if (z) {
                            f(i5);
                            a("</rdf:Description>");
                            c();
                            i2 = i5 - 1;
                            i3 = i2;
                        } else {
                            i3 = i5;
                        }
                    }
                } else {
                    Iterator p3 = sVar.p();
                    while (p3.hasNext()) {
                        s sVar3 = (s) p3.next();
                        if (a(sVar3)) {
                            c();
                            f(i3 + 1);
                            e(32);
                            a(sVar3.h());
                            a("=\"");
                            a(sVar3.getValue(), true);
                            e(34);
                        } else {
                            throw new XMPException("Can't mix rdf:resource and complex fields", 202);
                        }
                    }
                    a("/>");
                    c();
                }
                z3 = true;
            }
            z3 = true;
            z4 = false;
        } else if (!z6) {
            if (z) {
                a(">");
                c();
                i3++;
                f(i3);
                a("<rdf:Description");
                a(">");
            } else {
                a(" rdf:parseType=\"Resource\">");
            }
            c();
            int i6 = i3 + 1;
            a(sVar, z, true, i6);
            Iterator q2 = sVar.q();
            while (q2.hasNext()) {
                s sVar4 = (s) q2.next();
                if (!f7569a.contains(sVar4.h())) {
                    a(sVar4, z, false, i6);
                }
            }
            if (z) {
                f(i3);
                a("</rdf:Description>");
                c();
                i2 = i3 - 1;
                i3 = i2;
            }
            z3 = true;
        } else {
            throw new XMPException("Can't mix rdf:resource and general qualifiers", 202);
        }
        if (z4) {
            if (z3) {
                f(i3);
            }
            a("</");
            a(h2);
            e(62);
            c();
        }
    }

    private void a(s sVar, boolean z, int i) throws IOException {
        if (z || sVar.l()) {
            f(i);
            a(z ? "<rdf:" : "</rdf:");
            if (sVar.i().f()) {
                a("Alt");
            } else if (sVar.i().g()) {
                a("Seq");
            } else {
                a("Bag");
            }
            if (z && !sVar.l()) {
                a("/>");
            } else {
                a(">");
            }
            c();
        }
    }

    private void a(String str, boolean z) throws IOException {
        if (str == null) {
            str = "";
        }
        a(k.a(str, z, true));
    }

    private boolean a(s sVar) {
        return (sVar.m() || sVar.i().n() || sVar.i().h() || "[]".equals(sVar.h())) ? false : true;
    }

    private void a(String str) throws IOException {
        this.f7572d.write(str);
    }

    private void a(int i, char c2) throws IOException {
        while (i > 0) {
            this.f7572d.write(c2);
            i--;
        }
    }
}
