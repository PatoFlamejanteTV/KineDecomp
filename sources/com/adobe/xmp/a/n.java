package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: XMPIteratorImpl.java */
/* loaded from: classes.dex */
public class n implements com.adobe.xmp.e {

    /* renamed from: a, reason: collision with root package name */
    private com.adobe.xmp.b.b f7529a;

    /* renamed from: b, reason: collision with root package name */
    private String f7530b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f7531c = false;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f7532d = false;

    /* renamed from: e, reason: collision with root package name */
    private Iterator f7533e;

    /* compiled from: XMPIteratorImpl.java */
    /* loaded from: classes.dex */
    private class b extends a {
        private String i;
        private Iterator j;
        private int k;

        public b(s sVar, String str) {
            super();
            this.k = 0;
            if (sVar.i().k()) {
                n.this.a(sVar.h());
            }
            this.i = a(sVar, str, 1);
            this.j = sVar.p();
        }

        @Override // com.adobe.xmp.a.n.a, java.util.Iterator
        public boolean hasNext() {
            if (b() != null) {
                return true;
            }
            if (n.this.f7531c || !this.j.hasNext()) {
                return false;
            }
            s sVar = (s) this.j.next();
            this.k++;
            String str = null;
            if (sVar.i().k()) {
                n.this.a(sVar.h());
            } else if (sVar.getParent() != null) {
                str = a(sVar, this.i, this.k);
            }
            if (n.this.c().e() && sVar.l()) {
                return hasNext();
            }
            a(a(sVar, n.this.b(), str));
            return true;
        }
    }

    public n(p pVar, String str, String str2, com.adobe.xmp.b.b bVar) throws XMPException {
        s b2;
        String str3 = null;
        this.f7530b = null;
        this.f7533e = null;
        this.f7529a = bVar == null ? new com.adobe.xmp.b.b() : bVar;
        boolean z = str != null && str.length() > 0;
        boolean z2 = str2 != null && str2.length() > 0;
        if (!z && !z2) {
            b2 = pVar.a();
        } else if (z && z2) {
            com.adobe.xmp.a.a.b a2 = com.adobe.xmp.a.a.c.a(str, str2);
            com.adobe.xmp.a.a.b bVar2 = new com.adobe.xmp.a.a.b();
            for (int i = 0; i < a2.a() - 1; i++) {
                bVar2.a(a2.a(i));
            }
            b2 = t.a(pVar.a(), a2, false, (com.adobe.xmp.b.e) null);
            this.f7530b = str;
            str3 = bVar2.toString();
        } else if (z && !z2) {
            b2 = t.b(pVar.a(), str, false);
        } else {
            throw new XMPException("Schema namespace URI is required", 101);
        }
        if (b2 != null) {
            if (!this.f7529a.c()) {
                this.f7533e = new a(b2, str3, 1);
                return;
            } else {
                this.f7533e = new b(b2, str3);
                return;
            }
        }
        this.f7533e = Collections.EMPTY_LIST.iterator();
    }

    @Override // com.adobe.xmp.e
    public void a() {
        this.f7532d = true;
    }

    public String b() {
        return this.f7530b;
    }

    protected com.adobe.xmp.b.b c() {
        return this.f7529a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7533e.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f7533e.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("The XMPIterator does not support remove().");
    }

    protected void a(String str) {
        this.f7530b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XMPIteratorImpl.java */
    /* loaded from: classes.dex */
    public class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f7534a;

        /* renamed from: b, reason: collision with root package name */
        private s f7535b;

        /* renamed from: c, reason: collision with root package name */
        private String f7536c;

        /* renamed from: d, reason: collision with root package name */
        private Iterator f7537d;

        /* renamed from: e, reason: collision with root package name */
        private int f7538e;

        /* renamed from: f, reason: collision with root package name */
        private Iterator f7539f;

        /* renamed from: g, reason: collision with root package name */
        private com.adobe.xmp.c.c f7540g;

        public a() {
            this.f7534a = 0;
            this.f7537d = null;
            this.f7538e = 0;
            this.f7539f = Collections.EMPTY_LIST.iterator();
            this.f7540g = null;
        }

        private boolean a(Iterator it) {
            n nVar = n.this;
            if (nVar.f7531c) {
                nVar.f7531c = false;
                this.f7539f = Collections.EMPTY_LIST.iterator();
            }
            if ((n.this.f7532d || !this.f7539f.hasNext()) && it.hasNext()) {
                n.this.f7532d = false;
                s sVar = (s) it.next();
                this.f7538e++;
                this.f7539f = new a(sVar, this.f7536c, this.f7538e);
            }
            if (!this.f7539f.hasNext()) {
                return false;
            }
            this.f7540g = (com.adobe.xmp.c.c) this.f7539f.next();
            return true;
        }

        protected com.adobe.xmp.c.c b() {
            return this.f7540g;
        }

        protected boolean c() {
            this.f7534a = 1;
            if (this.f7535b.getParent() != null && (!n.this.c().e() || !this.f7535b.l())) {
                this.f7540g = a(this.f7535b, n.this.b(), this.f7536c);
                return true;
            }
            return hasNext();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7540g != null) {
                return true;
            }
            int i = this.f7534a;
            if (i == 0) {
                return c();
            }
            if (i == 1) {
                if (this.f7537d == null) {
                    this.f7537d = this.f7535b.p();
                }
                boolean a2 = a(this.f7537d);
                if (a2 || !this.f7535b.m() || n.this.c().f()) {
                    return a2;
                }
                this.f7534a = 2;
                this.f7537d = null;
                return hasNext();
            }
            if (this.f7537d == null) {
                this.f7537d = this.f7535b.q();
            }
            return a(this.f7537d);
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                com.adobe.xmp.c.c cVar = this.f7540g;
                this.f7540g = null;
                return cVar;
            }
            throw new NoSuchElementException("There are no more nodes to return");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public a(s sVar, String str, int i) {
            this.f7534a = 0;
            this.f7537d = null;
            this.f7538e = 0;
            this.f7539f = Collections.EMPTY_LIST.iterator();
            this.f7540g = null;
            this.f7535b = sVar;
            this.f7534a = 0;
            if (sVar.i().k()) {
                n.this.a(sVar.h());
            }
            this.f7536c = a(sVar, str, i);
        }

        protected String a(s sVar, String str, int i) {
            String h2;
            String str2;
            if (sVar.getParent() == null || sVar.i().k()) {
                return null;
            }
            if (sVar.getParent().i().d()) {
                h2 = "[" + String.valueOf(i) + "]";
                str2 = "";
            } else {
                h2 = sVar.h();
                str2 = "/";
            }
            if (str == null || str.length() == 0) {
                return h2;
            }
            if (n.this.c().d()) {
                return !h2.startsWith("?") ? h2 : h2.substring(1);
            }
            return String.valueOf(str) + str2 + h2;
        }

        protected com.adobe.xmp.c.c a(s sVar, String str, String str2) {
            return new m(this, sVar, str, str2, sVar.i().k() ? null : sVar.getValue());
        }

        protected void a(com.adobe.xmp.c.c cVar) {
            this.f7540g = cVar;
        }
    }
}
