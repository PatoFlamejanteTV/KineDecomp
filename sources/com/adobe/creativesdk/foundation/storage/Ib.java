package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryRepresentationDCXNode.java */
/* loaded from: classes.dex */
public class Ib extends com.adobe.creativesdk.foundation.adobeinternal.storage.library.J {

    /* renamed from: d, reason: collision with root package name */
    private C0622wb f7011d;

    /* renamed from: e, reason: collision with root package name */
    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na f7012e;

    /* renamed from: f, reason: collision with root package name */
    private C0614ub f7013f;

    /* compiled from: AdobeLibraryRepresentationDCXNode.java */
    /* loaded from: classes.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        private Ib f7014a;

        a(Ib ib) {
            this.f7014a = null;
            if (ib.b() != null) {
                this.f7014a = ib;
                ib.a(ib.b().i());
            }
        }

        void a() {
            C0225c c0225c;
            Ib ib = this.f7014a;
            if (ib == null || ib.q() == null) {
                return;
            }
            try {
                c0225c = this.f7014a.f7013f.i().p().a((C0225c) this.f7014a.q(), (String) null, false);
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e2);
                c0225c = null;
            }
            this.f7014a.a((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka) null);
            if (c0225c != null) {
                this.f7014a.a(c0225c);
            }
        }
    }

    public Ib(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na, C0614ub c0614ub, C0622wb c0622wb) {
        this.f7012e = na;
        this.f7013f = c0614ub;
        this.f7011d = c0622wb;
        a((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka) null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.J
    public void b(int i) {
        C0614ub c0614ub = this.f7013f;
        if (c0614ub == null || !c0614ub.q()) {
            this.f7013f.s();
            this.f7013f.b();
            a aVar = new a(this);
            super.b(i);
            C0622wb c0622wb = this.f7011d;
            if (c0622wb != null) {
                c0622wb.a();
            }
            this.f7013f.u();
            try {
                this.f7013f.d();
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e2);
            }
            aVar.a();
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public URI c() {
        if (o()) {
            try {
                return new URI((String) d().a("library#linkurl"));
            } catch (URISyntaxException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e2);
            }
        } else {
            com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(b() != null, "getContentURLForRepresentation is only valid for file based representations.");
            com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(b(), this.f7013f.i(), null, false);
            com.adobe.creativesdk.foundation.adobeinternal.cloud.g gVar = (com.adobe.creativesdk.foundation.adobeinternal.cloud.g) this.f7013f.f7445h.m.o();
            if (gVar != null) {
                com.adobe.creativesdk.foundation.internal.net.A c2 = gVar.c("libraries");
                if (a2 != null && c2 != null) {
                    try {
                        return new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(a2.f6610b.toString(), c2.d().toString()));
                    } catch (URISyntaxException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e3);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na d() {
        return this.f7012e;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f() {
        return this.f7012e.c();
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public String g() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = this.f7012e;
        if (na != null) {
            return na.e();
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.J, com.adobe.creativesdk.foundation.storage.Hb
    public String h() {
        return this.f7012e.f();
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.J
    public Object r() {
        return this.f7012e;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public Object a(String str) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = this.f7012e;
        if (na != null) {
            return na.a(str);
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Hb
    public List<String> a() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = this.f7012e;
        return na != null ? na.a() : new ArrayList();
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.J, com.adobe.creativesdk.foundation.storage.Hb
    public boolean a(Object obj, String str, String str2) throws AdobeLibraryException {
        C0614ub c0614ub = this.f7013f;
        if (c0614ub != null && c0614ub.a()) {
            return false;
        }
        this.f7013f.s();
        this.f7013f.b();
        a aVar = new a(this);
        boolean a2 = super.a(obj, str, str2);
        C0622wb c0622wb = this.f7011d;
        if (c0622wb != null) {
            c0622wb.a();
        }
        this.f7013f.u();
        try {
            this.f7013f.d();
        } catch (AdobeLibraryException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e2);
        }
        aVar.a();
        return a2;
    }

    public Ib(C0225c c0225c, C0614ub c0614ub, C0622wb c0622wb) {
        super(c0225c);
        this.f7012e = null;
        this.f7013f = c0614ub;
        this.f7011d = c0622wb;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.J
    public void c(int i) {
        C0614ub c0614ub = this.f7013f;
        if (c0614ub == null || !c0614ub.q()) {
            this.f7013f.s();
            this.f7013f.b();
            a aVar = new a(this);
            super.c(i);
            C0622wb c0622wb = this.f7011d;
            if (c0622wb != null) {
                c0622wb.a();
            }
            this.f7013f.u();
            try {
                this.f7013f.d();
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ib.class.getSimpleName(), null, e2);
            }
            aVar.a();
        }
    }
}
