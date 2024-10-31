package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0291u;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
public class Gb implements Observer {

    /* renamed from: a, reason: collision with root package name */
    private static Gb f6987a;
    boolean A;

    /* renamed from: b, reason: collision with root package name */
    ArrayList f6988b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6989c;

    /* renamed from: d, reason: collision with root package name */
    boolean f6990d;

    /* renamed from: e, reason: collision with root package name */
    protected AdobeLibraryDownloadPolicyType f6991e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f6992f;

    /* renamed from: g, reason: collision with root package name */
    protected HashMap<String, ArrayList<Integer>> f6993g;

    /* renamed from: h, reason: collision with root package name */
    AdobeCloud f6994h;
    protected String i;
    protected long j;
    boolean l;
    private EnumSet<AdobeNetworkReachability.AdobeNetworkStatusCode> m;
    private boolean n;
    private ReentrantLock o;
    private Date p;
    private Date q;
    protected boolean s;
    protected boolean t;
    protected boolean w;
    Map<AbstractC0618vb, Jb> x;
    ArrayList<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> y;
    com.adobe.creativesdk.foundation.adobeinternal.storage.library.D z;
    private int k = 1;
    private com.adobe.creativesdk.foundation.internal.net.k v = null;
    private int r = 0;
    boolean u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdobeLibraryManager.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean b(T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Gb() {
        t();
    }

    public static Gb f() {
        synchronized (Gb.class) {
            if (f6987a == null) {
                f6987a = new com.adobe.creativesdk.foundation.adobeinternal.storage.library.G();
                f6987a.b(true);
            }
        }
        return f6987a;
    }

    private void t() {
        this.y = new ArrayList<>();
        this.r++;
        this.x = new HashMap();
        this.z = null;
        this.A = false;
        this.f6994h = null;
        this.f6988b = null;
        this.f6992f = null;
        this.f6993g = null;
        this.i = null;
        this.o = new ReentrantLock();
        this.t = false;
        this.s = true;
        this.w = true;
        int i = this.k;
        this.v = new com.adobe.creativesdk.foundation.internal.net.k(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        synchronized (this) {
            this.f6990d = true;
            this.l = false;
            this.n = false;
            this.m = EnumSet.of(AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableNonMetered);
        }
    }

    public C0614ub a(String str) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2;
        if (i() && (d2 = this.z) != null) {
            return d2.b(str);
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null);
        return null;
    }

    public boolean b(String str) throws AdobeLibraryException {
        if (i() && this.z != null) {
            C0614ub d2 = d(str);
            if (d2 != null && d2.p()) {
                String c2 = c(str);
                if (c2 == null) {
                    return false;
                }
                return a(C0291u.a(str, c2));
            }
            return this.z.c(str);
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null);
        return false;
    }

    void c() {
        Iterator<Jb> it;
        boolean z;
        long j;
        ArrayList arrayList;
        ArrayList<String> arrayList2;
        AdobeLibraryDownloadPolicyType adobeLibraryDownloadPolicyType;
        long j2;
        synchronized (this) {
            AdobeLibraryDownloadPolicyType adobeLibraryDownloadPolicyType2 = AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestOnly;
            this.o.lock();
            Iterator<Jb> it2 = this.x.values().iterator();
            boolean z2 = false;
            long j3 = -1;
            HashMap<String, ArrayList<Integer>> hashMap = null;
            ArrayList arrayList3 = null;
            ArrayList<String> arrayList4 = null;
            EnumSet<AdobeNetworkReachability.AdobeNetworkStatusCode> enumSet = null;
            boolean z3 = false;
            boolean z4 = false;
            AdobeLibraryDownloadPolicyType adobeLibraryDownloadPolicyType3 = adobeLibraryDownloadPolicyType2;
            ArrayList arrayList5 = null;
            while (it2.hasNext()) {
                Jb next = it2.next();
                if (next != null) {
                    if (j3 > 0) {
                        it = it2;
                        z = z2;
                        j = Math.min(j3, next.f7023a);
                    } else {
                        it = it2;
                        z = z2;
                        j = next.f7023a;
                    }
                    adobeLibraryDownloadPolicyType3 = AdobeLibraryDownloadPolicyType.values()[Math.max(adobeLibraryDownloadPolicyType3.ordinal(), next.f7024b.ordinal())];
                    if (next.f7029g) {
                        z = true;
                    }
                    if (next.f7028f != null) {
                        if (enumSet == null) {
                            enumSet = next.f7028f;
                        } else {
                            Iterator it3 = next.f7028f.iterator();
                            while (it3.hasNext()) {
                                AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode = (AdobeNetworkReachability.AdobeNetworkStatusCode) it3.next();
                                if (!next.f7028f.contains(adobeNetworkStatusCode)) {
                                    enumSet.add(adobeNetworkStatusCode);
                                }
                            }
                        }
                    }
                    if (next.f7027e != null) {
                        if (!z3) {
                            if (arrayList3 == null) {
                                arrayList = new ArrayList(next.f7027e);
                            } else {
                                Iterator it4 = next.f7027e.iterator();
                                while (it4.hasNext()) {
                                    Object next2 = it4.next();
                                    if (arrayList3.indexOf(next2) == -1) {
                                        arrayList3.add(next2);
                                    }
                                }
                            }
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                        z3 = true;
                    }
                    if (next.f7025c != null) {
                        if (!z4) {
                            if (arrayList4 == null) {
                                arrayList2 = new ArrayList<>(next.f7025c);
                            } else {
                                Iterator<String> it5 = next.f7025c.iterator();
                                while (it5.hasNext()) {
                                    String next3 = it5.next();
                                    if (arrayList4.indexOf(next3) == -1) {
                                        arrayList4.add(next3);
                                    }
                                }
                            }
                        }
                        arrayList2 = arrayList4;
                    } else {
                        arrayList2 = null;
                        z4 = true;
                    }
                    if (next.f7026d != null) {
                        if (hashMap == null) {
                            hashMap = new HashMap<>(next.f7026d);
                            arrayList3 = arrayList;
                            arrayList4 = arrayList2;
                            j3 = j;
                            z2 = z;
                        } else {
                            for (String str : next.f7026d.keySet()) {
                                ArrayList<Integer> arrayList6 = next.f7026d.get(str);
                                ArrayList<Integer> arrayList7 = hashMap.get(str);
                                if (arrayList7 != null) {
                                    Iterator<Integer> it6 = arrayList6.iterator();
                                    while (it6.hasNext()) {
                                        AdobeLibraryDownloadPolicyType adobeLibraryDownloadPolicyType4 = adobeLibraryDownloadPolicyType3;
                                        Integer next4 = it6.next();
                                        long j4 = j;
                                        if (arrayList7.indexOf(next4) == -1) {
                                            arrayList7.add(next4);
                                        }
                                        adobeLibraryDownloadPolicyType3 = adobeLibraryDownloadPolicyType4;
                                        j = j4;
                                    }
                                    adobeLibraryDownloadPolicyType = adobeLibraryDownloadPolicyType3;
                                    j2 = j;
                                } else {
                                    adobeLibraryDownloadPolicyType = adobeLibraryDownloadPolicyType3;
                                    j2 = j;
                                    hashMap.put(str, new ArrayList<>(arrayList6));
                                }
                                if ("*".equals(str)) {
                                    if (arrayList5 == null) {
                                        arrayList5 = new ArrayList(arrayList6);
                                    } else {
                                        Iterator<Integer> it7 = arrayList6.iterator();
                                        while (it7.hasNext()) {
                                            Integer next5 = it7.next();
                                            if (arrayList5.indexOf(next5) == -1) {
                                                arrayList5.add(next5);
                                            }
                                        }
                                    }
                                }
                                adobeLibraryDownloadPolicyType3 = adobeLibraryDownloadPolicyType;
                                j = j2;
                            }
                        }
                    }
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                    z2 = z;
                    j3 = j;
                } else {
                    it = it2;
                }
                it2 = it;
            }
            boolean z5 = z2;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                for (String str2 : hashMap.keySet()) {
                    if ("*".equals(str2)) {
                        ArrayList<Integer> arrayList8 = hashMap.get(str2);
                        Iterator it8 = arrayList5.iterator();
                        while (it8.hasNext()) {
                            Integer num = (Integer) it8.next();
                            if (arrayList8.indexOf(num) == -1) {
                                arrayList8.add(num);
                            }
                        }
                    }
                }
            }
            this.j = Math.max(j3, 60L);
            if (this.z != null && this.z.i != null && this.z.f4517g) {
                this.z.a(this.j);
            }
            this.f6991e = adobeLibraryDownloadPolicyType3;
            this.f6988b = arrayList3;
            this.m = enumSet;
            if (this.f6991e == AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestOnly) {
                arrayList4 = null;
            }
            this.f6992f = arrayList4;
            this.w = z5;
            this.f6993g = hashMap;
            this.o.unlock();
        }
    }

    public ArrayList d() {
        return this.f6988b;
    }

    public ArrayList<C0614ub> e() {
        ArrayList<C0614ub> arrayList = new ArrayList<>();
        this.o.lock();
        try {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next = it.next();
                if (!next.g() || this.w) {
                    arrayList.addAll(next.d());
                }
            }
            return arrayList;
        } finally {
            this.o.unlock();
        }
    }

