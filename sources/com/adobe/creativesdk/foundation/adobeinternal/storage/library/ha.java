package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.zb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryDownloadPolicyType;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.adobe.creativesdk.foundation.storage.sd;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class ha {
    private zb A;
    private String B;
    private D C;
    Ya D;
    private int G;

    /* renamed from: a, reason: collision with root package name */
    private G f4625a;

    /* renamed from: c, reason: collision with root package name */
    HashMap<String, com.adobe.creativesdk.foundation.internal.net.E> f4627c;

    /* renamed from: d, reason: collision with root package name */
    HashMap<String, com.adobe.creativesdk.foundation.internal.net.E> f4628d;

    /* renamed from: e, reason: collision with root package name */
    HashMap<String, com.adobe.creativesdk.foundation.internal.net.E> f4629e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f4630f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<String> f4631g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<String> f4632h;
    ArrayList<String> i;
    HashMap<String, HashMap<String, ArrayList<C0225c>>> j;
    HashMap<String, HashMap<String, ArrayList<String>>> k;
    HashMap<String, HashMap<String, ArrayList<Integer>>> l;
    ArrayList<String> m;
    ArrayList<String> n;
    ArrayList<String> o;
    ArrayList<String> p;
    ArrayList<String> q;
    ArrayList<String> r;
    private HashMap<String, HashMap<String, String>> s;
    private HashMap<String, HashMap<String, String>> t;
    private HashMap<String, HashMap<String, String>> u;
    private HashMap<String, Integer> v;
    ReentrantLock w;
    private Date x;
    boolean y;
    int z;

    /* renamed from: b, reason: collision with root package name */
    private int f4626b = 1;
    private ArrayList<String> E = null;
    private com.adobe.creativesdk.foundation.internal.net.k F = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha() {
        i();
    }

    private boolean l(String str) {
        boolean z;
        this.w.lock();
        try {
            if (!this.i.contains(str) && !this.m.contains(str) && !this.n.contains(str) && !this.f4630f.contains(str)) {
                if (!this.f4632h.contains(str)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.w.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        Iterator it = new ArrayList(this.C.d()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            C0614ub c0614ub = (C0614ub) it.next();
            ArrayList<String> arrayList = this.E;
            if (arrayList == null || (arrayList.contains(c0614ub.k()) && !l(c0614ub.k()))) {
                F f2 = (F) c0614ub;
                if (a(f2.i(), c0614ub.k(), (C0233g) null)) {
                    z = true;
                    a(f2.i(), c0614ub.k(), false);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        while (!this.f4630f.isEmpty()) {
            this.w.lock();
            try {
                boolean z = false;
                String str = this.f4630f.get(0);
                this.f4630f.remove(0);
                this.w.unlock();
                C0614ub d2 = this.C.d(str);
                if (d2 != null) {
                    AdobeCollaborationType f2 = d2.f();
                    AdobeLibraryException e2 = null;
                    try {
                        z = this.C.a(d2, (Boolean) false);
                    } catch (AdobeLibraryException e3) {
                        e2 = e3;
                    }
                    if (!z) {
                        this.f4625a.a("onSyncError", d2, e2);
                    } else if (f2 == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                        this.f4625a.a("libraryWasUnshared", str);
                    } else {
                        this.f4625a.a("libraryWasDeleted", str);
                    }
                }
            } catch (Throwable th) {
                this.w.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        while (!this.f4631g.isEmpty()) {
            this.w.lock();
            try {
                String str = this.f4631g.get(0);
                this.f4631g.remove(0);
                this.w.unlock();
                C0614ub d2 = this.C.d(str);
                ((ra) this.A).b(((F) d2).i(), new T(this, str, d2), (Handler) null);
            } catch (Throwable th) {
                this.w.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        boolean z;
        synchronized (this) {
            z = this.f4627c.size() != 0;
        }
        return z;
    }

    void i() {
        this.w = new ReentrantLock();
        this.G++;
        this.D = null;
        this.m = new ArrayList<>();
        this.i = new ArrayList<>();
        this.n = new ArrayList<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.f4630f = new ArrayList<>();
        this.f4632h = new ArrayList<>();
        this.f4631g = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new HashMap<>();
        this.u = new HashMap<>();
        this.v = new HashMap<>();
        int i = this.f4626b;
        this.F = new com.adobe.creativesdk.foundation.internal.net.k(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        synchronized (this) {
            this.y = false;
            this.z = 0;
            this.f4628d = new HashMap<>();
            this.f4627c = new HashMap<>();
            this.f4629e = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        synchronized (this) {
            this.w.lock();
            try {
                if (this.f4628d.get(str) == null && this.f4627c.get(str) == null && !this.i.contains(str) && !this.n.contains(str) && !this.f4631g.contains(str)) {
                    int indexOf = this.m.indexOf(str);
                    if (indexOf != -1) {
                        this.m.remove(indexOf);
                    }
                    this.m.add(0, str);
                    this.w.unlock();
                    if (this.f4625a.o() && !this.y) {
                        a(false, false);
                    }
                }
            } finally {
                this.w.unlock();
            }
        }
    }

    public boolean k(String str) {
        synchronized (this) {
            this.w.lock();
            try {
                if (this.f4628d.get(str) == null && this.f4627c.get(str) == null) {
                    this.i.remove(str);
                    this.m.remove(str);
                    return true;
                }
                return false;
            } finally {
                this.w.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.F.shutdown();
        this.F = null;
        b();
        c();
        a();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.C.p();
        if (this.z == 1) {
            new Thread(new W(this)).start();
        }
        this.z = 0;
    }

    public zb o() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void p() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha.p():void");
    }

    void b() {
        synchronized (this) {
            Iterator<com.adobe.creativesdk.foundation.internal.net.E> it = this.f4628d.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f4628d.clear();
        }
    }

    void c() {
        synchronized (this) {
            Iterator<com.adobe.creativesdk.foundation.internal.net.E> it = this.f4627c.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f4627c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        b();
        c();
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        synchronized (this) {
            if (this.f4625a.o() && !this.y) {
                a(false, false);
            }
        }
    }

    public String f(String str) {
        String str2 = this.B;
        if (str2 != null) {
            return Za.c(this.A.b(str2), str);
        }
        return this.f4625a.c(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        boolean z;
        synchronized (this) {
            z = this.f4628d.size() != 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        this.w.lock();
        try {
            this.i.remove(str);
            this.m.remove(str);
            this.n.remove(str);
            this.j.remove(str);
            this.f4632h.remove(str);
            this.f4630f.remove(str);
            this.f4631g.add(str);
        } finally {
            this.w.unlock();
        }
    }

    public void l() {
        com.adobe.creativesdk.foundation.internal.net.A c2;
        if (this.A == null || (c2 = f().c("libraries")) == null) {
            return;
        }
        c2.g();
    }

    HashMap<String, String> d(String str) {
        HashMap<String, String> hashMap = this.u.get(str);
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.u.put(str, hashMap2);
        return hashMap2;
    }

    public com.adobe.creativesdk.foundation.adobeinternal.cloud.g f() {
        return (com.adobe.creativesdk.foundation.adobeinternal.cloud.g) this.A;
    }

    public void g(String str) {
        this.w.lock();
        try {
            if (this.f4631g.contains(str)) {
                return;
            }
            this.i.remove(str);
            this.m.remove(str);
            this.n.remove(str);
            this.j.remove(str);
            this.f4632h.remove(str);
            this.f4630f.add(str);
        } finally {
            this.w.unlock();
        }
    }

    HashMap<String, String> e(String str) {
        HashMap<String, String> hashMap = this.t.get(str);
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.t.put(str, hashMap2);
        return hashMap2;
    }

    boolean b(String str, String str2) {
        this.w.lock();
        try {
            return this.t.get(str2).get(str) != null;
        } finally {
            this.w.unlock();
        }
    }

    HashMap<String, String> c(String str) {
        HashMap<String, String> hashMap = this.s.get(str);
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.s.put(str, hashMap2);
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(D d2, zb zbVar, String str) {
        this.G = 0;
        this.A = zbVar;
        this.B = str;
        this.C = d2;
        this.f4625a = (G) Gb.f();
    }

    boolean c(String str, String str2) {
        this.w.lock();
        try {
            return this.s.get(str2).get(str) != null;
        } finally {
            this.w.unlock();
        }
    }

    void k() {
        this.w.lock();
        try {
            Iterator<C0614ub> it = this.C.d().iterator();
            while (it.hasNext()) {
                C0614ub next = it.next();
                C0231f i = ((F) next).i();
                if (i != null && i.p() != null && i.p().c().equals("modified") && !this.f4632h.contains(next.k()) && !this.m.contains(next.k()) && !this.f4630f.contains(next.k())) {
                    this.m.add(next.k());
                }
            }
            Iterator<C0614ub> it2 = this.C.f4516f.iterator();
            while (it2.hasNext()) {
                C0614ub next2 = it2.next();
                C0231f i2 = ((F) next2).i();
                if (i2 != null && i2.p() != null && next2.f() != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER && !this.m.contains(next2.k())) {
                    this.m.add(next2.k());
                }
            }
        } finally {
            this.w.unlock();
        }
    }

    void b(String str, C0614ub c0614ub, boolean z) {
        C0622wb c2 = c0614ub.c(str);
        if (z) {
            this.f4625a.a("elementWasAdded", c0614ub, str, c2 != null ? c2.j() : null);
        } else {
            this.f4625a.a("elementWasUpdated", c0614ub, str, c2 != null ? c2.j() : null);
        }
    }

    void a() {
        synchronized (this) {
            Iterator<com.adobe.creativesdk.foundation.internal.net.E> it = this.f4629e.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f4629e.clear();
        }
    }

    private C0235h b(C0231f c0231f, C0233g c0233g, String str) throws AdobeLibraryException {
        C0235h c0235h;
        this.w.lock();
        try {
            try {
                c0235h = H.a(c0231f, c0233g, new ga(this, c(str), e(str), d(str)), this.f4625a.d(), this.C);
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
                c0235h = null;
            }
            return c0235h;
        } finally {
            this.w.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) throws AdobeDCXException {
        AdobeDCXException adobeDCXException;
        C0231f c0231f;
        com.adobe.creativesdk.foundation.internal.net.E a2;
        ArrayList<String> arrayList = z ? this.n : this.i;
        while (!arrayList.isEmpty() && this.f4625a.b()) {
            this.w.lock();
            try {
                String str = arrayList.get(0);
                arrayList.remove(0);
                this.o.add(str);
                this.w.unlock();
                String e2 = this.C.e(str);
                String f2 = f(str);
                try {
                    c0231f = C0231f.a(e2, (Aa) null);
                    adobeDCXException = null;
                } catch (AdobeDCXException e3) {
                    adobeDCXException = e3;
                    c0231f = null;
                }
                if (c0231f == null || adobeDCXException != null) {
                    c0231f = C0231f.a(URI.create(f2), str, e2, (Aa) null);
                }
                int i = this.G;
                if ((this.f4625a.d() == null || this.f4625a.d().isEmpty()) && this.f4625a.t() == null && this.f4625a.t() == AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestRenditionsAndAssets) {
                    a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(c0231f, this.A, new Q(this, i, c0231f, str), (Handler) null);
                } else {
                    a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.b(c0231f, this.A, new S(this, i, c0231f, str), null);
                }
                synchronized (this) {
                    this.f4628d.put(str, a2);
                }
            } catch (Throwable th) {
                this.w.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        boolean z2;
        synchronized (this) {
            if (g() || h()) {
                z2 = false;
            } else {
                if (this.y) {
                    this.y = false;
                    if (!z || !this.f4625a.b()) {
                        this.x = new Date();
                        n();
                    }
                }
                z2 = true;
            }
        }
        if (z2 && z && !this.f4625a.l()) {
            a(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.w.lock();
        try {
            if (this.m.contains(str)) {
                this.m.remove(str);
            }
            if (this.p.contains(str)) {
                synchronized (this) {
                    com.adobe.creativesdk.foundation.internal.net.E e2 = this.f4627c.get(str);
                    if (e2 != null) {
                        e2.a();
                        this.f4627c.remove(str);
                    }
                    this.p.remove(str);
                }
            }
        } finally {
            this.w.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.storage.C0614ub r11, boolean r12, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException r13) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha.a(com.adobe.creativesdk.foundation.storage.ub, boolean, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        this.w.lock();
        try {
            if (this.f4628d.get(str) == null && !this.i.contains(str) && !this.n.contains(str) && !this.f4631g.contains(str)) {
                this.i.add(str);
            }
        } finally {
            this.w.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.y) {
            return;
        }
        this.z = z ? -1 : 0;
        this.w.lock();
        try {
            this.v.clear();
            this.w.unlock();
            k();
            a(true, true);
        } catch (Throwable th) {
            this.w.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Integer num, AdobeCSDKException adobeCSDKException, C0614ub c0614ub, boolean z, int i) {
        this.w.lock();
        if (this.f4625a.i() && i == this.G) {
            boolean z2 = false;
            try {
                HashMap<String, ArrayList<Integer>> hashMap = this.l.get(c0614ub.k());
                ArrayList<Integer> arrayList = hashMap.get(str);
                arrayList.remove(num);
                if (arrayList.isEmpty()) {
                    hashMap.remove(str);
                    z2 = true;
                }
                if (adobeCSDKException != null) {
                    this.f4625a.a("onSyncError", c0614ub, adobeCSDKException);
                }
                if (z2 && !a(c0614ub.c(str), c0614ub, z)) {
                    b(str, c0614ub, z);
                }
                synchronized (this) {
                    this.f4628d.remove(str + ":" + Long.toString(num.intValue()));
                }
                this.w.unlock();
                a(true);
            } finally {
                this.w.unlock();
            }
        }
    }

    boolean a(String str, C0614ub c0614ub, boolean z) {
        C0622wb c2;
        ArrayList<Integer> arrayList;
        C0614ub c0614ub2 = c0614ub;
        HashMap<String, ArrayList<Integer>> v = this.f4625a.v();
        ArrayList<String> arrayList2 = this.E;
        if (!(arrayList2 == null || arrayList2.contains(c0614ub.k())) || v == null || (c2 = c0614ub2.c(str)) == null) {
            return false;
        }
        this.w.lock();
        try {
            ArrayList<Integer> arrayList3 = v.get(c2.j());
            if (arrayList3 == null) {
                arrayList3 = v.get("*");
            }
            if (arrayList3 == null || arrayList3.isEmpty()) {
                return false;
            }
            ArrayList<Integer> arrayList4 = new ArrayList<>(arrayList3.size());
            HashMap<String, ArrayList<Integer>> hashMap = this.l.get(c0614ub.k());
            this.w.lock();
            if (hashMap == null) {
                try {
                    hashMap = new HashMap<>();
                    this.l.put(c0614ub.k(), hashMap);
                } finally {
                }
            }
            hashMap.put(str, arrayList4);
            this.w.unlock();
            Iterator<Integer> it = arrayList3.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Integer next = it.next();
                if (next != null) {
                    this.w.lock();
                    try {
                        arrayList4.add(next);
                        this.w.unlock();
                        ArrayList<com.adobe.creativesdk.foundation.internal.net.E> arrayList5 = new ArrayList<>();
                        int i = this.G;
                        synchronized (this) {
                            arrayList = arrayList4;
                            if (((F) c0614ub2).a(str, next.intValue(), next.intValue() == 0, new Y(this, i, str, next, c0614ub, z), new Z(this, i, str, next, c0614ub, z), null, arrayList5)) {
                                if (!arrayList5.isEmpty()) {
                                    synchronized (this) {
                                        this.f4628d.put(str + ":" + next, arrayList5.get(0));
                                    }
                                }
                                z2 = true;
                            }
                        }
                        c0614ub2 = c0614ub;
                        arrayList4 = arrayList;
                    } finally {
                    }
                }
            }
            return z2;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, AdobeCSDKException adobeCSDKException, C0614ub c0614ub, boolean z, int i) {
        boolean z2;
        this.w.lock();
        if (this.f4625a.i() && i == this.G) {
            HashMap<String, ArrayList<String>> hashMap = this.k.get(c0614ub.k());
            ArrayList<String> arrayList = hashMap.get(str);
            arrayList.remove(str2);
            if (arrayList.isEmpty()) {
                hashMap.remove(str);
                if (hashMap.size() == 0) {
                    this.k.remove(c0614ub.k());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.w.unlock();
            if (adobeCSDKException != null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, ha.class.getSimpleName(), String.format("Error getting external asset for element id: %s, representation id:%s. Error: %s", str, str2, adobeCSDKException));
                this.f4625a.a("onSyncError", c0614ub, adobeCSDKException);
            }
            if (z2) {
                b(str, c0614ub, z);
            }
            synchronized (this) {
                this.f4628d.remove(String.format("%s:%s:%s", c0614ub.k(), str, str2));
            }
            a(true);
            return;
        }
        this.w.unlock();
    }

    boolean a(C0622wb c0622wb, C0614ub c0614ub, boolean z) {
        String str;
        this.w.lock();
        HashMap<String, ArrayList<String>> hashMap = this.k.get(c0614ub != null ? c0614ub.k() : null);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.k.put(c0614ub != null ? c0614ub.k() : null, hashMap);
        }
        this.w.unlock();
        if (c0622wb != null && c0614ub != null) {
            F f2 = (F) c0614ub;
            if (f2.i() != null) {
                String c2 = c0622wb.c();
                List<Na> a2 = f2.i().p().a(c0622wb.b());
                if (a2 != null && !a2.isEmpty()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (Na na : a2) {
                        if (na.f().equals("application/vnd.adobe.library.link+dcx") && (str = (String) na.a("library#linktype")) != null && this.f4625a.t() == AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestRenditionsAndAssets && this.f4625a.g(str) && f2.a(na)) {
                            arrayList.add(na.e());
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.w.lock();
                        hashMap.put(c2, arrayList);
                        this.w.unlock();
                        Iterator it = new ArrayList(arrayList).iterator();
                        boolean z2 = false;
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            Hb c3 = c0622wb.c(str2);
                            if (c3 != null) {
                                ArrayList<com.adobe.creativesdk.foundation.internal.net.E> arrayList2 = new ArrayList<>();
                                int i = this.G;
                                synchronized (this) {
                                    if (((F) c0614ub).a(c3, new aa(this, c2, str2, c0614ub, z, i), new ba(this, c2, str2, c0614ub, z, i), (Handler) null, arrayList2)) {
                                        this.f4628d.put(String.format("%s:%s:%s", c0614ub.k(), c2, str2), arrayList2.get(0));
                                        z2 = true;
                                    }
                                }
                            }
                        }
                        return z2;
                    }
                }
                return false;
            }
        }
        return false;
    }

    void a(C0231f c0231f, String str) {
        List<C0225c> b2;
        ArrayList<C0225c> arrayList;
        HashMap hashMap;
        HashMap hashMap2;
        C0614ub d2 = this.C.d(str);
        if (d2 != null) {
            ((F) d2).a(c0231f, this.C.g() ? d2.k() : null);
            this.w.lock();
            try {
                HashMap<String, ArrayList<C0225c>> hashMap3 = this.j.get(str);
                HashMap<String, String> hashMap4 = this.s.get(str);
                HashMap<String, String> hashMap5 = this.t.get(str);
                HashMap<String, String> hashMap6 = this.u.get(str);
                if (hashMap4 != null) {
                    hashMap = new HashMap();
                    for (String str2 : hashMap4.keySet()) {
                        ArrayList<C0225c> arrayList2 = hashMap3.get(str2);
                        if (arrayList2 == null || arrayList2.isEmpty()) {
                            hashMap.put(str2, hashMap4.get(str2));
                        }
                    }
                    Iterator it = hashMap.keySet().iterator();
                    while (it.hasNext()) {
                        hashMap4.remove((String) it.next());
                    }
                } else {
                    hashMap = null;
                }
                if (hashMap5 != null) {
                    hashMap2 = new HashMap();
                    for (String str3 : hashMap5.keySet()) {
                        ArrayList<C0225c> arrayList3 = hashMap3.get(str3);
                        if (arrayList3 == null || arrayList3.isEmpty()) {
                            ((F) d2).d(str3);
                            hashMap2.put(str3, hashMap5.get(str3));
                        }
                    }
                    Iterator it2 = hashMap2.keySet().iterator();
                    while (it2.hasNext()) {
                        hashMap5.remove((String) it2.next());
                    }
                } else {
                    hashMap2 = null;
                }
                r2 = hashMap6 != null ? new HashMap(hashMap6) : null;
                if (hashMap6 != null) {
                    hashMap6.clear();
                }
                this.w.unlock();
                this.f4625a.a("libraryWasUpdated", d2);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    for (String str4 : hashMap2.keySet()) {
                        if (!a(str4, d2, false) && a(str4, d2)) {
                            this.f4625a.a("elementWasUpdated", d2, str4, (String) hashMap2.get(str4));
                        }
                    }
                }
                if (r2 != null && r2.size() > 0) {
                    for (String str5 : r2.keySet()) {
                        this.f4625a.a("elementWasRemoved", d2, str5, (String) r2.get(str5));
                    }
                }
                r2 = hashMap;
            } finally {
            }
        } else {
            try {
                d2 = new F(c0231f, this.C, this.C.g() ? str : null);
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
            }
            if (d2 != null && d2.o() == 1) {
                this.w.lock();
                try {
                    AdobeCollaborationType adobeCollaborationType = this.C.l.get(d2.k());
                    if (adobeCollaborationType != null) {
                        ((F) d2).i().a(adobeCollaborationType);
                        this.C.l.remove(d2.k());
                        try {
                            c0231f.c();
                        } catch (AdobeDCXException e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e3);
                        }
                    }
                    AdobeCollaborationRoleType adobeCollaborationRoleType = this.C.k.get(d2.k());
                    if (adobeCollaborationRoleType != null) {
                        d2.a(adobeCollaborationRoleType);
                        this.C.k.remove(d2.k());
                        try {
                            c0231f.c();
                        } catch (AdobeDCXException e4) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e4);
                        }
                    }
                    this.C.a(d2);
                    this.w.unlock();
                    this.f4625a.a("libraryWasAdded", d2);
                    r2 = new HashMap();
                    ArrayList<C0622wb> e5 = d2.e();
                    HashMap<String, ArrayList<C0225c>> hashMap7 = this.j.get(str);
                    Iterator<C0622wb> it3 = e5.iterator();
                    while (it3.hasNext()) {
                        C0622wb next = it3.next();
                        if (this.f4625a.t() != AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestRenditionsAndAssets || (b2 = ((F) d2).i().p().b(next.b())) == null || !b2.isEmpty() || (arrayList = hashMap7.get(next.c())) == null || arrayList.isEmpty()) {
                            r2.put(next.c(), next.j());
                        }
                    }
                } finally {
                }
            }
        }
        if (r2 == null || r2.size() <= 0) {
            return;
        }
        for (String str6 : r2.keySet()) {
            a(d2.c(str6), (String) r2.get(str6), d2, "elementWasAdded", true);
        }
    }

    void a(C0622wb c0622wb, String str, C0614ub c0614ub, String str2, boolean z) {
        if (a(c0622wb != null ? c0622wb.c() : null, c0614ub, z) || a(c0622wb, c0614ub, z)) {
            return;
        }
        if (str == null || this.f4625a.e(str)) {
            G g2 = this.f4625a;
            String c2 = c0622wb != null ? c0622wb.c() : null;
            if (str == null) {
                str = c0622wb != null ? c0622wb.j() : null;
            }
            g2.a(str2, c0614ub, c2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b A[Catch: all -> 0x0122, TRY_LEAVE, TryCatch #0 {all -> 0x0122, blocks: (B:10:0x005e, B:12:0x007b), top: B:9:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #2 {all -> 0x00e8, blocks: (B:36:0x00d8, B:38:0x00df), top: B:35:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r16, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r17, java.lang.String r18, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g r19, boolean r20, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException r21) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha.a(java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g, boolean, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException):void");
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(Hb hb, String str, C0231f c0231f, String str2, sd<String, AdobeCSDKException> sdVar) {
        ArrayList<AdobeLibraryException> arrayList = new ArrayList<>();
        if (!this.f4625a.a(arrayList)) {
            this.F.execute(new ca(this, sdVar, arrayList));
            return null;
        }
        C0225c b2 = hb.b();
        int i = this.G;
        G g2 = this.f4625a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(b2);
        com.adobe.creativesdk.foundation.internal.net.E a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a((ArrayList<C0225c>) arrayList2, c0231f.p(), this.A, new fa(this, g2, b2, i, c0231f, sdVar, str, str2, hb), (Handler) null);
        synchronized (g2) {
            this.f4629e.put(b2.b(), a2);
        }
        return a2;
    }

    private void a(C0231f c0231f, C0233g c0233g, String str) {
        this.w.lock();
        try {
            H.a(c0231f, c0233g, (C0233g) null, new N(this, c(str), e(str), d(str)), this.f4625a.d());
        } finally {
            this.w.unlock();
        }
    }

    boolean a(C0225c c0225c, C0233g c0233g, C0233g c0233g2) {
        String str = null;
        C0225c b2 = c0233g2 != null ? c0233g2.b(c0225c.b()) : null;
        if (c0233g != null) {
            try {
                str = c0233g.c(c0225c);
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
            }
        }
        return c0233g == null || str == null || b2 == null || !b2.d().equals(c0225c.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0614ub c0614ub, c.a.a.a.b<Boolean> bVar, c.a.a.a.c<AdobeCSDKException> cVar, Handler handler) {
        this.A.a(((F) c0614ub).i(), new O(this, c0614ub, bVar, cVar), handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.w.lock();
        try {
            this.f4632h.add(str);
        } finally {
            this.w.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r13, java.lang.String r14, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g r15) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g):boolean");
    }

    private void a(C0231f c0231f, String str, boolean z) {
        HashMap<String, ArrayList<C0225c>> hashMap;
        HashMap<String, ArrayList<C0225c>> hashMap2 = this.j.get(str);
        if (hashMap2 == null || hashMap2.size() <= 0) {
            return;
        }
        ArrayList<String> a2 = a(hashMap2);
        int i = this.G;
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!this.f4625a.b()) {
                return;
            }
            ArrayList<C0225c> arrayList = hashMap2.get(next);
            if (arrayList == null || arrayList.isEmpty()) {
                hashMap = hashMap2;
            } else {
                hashMap = hashMap2;
                com.adobe.creativesdk.foundation.internal.net.E a3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(arrayList, c0231f.p(), (ra) this.A, new P(this, i, next, c0231f, str, z), (Handler) null);
                synchronized (this) {
                    this.f4628d.put(next, a3);
                }
            }
            hashMap2 = hashMap;
        }
    }

    static ArrayList<String> a(HashMap<String, ArrayList<C0225c>> hashMap) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<C0225c>>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r11, java.lang.String r12, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g r13, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException r14) throws com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException):void");
    }

    void a(boolean z, boolean z2) {
        com.adobe.creativesdk.foundation.internal.net.k kVar;
        if (this.f4625a.b() && (kVar = this.F) != null) {
            kVar.execute(new U(this, this, z2, z));
        }
    }

    boolean a(String str, String str2) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        String format = String.format("%s-%s", objArr);
        this.w.lock();
        try {
            int intValue = this.v.containsKey(format) ? this.v.get(format).intValue() : 0;
            this.v.put(format, Integer.valueOf(intValue + 1));
            this.w.unlock();
            return intValue <= 5;
        } catch (Throwable th) {
            this.w.unlock();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0061. Please report as an issue. */
    boolean a(C0231f c0231f, String str, AdobeCSDKException adobeCSDKException, Boolean[] boolArr, Boolean[] boolArr2) throws AdobeCSDKException {
        if (!this.f4625a.b()) {
            return true;
        }
        boolean z = false;
        if (adobeCSDKException instanceof AdobeAssetException) {
            int i = V.f4557a[((AdobeAssetException) adobeCSDKException).getErrorCode().ordinal()];
            if (i == 1) {
                boolArr[0] = true;
            } else {
                if (i == 2) {
                    throw adobeCSDKException;
                }
                if (i == 3) {
                    boolArr[0] = true;
                } else if (i == 4) {
                    boolArr2[0] = true;
                } else if (i != 5) {
                    z = a(str, (String) null);
                    if (!z) {
                        throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str);
                    }
                } else {
                    throw adobeCSDKException;
                }
            }
        } else if (adobeCSDKException instanceof AdobeNetworkException) {
            switch (V.f4558b[((AdobeNetworkException) adobeCSDKException).getErrorCode().ordinal()]) {
                case 1:
                    z = a(str, (String) null);
                    if (!z) {
                        throw adobeCSDKException;
                    }
                    break;
                case 2:
                    z = a(str, (String) null);
                    if (z) {
                        com.adobe.creativesdk.foundation.internal.net.A c2 = ((ra) this.A).c("libraries");
                        if (c2 != null) {
                            c2.g();
                            break;
                        }
                    } else {
                        throw adobeCSDKException;
                    }
                    break;
                case 3:
                case 4:
                    z = a(str, (String) null);
                    if (!z) {
                        throw adobeCSDKException;
                    }
                    break;
                case 5:
                    if (c0231f.i() != null) {
                        boolArr2[0] = true;
                        break;
                    }
                case 6:
                    this.f4625a.c(true);
                    throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToUserSession, adobeCSDKException, null, str);
                default:
                    z = a(str, (String) null);
                    if (!z) {
                        throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str);
                    }
                    break;
            }
        } else if (adobeCSDKException instanceof AdobeDCXException) {
            int i2 = V.f4559c[((AdobeDCXException) adobeCSDKException).getErrorCode().ordinal()];
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3) {
                    z = a(str, (String) null);
                    if (!z) {
                        throw ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str);
                    }
                } else if (c0231f != null && c0231f.p() != null) {
                    try {
                        c0231f.P();
                    } catch (AdobeDCXException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
                    }
                    this.f4625a.a(str, this.C);
                } else {
                    g(str);
                }
            }
        } else {
            z = a(str, (String) null);
            if (!z) {
                throw adobeCSDKException;
            }
        }
        return z;
    }

    private boolean a(C0231f c0231f, String str, AdobeCSDKException adobeCSDKException, ArrayList<AdobeCSDKException> arrayList) {
        if (!this.f4625a.b()) {
            return true;
        }
        boolean z = false;
        if (adobeCSDKException instanceof AdobeNetworkException) {
            int i = V.f4558b[((AdobeNetworkException) adobeCSDKException).getErrorCode().ordinal()];
            if (i == 1) {
                z = a(str, (String) null);
                if (!z) {
                    arrayList.add(adobeCSDKException);
                }
            } else if (i == 2) {
                z = a(str, (String) null);
                if (!z) {
                    arrayList.add(adobeCSDKException);
                } else {
                    com.adobe.creativesdk.foundation.internal.net.A c2 = f().c("libraries");
                    if (c2 != null) {
                        c2.g();
                    }
                }
            } else if (i == 3 || i == 4) {
                z = a(str, (String) null);
                if (!z) {
                    arrayList.add(adobeCSDKException);
                }
            } else if (i != 6) {
                z = a(str, (String) null);
                if (!z) {
                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str));
                }
            } else {
                this.f4625a.c(true);
                arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToUserSession, adobeCSDKException, null, str));
            }
        } else if (adobeCSDKException instanceof AdobeDCXException) {
            int i2 = V.f4559c[((AdobeDCXException) adobeCSDKException).getErrorCode().ordinal()];
            if (i2 != 2) {
                if (i2 == 4) {
                    this.f4625a.a(str, this.C);
                } else if (i2 != 5 && i2 != 6 && i2 != 7) {
                    z = a(str, (String) null);
                    if (!z) {
                        arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str));
                    }
                } else {
                    try {
                        c0231f.f();
                    } catch (AdobeDCXException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
                    }
                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncWriteFailure, adobeCSDKException, null, str));
                }
            } else if (c0231f.p() != null && c0231f.p().c().equals("modified")) {
                this.f4625a.a(str, this.C);
            } else {
                g(str);
            }
        } else {
            z = a(str, (String) null);
            if (!z) {
                arrayList.add(adobeCSDKException);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdobeCSDKException adobeCSDKException, String str, String str2, ArrayList<AdobeCSDKException> arrayList) {
        com.adobe.creativesdk.foundation.internal.net.A c2;
        if (!this.f4625a.b()) {
            return true;
        }
        boolean z = false;
        if (adobeCSDKException instanceof AdobeNetworkException) {
            int i = V.f4558b[((AdobeNetworkException) adobeCSDKException).getErrorCode().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                z = a(str2, str);
                                if (!z) {
                                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str2));
                                }
                            }
                        }
                    }
                    this.f4625a.c(true);
                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToUserSession, adobeCSDKException, null, str2));
                } else {
                    z = a(str2, str);
                    if (!z) {
                        arrayList.add(adobeCSDKException);
                    } else if (this.A != null && (c2 = f().c("libraries")) != null) {
                        c2.g();
                    }
                }
            }
            z = a(str2, str);
            if (!z) {
                arrayList.add(adobeCSDKException);
            }
        } else if (adobeCSDKException instanceof AdobeDCXException) {
            int i2 = V.f4559c[((AdobeDCXException) adobeCSDKException).getErrorCode().ordinal()];
            if (i2 == 6 || i2 == 7) {
                arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncWriteFailure, adobeCSDKException, null, str2));
            } else if (i2 != 8) {
                z = a(str2, str);
                if (!z) {
                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncUnexpectedError, adobeCSDKException, null, str2));
                }
            } else {
                arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorInvalidLibraryComposite, adobeCSDKException, null, str2));
            }
        } else {
            z = a(str2, str);
            if (!z) {
                arrayList.add(adobeCSDKException);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdobeCSDKException adobeCSDKException, String str, ArrayList<AdobeCSDKException> arrayList) {
        com.adobe.creativesdk.foundation.internal.net.A c2;
        if (!this.f4625a.b()) {
            return true;
        }
        if (adobeCSDKException instanceof AdobeNetworkException) {
            int i = V.f4558b[((AdobeNetworkException) adobeCSDKException).getErrorCode().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                boolean a2 = a(str, (String) null);
                                if (a2) {
                                    return a2;
                                }
                                arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLeavingSharedLibrary, adobeCSDKException, null, str));
                                return a2;
                            }
                        }
                    }
                    this.f4625a.c(true);
                    arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToUserSession, adobeCSDKException, null, str));
                    return true;
                }
                boolean a3 = a(str, (String) null);
                if (!a3) {
                    arrayList.add(adobeCSDKException);
                    return a3;
                }
                if (this.A == null || (c2 = f().c("libraries")) == null) {
                    return a3;
                }
                c2.g();
                return a3;
            }
            boolean a4 = a(str, (String) null);
            if (a4) {
                return a4;
            }
            arrayList.add(adobeCSDKException);
            return a4;
        }
        arrayList.add(ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLeavingSharedLibrary, adobeCSDKException, null, str));
        return false;
    }

    boolean a(String str, C0614ub c0614ub) {
        C0622wb c2 = c0614ub.c(str);
        if (c2 != null) {
            return this.f4625a.e(c2.j());
        }
        return false;
    }
}
