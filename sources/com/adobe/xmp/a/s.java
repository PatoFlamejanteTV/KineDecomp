package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: XMPNode.java */
/* loaded from: classes.dex */
public class s implements Comparable {

    /* renamed from: a */
    private String f7551a;

    /* renamed from: b */
    private String f7552b;

    /* renamed from: c */
    private s f7553c;

    /* renamed from: d */
    private List f7554d;

    /* renamed from: e */
    private List f7555e;

    /* renamed from: f */
    private com.adobe.xmp.b.e f7556f;

    /* renamed from: g */
    private boolean f7557g;

    /* renamed from: h */
    private boolean f7558h;
    private boolean i;
    private boolean j;

    public s(String str, String str2, com.adobe.xmp.b.e eVar) {
        this.f7554d = null;
        this.f7555e = null;
        this.f7556f = null;
        this.f7551a = str;
        this.f7552b = str2;
        this.f7556f = eVar;
    }

    private List D() {
        if (this.f7554d == null) {
            this.f7554d = new ArrayList(0);
        }
        return this.f7554d;
    }

    private List E() {
        if (this.f7555e == null) {
            this.f7555e = new ArrayList(0);
        }
        return this.f7555e;
    }

    private boolean F() {
        return "xml:lang".equals(this.f7551a);
    }

    private boolean G() {
        return "rdf:type".equals(this.f7551a);
    }

    public void B() {
        com.adobe.xmp.b.e i = i();
        i.f(false);
        i.e(false);
        i.g(false);
        this.f7555e = null;
    }

    public void C() {
        if (m()) {
            s[] sVarArr = (s[]) E().toArray(new s[j()]);
            int i = 0;
            while (sVarArr.length > i && ("xml:lang".equals(sVarArr[i].h()) || "rdf:type".equals(sVarArr[i].h()))) {
                sVarArr[i].C();
                i++;
            }
            Arrays.sort(sVarArr, i, sVarArr.length);
            ListIterator listIterator = this.f7555e.listIterator();
            for (int i2 = 0; i2 < sVarArr.length; i2++) {
                listIterator.next();
                listIterator.set(sVarArr[i2]);
                sVarArr[i2].C();
            }
        }
        if (l()) {
            if (!i().d()) {
                Collections.sort(this.f7554d);
            }
            Iterator p = p();
            while (p.hasNext()) {
                ((s) p.next()).C();
            }
        }
    }

    public void a(s sVar) throws XMPException {
        e(sVar.h());
        sVar.f(this);
        D().add(sVar);
    }

    public void b(int i, s sVar) {
        sVar.f(this);
        D().set(i - 1, sVar);
    }

    public void c(s sVar) {
        try {
            Iterator p = p();
            while (p.hasNext()) {
                sVar.a((s) ((s) p.next()).clone());
            }
            Iterator q = q();
            while (q.hasNext()) {
                sVar.b((s) ((s) q.next()).clone());
            }
        } catch (XMPException unused) {
        }
    }

    public Object clone() {
        com.adobe.xmp.b.e eVar;
        try {
            eVar = new com.adobe.xmp.b.e(i().a());
        } catch (XMPException unused) {
            eVar = new com.adobe.xmp.b.e();
        }
        s sVar = new s(this.f7551a, this.f7552b, eVar);
        c(sVar);
        return sVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (i().k()) {
            return this.f7552b.compareTo(((s) obj).getValue());
        }
        return this.f7551a.compareTo(((s) obj).h());
    }

    public void d() {
        this.f7556f = null;
        this.f7551a = null;
        this.f7552b = null;
        this.f7554d = null;
        this.f7555e = null;
    }

    public int e() {
        List list = this.f7554d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public s f(int i) {
        return (s) D().get(i - 1);
    }

    public s g(int i) {
        return (s) E().get(i - 1);
    }

    public s getParent() {
        return this.f7553c;
    }

    public String getValue() {
        return this.f7552b;
    }

    public void h(int i) {
        D().remove(i - 1);
        a();
    }

    public com.adobe.xmp.b.e i() {
        if (this.f7556f == null) {
            this.f7556f = new com.adobe.xmp.b.e();
        }
        return this.f7556f;
    }

    public int j() {
        List list = this.f7555e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List k() {
        return Collections.unmodifiableList(new ArrayList(D()));
    }

    public boolean l() {
        List list = this.f7554d;
        return list != null && list.size() > 0;
    }

    public boolean m() {
        List list = this.f7555e;
        return list != null && list.size() > 0;
    }

    public boolean n() {
        return this.i;
    }

    public boolean o() {
        return this.f7557g;
    }

    public Iterator p() {
        if (this.f7554d != null) {
            return D().iterator();
        }
        return Collections.EMPTY_LIST.listIterator();
    }

    public Iterator q() {
        if (this.f7555e != null) {
            return new r(this, E().iterator());
        }
        return Collections.EMPTY_LIST.iterator();
    }

    public void t() {
        this.f7554d = null;
    }

    public boolean f() {
        return this.f7558h;
    }

    public boolean g() {
        return this.j;
    }

    public void b(s sVar) throws XMPException {
        f(sVar.h());
        sVar.f(this);
        sVar.i().h(true);
        i().f(true);
        if (sVar.F()) {
            this.f7556f.e(true);
            E().add(0, sVar);
        } else if (sVar.G()) {
            this.f7556f.g(true);
            E().add(this.f7556f.c() ? 1 : 0, sVar);
        } else {
            E().add(sVar);
        }
    }

    public void e(s sVar) {
        com.adobe.xmp.b.e i = i();
        if (sVar.F()) {
            i.e(false);
        } else if (sVar.G()) {
            i.g(false);
        }
        E().remove(sVar);
        if (this.f7555e.isEmpty()) {
            i.f(false);
            this.f7555e = null;
        }
    }

    protected void f(s sVar) {
        this.f7553c = sVar;
    }

    public String h() {
        return this.f7551a;
    }

    private void f(String str) throws XMPException {
        if ("[]".equals(str) || b(str) == null) {
            return;
        }
        throw new XMPException("Duplicate '" + str + "' qualifier", 203);
    }

    public void a(int i, s sVar) throws XMPException {
        e(sVar.h());
        sVar.f(this);
        D().add(i - 1, sVar);
    }

    public void d(s sVar) {
        D().remove(sVar);
        a();
    }

    protected void a() {
        if (this.f7554d.isEmpty()) {
            this.f7554d = null;
        }
    }

    public void c(String str) {
        this.f7551a = str;
    }

    public s(String str, com.adobe.xmp.b.e eVar) {
        this(str, null, eVar);
    }

    public void c(boolean z) {
        this.f7558h = z;
    }

    public void d(String str) {
        this.f7552b = str;
    }

    public s a(String str) {
        return a(D(), str);
    }

    public void d(boolean z) {
        this.j = z;
    }

    public void a(com.adobe.xmp.b.e eVar) {
        this.f7556f = eVar;
    }

    private s a(List list, String str) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.h().equals(str)) {
                return sVar;
            }
        }
        return null;
    }

    public void e(boolean z) {
        this.f7557g = z;
    }

    private void e(String str) throws XMPException {
        if ("[]".equals(str) || a(str) == null) {
            return;
        }
        throw new XMPException("Duplicate property or field node '" + str + "'", 203);
    }

    public s b(String str) {
        return a(this.f7555e, str);
    }

    public void b(boolean z) {
        this.i = z;
    }
}