    public Kb g() {
        Kb kb = new Kb();
        synchronized (this) {
            kb.a(this.p);
            kb.a(this.l);
        }
        return kb;
    }

    public boolean h(String str) throws AdobeLibraryException {
        return a(str, (AdobeCloud) null);
    }

    public boolean i() {
        return this.i != null;
    }

    public boolean j() {
        boolean z;
        synchronized (this) {
            z = this.f6990d;
        }
        return z;
    }

    public boolean k() {
        boolean z;
        synchronized (this) {
            z = this.f6989c;
        }
        return z;
    }

    public boolean l() {
        boolean z;
        synchronized (this) {
            z = this.t;
        }
        return z;
    }

    void m() {
        boolean z;
        synchronized (this) {
            ArrayList<C0291u> c2 = this.z.c();
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next = it.next();
                if (next.g()) {
                    ArrayList arrayList = new ArrayList(next.d());
                    for (int i = 0; i < arrayList.size(); i++) {
                        C0614ub c0614ub = (C0614ub) arrayList.get(i);
                        Iterator<C0291u> it2 = c2.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().f4661a.equals(c0614ub.k())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            next.f(c0614ub.k());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        boolean z;
        Iterator<AbstractC0618vb> it = this.x.keySet().iterator();
        while (true) {
            while (it.hasNext()) {
                z = z && it.next().f7452c;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        boolean z;
        Iterator<AbstractC0618vb> it = this.x.keySet().iterator();
        while (true) {
            while (it.hasNext()) {
                z = z || it.next().f7451b;
            }
            return z;
        }
    }

    public void p() {
        this.o.lock();
        ArrayList<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> arrayList = this.y;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
        this.o.unlock();
        synchronized (this) {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this);
            if (c.a.a.a.c.a.a.b().a() != null) {
                com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
            }
        }
        t();
        this.s = true;
    }

    public boolean q() throws AdobeLibraryException {
        if (this.x.size() <= 0) {
            p();
            return true;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorCannotShutdownDelegatesExist, null, null, null);
    }

    public boolean r() {
        ArrayList<AdobeLibraryException> arrayList = new ArrayList<>();
        if (!a(arrayList)) {
            a("onSyncError", null, arrayList.get(0));
            return false;
        }
        synchronized (this) {
            if (!this.l) {
                this.z.n();
            }
        }
        return true;
    }

    public void s() {
        synchronized (this) {
            this.t = false;
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        a(((AdobeNetworkReachability.a) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("AdobeNetworkReachabilityStatusKey")).f4071a);
    }

    public C0614ub d(String str) {
        Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
        while (it.hasNext()) {
            C0614ub d2 = it.next().d(str);
            if (d2 != null) {
                return d2;
            }
        }
        return null;
    }

    void h() {
        a(com.adobe.creativesdk.foundation.adobeinternal.net.a.b().a());
        if (this.y != null) {
            for (int i = 0; i < this.y.size(); i++) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2 = this.y.get(i);
                if (d2 != null) {
                    if (i == 0) {
                        this.A = d2.a(true);
                    } else if (!d2.g() || this.w) {
                        d2.a(false);
                    }
                }
            }
        }
        if (c.a.a.a.c.a.a.b().a() != null) {
            com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this);
    }

    public boolean a(String str, AbstractC0618vb abstractC0618vb) {
        Jb jb;
        if (str == null || (jb = this.x.get(abstractC0618vb)) == null) {
            return false;
        }
        ArrayList arrayList = jb.f7027e;
        return arrayList == null || arrayList.isEmpty() || jb.f7027e.indexOf(str) != -1;
    }

    protected boolean a(String str, AdobeCloud adobeCloud) throws AdobeLibraryException {
        synchronized (this) {
            if (this.i == null && this.f6994h == null) {
                if (adobeCloud == null && this.f6989c) {
                    adobeCloud = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
                }
                if (str != null && (adobeCloud != null || !this.f6989c)) {
                    this.i = str;
                    this.f6994h = adobeCloud;
                    this.z = new com.adobe.creativesdk.foundation.adobeinternal.storage.library.D();
                    if (!this.z.a(str, this.f6994h, AdobeCloudServiceType.AdobeCloudServiceTypeStorage, null, "adobe-libraries")) {
                        this.i = null;
                        return false;
                    }
                    this.y.add(this.z);
                    String[][] strArr = AdobeAuthIdentityManagementService.K().w() == AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS ? com.adobe.creativesdk.foundation.adobeinternal.storage.library.E.f4519a : com.adobe.creativesdk.foundation.adobeinternal.storage.library.E.f4520b;
                    for (int i = 0; i < strArr.length; i++) {
                        String d2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.d(str, "public");
                        com.adobe.creativesdk.foundation.adobeinternal.storage.library.M m = new com.adobe.creativesdk.foundation.adobeinternal.storage.library.M();
                        if (m.a(d2, adobeCloud, strArr[i][1].equals("cp") ? AdobeCloudServiceType.AdobeCloudServiceTypeCommunity : AdobeCloudServiceType.AdobeCloudServiceTypeStorage, strArr[i][0], null)) {
                            this.y.add(m);
                        }
                    }
                    if (this.x.size() > 0) {
                        h();
                        a();
                    }
                    this.s = false;
                    return true;
                }
                throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorBadParameter, null, null, null);
            }
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupAlreadyStarted, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(String str) {
        ArrayList<String> arrayList = this.f6992f;
        if (arrayList == null) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean e(String str) {
        if (str == null) {
            return false;
        }
        ArrayList arrayList = this.f6988b;
        return arrayList == null || arrayList.isEmpty() || this.f6988b.indexOf(str) != -1;
    }

    public void b(boolean z) {
        synchronized (this) {
            this.f6989c = z;
            if (this.f6989c) {
                if (!this.x.isEmpty() && this.z != null) {
                    this.z.k();
                }
            } else {
                Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (this.z != null) {
                    this.z.m();
                }
            }
        }
    }

    void f(String str) {
        a(str, null, null, null, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        boolean z;
        synchronized (this) {
            z = (!this.f6989c || this.z == null || this.z.m.o() == null || this.t || !this.f6990d) ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2) {
        synchronized (this) {
            if (!this.l) {
                this.l = true;
                this.q = new Date();
                if (d2 == this.z) {
                    f("syncStarted");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        synchronized (this) {
            if (!this.m.contains(adobeNetworkStatusCode)) {
                if (this.f6990d) {
                    this.f6990d = false;
                    this.n = this.l;
                    if (adobeNetworkStatusCode != AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkNotReachable) {
                        this.z.m();
                    }
                    a("syncUnavailable", adobeNetworkStatusCode);
                }
            } else if (!this.f6990d) {
                this.f6990d = true;
                Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
                while (it.hasNext()) {
                    it.next().m.l();
                }
                this.z.k();
                a("syncAvailable", adobeNetworkStatusCode);
                if (this.n || this.p == null || new Date().getTime() - this.p.getTime() > this.j) {
                    r();
                }
                this.n = false;
                this.t = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.storage.AbstractC0618vb r2, com.adobe.creativesdk.foundation.storage.Jb r3) {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.o
            r0.lock()
            java.util.Map<com.adobe.creativesdk.foundation.storage.vb, com.adobe.creativesdk.foundation.storage.Jb> r0 = r1.x
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L24
            java.util.Map<com.adobe.creativesdk.foundation.storage.vb, com.adobe.creativesdk.foundation.storage.Jb> r0 = r1.x
            r0.put(r2, r3)
            java.util.concurrent.locks.ReentrantLock r2 = r1.o
            r2.unlock()
            r1.c()
            java.lang.String r2 = r1.i
            if (r2 == 0) goto L29
            boolean r2 = r1.A
            if (r2 != 0) goto L29
            r2 = 1
            goto L2a
        L24:
            java.util.concurrent.locks.ReentrantLock r2 = r1.o
            r2.unlock()
        L29:
            r2 = 0
        L2a:
            if (r2 == 0) goto L2f
            r1.h()
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.storage.Gb.a(com.adobe.creativesdk.foundation.storage.vb, com.adobe.creativesdk.foundation.storage.Jb):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        synchronized (this) {
            ArrayList<C0291u> c2 = this.z.c();
            if (c2 != null && !c2.isEmpty()) {
                Iterator<C0291u> it = c2.iterator();
                while (it.hasNext()) {
                    C0291u next = it.next();
                    if (next.f4661a.equals(str)) {
                        return next.f4662b;
                    }
                }
            }
            return null;
        }
    }

    public void a(AbstractC0618vb abstractC0618vb) {
        boolean z;
        this.o.lock();
        boolean z2 = true;
        if (this.x.containsKey(abstractC0618vb)) {
            this.x.remove(abstractC0618vb);
            z = true;
        } else {
            z = false;
        }
        if (this.x.size() == 0) {
            z = false;
        } else {
            z2 = false;
        }
        this.o.unlock();
        if (z) {
            c();
        }
        if (z2) {
            try {
                q();
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2) {
        C0614ub d3 = d2.d(str);
        if ((d3 != null && d3.f7439b == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) || d3.p()) {
            d2.m.g(str);
        } else {
            a("libraryPreDelete", null, str, null, null, new C0634zb(this, d2, str), new Ab(this, d2, str), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C0614ub c0614ub) {
        c0614ub.f7444g.a(AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER);
        if (c0614ub.f7444g.p().c().equals("modified")) {
            a("libraryPreReadabilityChange", c0614ub.k(), new Bb(this, c0614ub), new Db(this, c0614ub));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C0614ub c0614ub, AdobeCSDKException adobeCSDKException) {
        a("onSyncError", c0614ub, adobeCSDKException);
    }

    void a(String str, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        a(str, null, null, null, null, null, null, adobeNetworkStatusCode, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        a(str, null, str2, null, null, null, null, null, null);
    }

    void a(String str, String str2, c.a.a.a.b<Void> bVar, a<Object> aVar) {
        a(str, null, str2, null, null, bVar, aVar, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, C0614ub c0614ub, AdobeCSDKException adobeCSDKException) {
        a(str, c0614ub, null, null, null, null, null, null, adobeCSDKException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, C0614ub c0614ub, String str2, String str3) {
        a(str, c0614ub, null, str2, str3, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, C0614ub c0614ub) {
        a(str, c0614ub, null, null, null, null, null, null, null);
    }

    void a(String str, C0614ub c0614ub, String str2, String str3, String str4, c.a.a.a.b<Void> bVar, a<Object> aVar, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode, AdobeCSDKException adobeCSDKException) {
        if (i()) {
            if (aVar == null && bVar == null) {
                for (AbstractC0618vb abstractC0618vb : this.x.keySet()) {
                    Fb fb = new Fb(this, abstractC0618vb, str, c0614ub, str3, adobeCSDKException, str2, adobeNetworkStatusCode);
                    if (a(str, abstractC0618vb, c0614ub, str3, str4) && abstractC0618vb != null) {
                        Handler handler = abstractC0618vb.f7450a;
                        if (handler != null) {
                            handler.post(fb);
                        } else {
                            this.v.execute(fb);
                        }
                    }
                }
                return;
            }
            Eb eb = new Eb(this, str, str2, aVar, bVar);
            Handler handler2 = ((AbstractC0618vb) new ArrayList(this.x.keySet()).get(this.x.size() - 1)).f7450a;
            if (handler2 != null) {
                handler2.post(eb);
            } else {
                this.v.execute(eb);
            }
        }
    }

    private boolean a(String str, AbstractC0618vb abstractC0618vb, C0614ub c0614ub, String str2, String str3) {
        Jb jb;
        ArrayList arrayList;
        if (abstractC0618vb == null) {
            return false;
        }
        if (c0614ub == null || str2 == null) {
            return true;
        }
        return !("elementWasAdded".equals(str) || "elementWasUpdated".equals(str) || "elementWasRemoved".equals(str)) || (jb = this.x.get(abstractC0618vb)) == null || (arrayList = jb.f7027e) == null || arrayList.indexOf(str3) != -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ArrayList<AdobeLibraryException> arrayList) {
        synchronized (this) {
            if (this.y == null) {
                arrayList.add(com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null));
            } else {
                com.adobe.creativesdk.foundation.adobeinternal.cloud.g f2 = this.z != null ? this.z.m.f() : null;
                if (!this.f6989c) {
                    arrayList.add(com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotEnabled, null, null, null));
                } else {
                    if (!this.t && f2 != null) {
                        if (!this.f6990d) {
                            arrayList.add(com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToNetwork, null, null, null));
                        }
                    }
                    arrayList.add(com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotAvailableDueToUserSession, null, null, null));
                }
            }
        }
        return arrayList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next;
        synchronized (this) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
            boolean z = false;
            while (it.hasNext() && ((next = it.next()) == d2 || !(z = next.h()))) {
            }
            if (!z && this.l) {
                this.l = false;
                this.p = new Date();
                f("syncFinished");
            }
        }
    }

    protected boolean a(C0291u c0291u) {
        C0614ub d2;
        if (this.z != null && (d2 = d(c0291u.f4661a)) != null && this.z.b().a(c0291u)) {
            try {
                m();
                return this.z.a(d2, (Boolean) false);
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        boolean z;
        synchronized (this) {
            ArrayList<C0291u> c2 = this.z.c();
            if (c2 != null) {
                Iterator<C0291u> it = c2.iterator();
                while (it.hasNext()) {
                    C0291u next = it.next();
                    Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it2 = this.y.iterator();
                    while (it2.hasNext()) {
                        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next2 = it2.next();
                        if (next2.g() && next2.d(next.f4661a) == null && ((com.adobe.creativesdk.foundation.adobeinternal.storage.library.M) next2).a(next.f4662b)) {
                            ((com.adobe.creativesdk.foundation.adobeinternal.storage.library.M) next2).h(next.f4661a);
                        }
                    }
                }
            }
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it3 = this.y.iterator();
            while (it3.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next3 = it3.next();
                if (next3.g()) {
                    ArrayList arrayList = new ArrayList(next3.d());
                    for (int i = 0; i < arrayList.size(); i++) {
                        C0614ub c0614ub = (C0614ub) arrayList.get(i);
                        if (c2 != null) {
                            Iterator<C0291u> it4 = c2.iterator();
                            while (it4.hasNext()) {
                                if (it4.next().f4661a.equals(c0614ub.k())) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            try {
                                next3.a(c0614ub, (Boolean) false);
                                a("libraryWasDeleted", c0614ub.k());
                            } catch (AdobeLibraryException e2) {
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                a();
            }
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.library.D> it = this.y.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D next = it.next();
                if (next.g() && this.w) {
                    next.n();
                }
            }
        }
    }
}
