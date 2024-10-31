package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.zb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.facebook.GraphResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeLibraryCollection.java */
/* loaded from: classes.dex */
public class D implements wb {

    /* renamed from: a, reason: collision with root package name */
    private String f4511a;

    /* renamed from: b, reason: collision with root package name */
    private String f4512b;

    /* renamed from: c, reason: collision with root package name */
    Gb f4513c;

    /* renamed from: d, reason: collision with root package name */
    AdobeCloud f4514d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<C0614ub> f4515e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<C0614ub> f4516f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4517g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4518h;
    public Ya i;
    private boolean j;
    HashMap<String, AdobeCollaborationRoleType> k;
    HashMap<String, AdobeCollaborationType> l;
    public ha m;
    protected ReentrantLock n;
    private B o;
    com.adobe.creativesdk.foundation.internal.net.j p;

    private String h(String str) {
        String s;
        int indexOf;
        String substring;
        int indexOf2;
        if (str == null || (indexOf = str.indexOf((s = s()))) == -1 || (indexOf2 = (substring = str.substring(indexOf + s.length() + 1)).indexOf("/")) == -1) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    private void r() {
        this.f4515e = null;
        this.f4516f = null;
        this.f4511a = null;
        this.f4512b = null;
        this.f4517g = false;
        this.i = null;
        this.j = false;
        this.f4518h = false;
        this.l = new HashMap<>();
        this.k = new HashMap<>();
        this.o = null;
        this.p = null;
        this.n = new ReentrantLock();
    }

    private String s() {
        return com.adobe.creativesdk.foundation.auth.k.a().b().getAdobeID().split("@")[0];
    }

    public boolean a(String str) {
        return false;
    }

    public boolean a(String str, AdobeCloud adobeCloud, AdobeCloudServiceType adobeCloudServiceType, String str2, String str3) throws AdobeLibraryException {
        Observer sessionForService;
        r();
        this.f4513c = Gb.f();
        if (!a(str, adobeCloud)) {
            return false;
        }
        if (adobeCloud != null) {
            this.f4514d = adobeCloud;
            if (adobeCloudServiceType == AdobeCloudServiceType.AdobeCloudServiceTypeCommunity && str2 != null && !ia.b()) {
                URL url = null;
                try {
                    url = new URL(str2);
                } catch (MalformedURLException unused) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "BOOKMARK", "URL Creation execption");
                }
                sessionForService = C0287p.a(com.adobe.creativesdk.foundation.internal.storage.a.a.b.a().a(url), "libraries");
            } else if (str2 != null && str2.length() > 0) {
                try {
                    com.adobe.creativesdk.foundation.internal.net.A a2 = com.adobe.creativesdk.foundation.internal.storage.a.a.b.a().a(new URL(str2));
                    ra raVar = new ra(a2);
                    raVar.a("files", a2);
                    raVar.a("archive", a2);
                    raVar.a("assets", a2);
                    raVar.a("libraries", a2);
                    sessionForService = raVar;
                } catch (MalformedURLException e2) {
                    Observer sessionForService2 = adobeCloud.getSessionForService(adobeCloudServiceType);
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "StorageSession-endpoint failure", "malformed" + e2.getMessage(), e2);
                    sessionForService = sessionForService2;
                }
            } else {
                sessionForService = adobeCloud.getSessionForService(adobeCloudServiceType);
            }
            this.m = new ha();
            this.m.a(this, (zb) sessionForService, str3);
        }
        this.n.lock();
        q();
        this.n.unlock();
        return true;
    }

    public B b() {
        if (this.o == null && !g()) {
            B b2 = new B();
            b2.a(this);
            this.o = b2;
        }
        return this.o;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void b(Ya ya) {
    }

    public ArrayList<C0291u> c() {
        return b().f4507g;
    }

    public ArrayList<C0614ub> d() {
        ArrayList<C0614ub> arrayList;
        synchronized (this) {
            if (this.f4515e == null) {
                q();
            }
            arrayList = this.f4515e;
        }
        return arrayList;
    }

    public String e() {
        return this.f4511a;
    }

    public String f() {
        return this.f4512b;
    }

    public void g(String str) throws AdobeDCXException {
        this.n.lock();
        try {
            this.m.f4632h.remove(str);
            this.n.unlock();
            C0614ub d2 = d(str);
            if (d2 != null) {
                F f2 = (F) d2;
                f2.s();
                try {
                    ((F) d2).i().P();
                    ArrayList<String> arrayList = new ArrayList();
                    List<C0225c> a2 = H.a(f2.i());
                    if (a2 != null) {
                        Iterator<C0225c> it = a2.iterator();
                        while (it.hasNext()) {
                            Ha b2 = f2.i().p().b(it.next());
                            if (b2 != null) {
                                f2.i().p().c(b2);
                                arrayList.add(b2.g());
                            }
                        }
                    }
                    f2.u();
                    for (String str2 : arrayList) {
                        if (this.f4513c.e(str2)) {
                            ((G) this.f4513c).a("elementWasRemoved", d2, str2, d2.c(str2).j());
                        }
                    }
                    this.m.j(str);
                    this.m.e();
                } catch (AdobeDCXException e2) {
                    f2.u();
                    throw e2;
                }
            }
        } catch (Throwable th) {
            this.n.unlock();
            throw th;
        }
    }

    public boolean g() {
        return false;
    }

    public void i() {
        if (this.f4518h) {
            m();
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = this.p;
        if (jVar != null) {
            jVar.a();
        }
        ha haVar = this.m;
        if (haVar != null) {
            haVar.m();
        }
    }

    void j() {
        if (this.f4517g || !((G) this.f4513c).b()) {
            return;
        }
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList = new ArrayList<>();
        this.n.lock();
        try {
            Iterator<C0614ub> it = this.f4515e.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.b a2 = this.i.a(((F) it.next()).i());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            this.n.unlock();
            this.i.a(arrayList);
            this.f4517g = true;
        } catch (Throwable th) {
            this.n.unlock();
            throw th;
        }
    }

    public void k() {
        j();
    }

    void l() {
        if (this.f4517g) {
            this.f4517g = false;
            this.i.a();
        }
    }

    public void m() {
        l();
    }

    public boolean n() {
        return c(false);
    }

    public void o() {
        synchronized (this) {
            this.p = b().a(new C(this, this));
        }
    }

    public void p() {
        synchronized (this) {
            if (!h()) {
                ((G) this.f4513c).a(this);
            }
        }
    }

    public void q() {
        C0231f i;
        ha haVar;
        String c2;
        if (this.f4513c.i()) {
            if (this.f4515e == null) {
                this.f4515e = new ArrayList<>();
                this.f4516f = new ArrayList<>();
            }
            File[] listFiles = new File(this.f4511a).listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    F f2 = null;
                    String name = (g() && ia.d(file.getName())) ? file.getName() : null;
                    if (name == null || ((c2 = ((G) this.f4513c).c(name)) != null && a(c2))) {
                        try {
                            f2 = new F(file.getPath(), this, name);
                        } catch (AdobeLibraryException e2) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Gb.class.getSimpleName(), "Error creating library for path: " + file.getPath(), e2);
                        }
                        if (f2 != null && f2.o() == 1 && (i = f2.i()) != null) {
                            if (!g() && i.p().c().compareTo("pendingDelete") == 0) {
                                this.f4516f.add(f2);
                                if (f2.f() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                                    ha haVar2 = this.m;
                                    if (haVar2 != null && !haVar2.f4631g.contains(f2.k())) {
                                        this.m.f4631g.add(f2.k());
                                    }
                                } else {
                                    ha haVar3 = this.m;
                                    if (haVar3 != null && !haVar3.m.contains(f2.k())) {
                                        this.m.m.add(f2.k());
                                    }
                                }
                            } else {
                                this.f4515e.add(f2);
                            }
                            if (!g() && i.p().c().compareTo("modified") == 0 && (haVar = this.m) != null && !haVar.m.contains(f2.k())) {
                                this.m.m.add(f2.k());
                            }
                        }
                    }
                }
            }
            if (g()) {
                return;
            }
            b().c();
        }
    }

    public boolean c(String str) throws AdobeLibraryException {
        AdobeLibraryException adobeLibraryException = null;
        if (this.f4513c.i()) {
            C0614ub d2 = d(str);
            if (d2 != null && d2.f() != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                boolean z = false;
                try {
                    z = a(d2, (Boolean) true);
                } catch (AdobeLibraryException e2) {
                    adobeLibraryException = e2;
                }
                AdobeLibraryException adobeLibraryException2 = adobeLibraryException;
                ha haVar = this.m;
                if (haVar != null) {
                    haVar.e();
                }
                C0290t.a("deleteLibrary", d2, null, null, null, adobeLibraryException2);
                return z;
            }
            throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorCannotDeleteLibrarySharedWithUser, null, null, null);
        }
        throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(String str) {
        return Za.c(this.f4511a, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:            r3.f4515e.remove(r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(java.lang.String r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r3.n
            r0.lock()
            java.util.ArrayList<com.adobe.creativesdk.foundation.storage.ub> r0 = r3.f4515e     // Catch: java.lang.Throwable -> L2c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L2c
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L26
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L2c
            com.adobe.creativesdk.foundation.storage.ub r1 = (com.adobe.creativesdk.foundation.storage.C0614ub) r1     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = r1.k()     // Catch: java.lang.Throwable -> L2c
            int r2 = r2.compareTo(r4)     // Catch: java.lang.Throwable -> L2c
            if (r2 != 0) goto Lb
            java.util.ArrayList<com.adobe.creativesdk.foundation.storage.ub> r4 = r3.f4515e     // Catch: java.lang.Throwable -> L2c
            r4.remove(r1)     // Catch: java.lang.Throwable -> L2c
        L26:
            java.util.concurrent.locks.ReentrantLock r4 = r3.n
            r4.unlock()
            return
        L2c:
            r4 = move-exception
            java.util.concurrent.locks.ReentrantLock r0 = r3.n
            r0.unlock()
            goto L34
        L33:
            throw r4
        L34:
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.D.f(java.lang.String):void");
    }

    public C0614ub b(String str) {
        AdobeLibraryException adobeLibraryException;
        F f2;
        if (!this.f4513c.i()) {
            return null;
        }
        try {
            f2 = new F(str, this);
            adobeLibraryException = null;
        } catch (AdobeLibraryException e2) {
            adobeLibraryException = e2;
            f2 = null;
        }
        synchronized (this) {
            if (f2 != null) {
                this.f4515e.add(0, f2);
            }
        }
        ha haVar = this.m;
        if (haVar != null) {
            haVar.e();
        }
        C0290t.a("createLibrary", f2, null, null, null, adobeLibraryException);
        com.adobe.creativesdk.foundation.internal.analytics.k kVar = new com.adobe.creativesdk.foundation.internal.analytics.k(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppCreate.getValue());
        if (f2 != null) {
            kVar.a(f2.k(), f2.m(), "", "library", "" + f2.e().size());
            kVar.a(GraphResponse.SUCCESS_KEY);
        } else {
            kVar.a("failure");
        }
        return f2;
    }

    public C0614ub d(String str) {
        C0614ub next;
        this.n.lock();
        try {
            if (this.f4515e == null) {
                q();
            }
            if (this.f4515e != null) {
                Iterator<C0614ub> it = this.f4515e.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (next != null && str != null && next.k().compareTo(str) == 0) {
                        break;
                    }
                }
            }
            if (this.f4516f != null) {
                Iterator<C0614ub> it2 = this.f4516f.iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (next != null && str != null && next.k().compareTo(str) == 0) {
                        return next;
                    }
                }
            }
            this.n.unlock();
            return null;
        } finally {
            this.n.unlock();
        }
    }

    public boolean h() {
        return this.m.j() || this.j || this.p != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(boolean z) {
        ha haVar = this.m;
        if (haVar == null) {
            return false;
        }
        if (haVar.j()) {
            return true;
        }
        if (z) {
            this.i.c();
            return true;
        }
        this.i.b();
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void c(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        if (this.f4517g) {
            this.m.i(bVar.f6611c);
            C0614ub d2 = d(bVar.f6611c);
            if (d2 != null) {
                if (bVar.k != d2.f()) {
                    ((F) d2).i().a(bVar.k);
                    try {
                        ((F) d2).i().c();
                    } catch (AdobeDCXException unused) {
                    }
                    ((G) this.f4513c).a("libraryWasUpdated", d2);
                }
                if (bVar.l != d2.g()) {
                    ((F) d2).i().a(bVar.l);
                    try {
                        ((F) d2).i().c();
                    } catch (AdobeDCXException unused2) {
                    }
                    ((G) this.f4513c).a("libraryWasUpdated", d2);
                    return;
                }
                return;
            }
            this.n.lock();
            try {
                this.l.put(bVar.f6611c, bVar.k);
                this.k.put(bVar.f6611c, bVar.l);
            } finally {
                this.n.unlock();
            }
        }
    }

    public void b(C0614ub c0614ub) {
        ha haVar = this.m;
        if (haVar != null) {
            haVar.j(c0614ub.k());
        }
    }

    boolean b(boolean z) {
        ha haVar = this.m;
        if (haVar == null || haVar.o() == null) {
            return false;
        }
        this.f4518h = z;
        this.i = Ya.a("adobe-libraries", this.m.o(), this, (Handler) null);
        this.i.a(((G) this.f4513c).u());
        ((G) this.f4513c).a(com.adobe.creativesdk.foundation.adobeinternal.net.a.b().a());
        synchronized (this) {
            j();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r14, com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r15) throws com.adobe.creativesdk.foundation.storage.AdobeLibraryException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.D.a(java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud):boolean");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void b(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        if (this.f4517g) {
            this.m.i(bVar.f6611c);
            this.n.lock();
            try {
                this.l.put(bVar.f6611c, bVar.k);
                this.k.put(bVar.f6611c, bVar.l);
            } finally {
                this.n.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C0614ub c0614ub) {
        synchronized (this) {
            this.f4515e.add(c0614ub);
        }
        ((G) Gb.f()).a("libraryWasAdded", c0614ub);
    }

    public boolean a(C0614ub c0614ub, Boolean bool) throws AdobeLibraryException {
        if (c0614ub == null) {
            return true;
        }
        new com.adobe.creativesdk.foundation.internal.analytics.k(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppDelete.getValue()).a(c0614ub.k(), c0614ub.m(), "", "library", "" + c0614ub.e().size());
        String k = c0614ub.k();
        if (!bool.booleanValue()) {
            try {
                ((F) c0614ub).i().P();
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, D.class.getSimpleName(), null, e2);
            }
            try {
                this.n.lock();
                this.f4516f.remove(c0614ub);
                this.n.unlock();
            } finally {
            }
        } else if (((F) c0614ub).i().I()) {
            this.n.lock();
            try {
                this.f4516f.add(c0614ub);
                this.n.unlock();
                if (this.m != null) {
                    if (c0614ub.f() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                        this.m.h(k);
                    } else {
                        this.m.j(k);
                    }
                }
            } finally {
            }
        } else {
            this.n.lock();
            try {
                if (this.m != null) {
                    this.m.i.remove(k);
                    this.m.m.remove(k);
                    this.m.n.remove(k);
                    this.m.j.remove(k);
                    this.m.f4630f.remove(k);
                    this.m.f4632h.remove(k);
                }
                this.f4516f.remove(c0614ub);
                this.n.unlock();
            } finally {
            }
        }
        boolean c2 = ((F) c0614ub).c();
        try {
            this.n.lock();
            this.f4515e.remove(c0614ub);
            return c2;
        } finally {
        }
    }

    public boolean a(boolean z) {
        if (z) {
            return b(z);
        }
        return true;
    }

    public void a() {
        ha haVar = this.m;
        if (haVar != null) {
            haVar.d();
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = this.p;
        if (jVar != null) {
            jVar.a();
        }
    }

    public void a(long j) {
        this.i.a(j);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(Ya ya) {
        synchronized (this) {
            this.j = true;
            this.l.clear();
            this.k.clear();
        }
        ((G) this.f4513c).b(this);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(Ya ya, boolean z) {
        this.m.b(z);
        if (((G) this.f4513c).y()) {
            o();
        }
        synchronized (this) {
            this.j = false;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        String str;
        if (this.f4517g && (str = bVar.f6611c) != null) {
            if (d(str) != null) {
                this.n.lock();
                try {
                    if (this.m.f4630f.contains(bVar.f6611c)) {
                        return;
                    }
                    this.m.b(bVar.f6611c);
                    this.m.a(bVar.f6611c);
                    this.n.unlock();
                    ((G) this.f4513c).a(bVar.f6611c, this);
                } finally {
                    this.n.unlock();
                }
            }
        }
    }
}
