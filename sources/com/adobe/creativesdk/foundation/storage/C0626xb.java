package com.adobe.creativesdk.foundation.storage;

import android.graphics.BitmapFactory;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0289s;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryElementDCXNode.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.xb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0626xb extends com.adobe.creativesdk.foundation.adobeinternal.storage.library.I {

    /* renamed from: c, reason: collision with root package name */
    private C0614ub f7467c;

    /* renamed from: d, reason: collision with root package name */
    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na f7468d;

    public C0626xb(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na, C0614ub c0614ub) {
        super(null);
        this.f7468d = na;
        this.f7467c = c0614ub;
    }

    private void a(ArrayList<Hb> arrayList) {
        boolean z;
        if (arrayList.size() < 2) {
            return;
        }
        do {
            z = false;
            for (int i = 1; i < arrayList.size(); i++) {
                int i2 = i - 1;
                Hb hb = arrayList.get(i2);
                Hb hb2 = arrayList.get(i);
                if (hb2.i() < hb.i()) {
                    arrayList.set(i2, hb2);
                    arrayList.set(i, hb);
                    z = true;
                }
            }
        } while (z);
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Object b(String str) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = this.f7468d;
        if (na != null) {
            return na.a(str);
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public String c() {
        return this.f7468d.e();
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public void d(String str) {
        C0614ub c0614ub = this.f7467c;
        if (c0614ub == null || !c0614ub.q()) {
            new C0289s("updateElement", this.f7467c, this, null).a(null);
            this.f7467c.s();
            this.f7467c.b();
            this.f7468d.c(str);
            l();
            this.f7467c.u();
            try {
                this.f7467c.d();
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0626xb.class.getSimpleName(), null, e2);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public String e() {
        return this.f7468d.d();
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f() {
        return this.f7468d.c();
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public String g() {
        return this.f7468d.f();
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Hb h() {
        this.f7467c.s();
        if (this.f7468d == null) {
            this.f7467c.u();
            return null;
        }
        List<C0225c> b2 = this.f7467c.i().p().b(this.f7468d);
        if (b2 != null) {
            for (C0225c c0225c : b2) {
                String l = c0225c.l();
                if (l != null && l.equals("primary")) {
                    Ib ib = new Ib(c0225c, this.f7467c, this);
                    this.f7467c.u();
                    return ib;
                }
            }
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = this.f7467c.i().p().a(this.f7468d);
        if (a2 != null) {
            for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na : a2) {
                String str = (String) na.a("library#rel");
                if (str == null) {
                    str = (String) na.a("relationship");
                }
                if (str != null && str.equals("primary")) {
                    Ib ib2 = new Ib(na, this.f7467c, this);
                    this.f7467c.u();
                    return ib2;
                }
            }
        }
        this.f7467c.u();
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public List<Hb> i() {
        C0614ub c0614ub = this.f7467c;
        if (c0614ub == null || c0614ub.i() == null) {
            return null;
        }
        this.f7467c.s();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na b2 = this.f7467c.b(this);
        if (b2 == null) {
            this.f7467c.u();
            return null;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = this.f7467c.i().p().a(b2);
        List<C0225c> b3 = this.f7467c.i().p().b(b2);
        ArrayList<Hb> arrayList = new ArrayList<>((a2 != null ? a2.size() : 0) + (b3 != null ? b3.size() : 0));
        if (a2 != null) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(new Ib(it.next(), this.f7467c, this));
            }
        }
        if (b3 != null) {
            Iterator<C0225c> it2 = b3.iterator();
            while (it2.hasNext()) {
                arrayList.add(new Ib(it2.next(), this.f7467c, this));
            }
        }
        a(arrayList);
        this.f7467c.u();
        return arrayList;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.I
    public Object k() {
        return this.f7468d;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na b() {
        return this.f7468d;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Hb c(String str) {
        this.f7467c.s();
        if (this.f7468d == null) {
            this.f7467c.u();
            return null;
        }
        C0225c b2 = this.f7467c.i().p().b(str);
        if (b2 != null) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a2 = this.f7467c.i().p().a(b2);
            C0614ub c0614ub = this.f7467c;
            Ib ib = new Ib(b2, c0614ub, a2 != null ? new C0626xb(a2, c0614ub) : null);
            this.f7467c.u();
            return ib;
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na c2 = this.f7467c.i().p().c(str);
        if (c2 != null) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a3 = this.f7467c.i().p().a(c2, new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba());
            C0614ub c0614ub2 = this.f7467c;
            Ib ib2 = new Ib(c2, c0614ub2, a3 != null ? new C0626xb(a3, c0614ub2) : null);
            this.f7467c.u();
            return ib2;
        }
        this.f7467c.u();
        return null;
    }

    public boolean e(String str) throws AdobeLibraryException {
        C0614ub c0614ub;
        if (this.f7468d != null && (c0614ub = this.f7467c) != null && c0614ub.i() != null && this.f7467c.i().p() != null) {
            if (this.f7467c.a()) {
                return false;
            }
            boolean equals = str.equals("primary");
            List<Hb> i = i();
            if ((i != null && !i.isEmpty()) || equals) {
                if (!equals || i == null || !i.isEmpty()) {
                    return true;
                }
                Iterator<Hb> it = i.iterator();
                while (it.hasNext()) {
                    if (it.next().j().equals("primary")) {
                        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementMustHaveOnePrimaryRepresentation, null, null, null);
                    }
                }
                return true;
            }
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementMustHaveOnePrimaryRepresentation, null, null, null);
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementDoesNotExist, null, null, null);
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Hb a(String str) {
        this.f7467c.s();
        if (this.f7468d == null) {
            this.f7467c.u();
            return null;
        }
        List<C0225c> b2 = this.f7467c.i().p().b(this.f7468d);
        if (b2 != null) {
            for (C0225c c0225c : b2) {
                String n = c0225c.n();
                if (n != null && n.equals(str)) {
                    Ib ib = new Ib(c0225c, this.f7467c, this);
                    this.f7467c.u();
                    return ib;
                }
            }
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = this.f7467c.i().p().a(this.f7468d);
        if (a2 != null) {
            for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na : a2) {
                String f2 = na.f();
                if (f2 != null && f2.equals(str)) {
                    Ib ib2 = new Ib(na, this.f7467c, this);
                    this.f7467c.u();
                    return ib2;
                }
            }
        }
        this.f7467c.u();
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public void a() {
        l();
        this.f7467c.d(c());
    }

    private Hb a(String str, String str2, String str3, Integer num, Integer num2, boolean z) throws AdobeLibraryException {
        AdobeDCXException adobeDCXException;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na;
        Object a2;
        Integer num3;
        int i = 0;
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(str != null, "type");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(!str.equals("application/vnd.adobe.library.link+dcx"), "Cannot create external link representation directly.");
        if (!e(str3)) {
            return null;
        }
        List<Hb> i2 = i();
        C0289s c0289s = new C0289s("createElement", this.f7467c, this, str3);
        this.f7467c.s();
        this.f7467c.b();
        String str4 = str2 != null ? "application/vnd.adobe.library.link+dcx" : str;
        boolean equals = str3.equals("primary");
        String a3 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
        try {
            if (equals) {
                na = this.f7467c.i().p().a(null, a3, str4, null, this.f7468d, 0L);
            } else {
                na = this.f7467c.i().p().a((String) null, a3, str4, (String) null, this.f7468d);
            }
            adobeDCXException = null;
        } catch (AdobeDCXException e2) {
            adobeDCXException = e2;
            na = null;
        }
        if (na != null) {
            na.a(str3, "library#rel");
            if (equals) {
                na.a(0, "library#representationOrder");
                for (Hb hb : i2) {
                    if (hb.g() != null) {
                        Object a4 = hb.a("library#representationOrder");
                        if (a4 != null) {
                            num3 = (Integer) a4;
                        }
                        num3 = null;
                    } else {
                        if (hb.b() != null && (a2 = hb.b().a("library#representationOrder")) != null) {
                            num3 = (Integer) a2;
                        }
                        num3 = null;
                    }
                    if (num3 != null) {
                        hb.a(num3.intValue() + 1);
                    }
                }
            } else {
                Hb hb2 = i2.get(i2.size() - 1);
                int size = i2.size();
                if (hb2 != null && hb2.i() != 0) {
                    i = hb2.i() + 1;
                }
                na.a(Integer.valueOf(Math.max(size, i)), "library#representationOrder");
            }
            if (str2 != null) {
                na.c().e("application/vnd.adobe.library.link+dcx");
                na.a(str, "library#linktype");
                na.a(str2, "library#linkurl");
                if (z) {
                    na.a(1, "library#isfullSize");
                }
            }
            a();
            Ib ib = new Ib(na, this.f7467c, this);
            if (num != null) {
                ib.c(num.intValue());
            }
            if (num2 != null) {
                ib.b(num2.intValue());
            }
            this.f7467c.u();
            this.f7467c.d();
            c0289s.a(null);
            return ib;
        }
        this.f7467c.u();
        this.f7467c.d();
        AdobeLibraryException a5 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToAddRepresentation, adobeDCXException, null, null);
        c0289s.a(a5);
        throw a5;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Hb a(String str, String str2) throws AdobeLibraryException {
        return a(str, null, str2, null, null, false);
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0622wb
    public Hb a(String str, String str2, String str3, boolean z, String str4, Integer num, Integer num2, boolean z2) throws AdobeLibraryException {
        AdobeDCXException adobeDCXException;
        C0225c c0225c;
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(str != null, "type");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(!str.equals("application/vnd.adobe.library.link+dcx"), "Cannot create external link representation directly.");
        if (!e(str4)) {
            return null;
        }
        if (z) {
            com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(str3 != null, "sourceHref");
            return a(str, str3, str4, num, num2, z2);
        }
        C0289s c0289s = new C0289s("createElement", this.f7467c, this, str4);
        this.f7467c.s();
        this.f7467c.b();
        String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
        String b2 = org.apache.commons.io.c.b(str2 != null ? str2 : str3);
        if (b2 == null) {
            b2 = "";
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka ka = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ka(a2, String.format("%s.%s", a2, b2), null, str, null, "modified");
        if (num != null) {
            ka.b(num.intValue());
        }
        if (num2 != null) {
            ka.a(num2.intValue());
        }
        if (z2) {
            ka.a(1, "library#isfullSize");
        }
        ka.f(str4);
        if (str4.equals("rendition") && num == null && num2 == null && !z2) {
            BitmapFactory.Options b3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.b(str2);
            if (b3.outWidth > 0 || b3.outHeight > 0) {
                int i = b3.outWidth;
                if (i > 0) {
                    ka.b(i);
                }
                int i2 = b3.outHeight;
                if (i2 > 0) {
                    ka.a(i2);
                }
            }
        }
        try {
            c0225c = this.f7467c.i().p().a((C0225c) ka, this.f7468d, str2, true, str3);
            adobeDCXException = null;
        } catch (AdobeDCXException e2) {
            adobeDCXException = e2;
            c0225c = null;
        }
        if (c0225c == null) {
            this.f7467c.u();
            this.f7467c.d();
            AdobeLibraryException a3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToAddRepresentation, adobeDCXException, str2 != null ? str2 : str3, null);
            c0289s.a(a3);
            throw a3;
        }
        a();
        Ib ib = new Ib(c0225c, this.f7467c, this);
        this.f7467c.u();
        this.f7467c.d();
        c0289s.a(null);
        return ib;
    }
}
