package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Ya {

    /* renamed from: a, reason: collision with root package name */
    private String f4279a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f4280b;

    /* renamed from: c, reason: collision with root package name */
    zb f4281c;

    /* renamed from: d, reason: collision with root package name */
    wb f4282d;

    /* renamed from: e, reason: collision with root package name */
    com.adobe.creativesdk.foundation.internal.storage.model.resources.e f4283e;

    /* renamed from: f, reason: collision with root package name */
    boolean f4284f;

    /* renamed from: g, reason: collision with root package name */
    com.adobe.creativesdk.foundation.internal.net.E f4285g;

    /* renamed from: h, reason: collision with root package name */
    boolean f4286h;
    String i;
    ReentrantLock j;
    Condition k;
    Timer l;
    com.adobe.creativesdk.foundation.internal.storage.model.resources.e m;

    private void b(String str, zb zbVar, wb wbVar, Handler handler) {
        this.f4281c = zbVar;
        this.f4279a = str;
        this.f4282d = wbVar;
        this.l = new Timer();
        this.f4280b = 60L;
        this.j = new ReentrantLock();
        this.k = this.j.newCondition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.i = null;
        this.m = null;
        this.f4282d.b(null);
        this.f4282d.a((Ya) null, this.f4284f);
        this.k.signal();
        this.j.unlock();
    }

    private void e() {
        this.f4283e.f6613e = null;
    }

    public void c() {
        new Thread(new Ua(this)).start();
    }

    public static Ya a(String str, zb zbVar, wb wbVar, Handler handler) {
        Ya ya = new Ya();
        ya.b(str, zbVar, wbVar, handler);
        return ya;
    }

    public void a(long j) {
        if (j < 60) {
            j = 60;
        }
        this.f4280b = j;
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.b a(C0231f c0231f) {
        if (c0231f == null || !c0231f.I()) {
            return null;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0231f);
        if (a2 != null && c0231f.p() != null) {
            a2.f6613e = c0231f.p().d();
        }
        return a2;
    }

    public void b() {
        new Thread(new Ta(this)).start();
    }

    public void a(ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList) {
        this.j.lock();
        try {
            if (!this.f4286h) {
                this.f4286h = true;
                this.f4283e = this.f4281c.a(this.f4279a);
                this.f4283e.a(arrayList != null ? new ArrayList<>(arrayList) : null);
                this.l.scheduleAtFixedRate(new Ra(this), 0L, this.f4280b * 1000);
            }
        } finally {
            this.j.unlock();
        }
    }

    public void a() {
        this.j.lock();
        try {
            if (this.f4286h) {
                this.l.cancel();
                this.l.purge();
                this.l = new Timer();
                this.f4286h = false;
            }
            if (this.i != null) {
                if (this.f4285g != null) {
                    this.f4285g.a();
                    this.f4285g = null;
                }
                this.i = null;
                this.m = null;
                this.f4282d.b(null);
                this.f4282d.a((Ya) null, this.f4284f);
                this.k.signal();
            }
        } finally {
            this.j.unlock();
        }
    }

    private int a(ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList, String str) {
        if (arrayList == null) {
            return -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
            if (arrayList.get(i).f6611c.compareTo(str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, boolean z) {
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList;
        this.j.lock();
        try {
            if (this.f4286h) {
                if (this.i != null) {
                    if (this.f4285g != null) {
                        this.f4285g.a();
                        this.f4285g = null;
                    }
                    this.i = null;
                    this.m = null;
                    this.f4282d.b(null);
                    this.f4282d.a((Ya) null, this.f4284f);
                    this.k.signal();
                }
                int a2 = a(this.f4283e.d(), bVar.f6611c);
                boolean z2 = false;
                if (a2 == -1) {
                    if (!z) {
                        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList2 = new ArrayList<>(this.f4283e.d());
                        if (bVar instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.f) {
                            arrayList2.add(new com.adobe.creativesdk.foundation.internal.storage.model.resources.f((com.adobe.creativesdk.foundation.internal.storage.model.resources.f) bVar));
                        }
                        arrayList = arrayList2;
                    }
                } else if (z) {
                    arrayList = new ArrayList<>(this.f4283e.d());
                    arrayList.remove(a2);
                } else {
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar2 = this.f4283e.d().get(a2);
                    if (bVar2.f6613e != null && !bVar2.f6613e.equals(bVar.f6613e)) {
                        bVar2.f6613e = bVar.f6613e;
                        z2 = true;
                    }
                    if (bVar2.k != bVar.k) {
                        bVar2.k = bVar.k;
                        z2 = true;
                    }
                    if (bVar2.l != bVar.l) {
                        bVar2.l = bVar.l;
                        z2 = true;
                    }
                    if (z2) {
                        bVar2.f6615g = null;
                    }
                    arrayList = null;
                }
                if (arrayList != null) {
                    this.f4283e.a(arrayList);
                }
                if (arrayList != null || z2) {
                    this.f4283e.f6613e = null;
                }
            }
        } finally {
            this.j.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        String str;
        this.j.lock();
        if (this.i != null) {
            return;
        }
        try {
            try {
                str = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
                this.i = str;
                try {
                    this.m = new com.adobe.creativesdk.foundation.internal.storage.model.resources.e(this.f4283e);
                    this.m.n();
                } catch (Exception e2) {
                    e = e2;
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Ya.class.getSimpleName(), null, e);
                    this.j.unlock();
                    this.f4282d.a(null);
                    a(str, false, z);
                }
            } finally {
                this.j.unlock();
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        }
        this.j.unlock();
        this.f4282d.a(null);
        a(str, false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, boolean z2) {
        if (!z) {
            this.j.lock();
            String str2 = this.i;
            if (str2 != null && str2.equals(str)) {
                this.f4284f = false;
            } else {
                this.j.unlock();
                return;
            }
        }
        if (z2) {
            this.m.f6613e = null;
            this.f4284f = true;
        }
        Va va = new Va(this, str);
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.m;
        if (eVar != null) {
            this.f4285g = this.f4281c.a(eVar, eVar.m() ? AdobeStoragePagingMode.AdobeStorageFirstPage : AdobeStoragePagingMode.AdobeStorageNextPageAppend, va, null);
        }
        this.j.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v7 */
    public boolean a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, String str) throws InterruptedException, AdobeDCXException, ParseException {
        boolean z;
        int i;
        String str2;
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar;
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList2;
        AdobeCollaborationType adobeCollaborationType;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        Sa sa = new Sa(this);
        ?? r13 = 0;
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList3 = eVar.d() != null ? new ArrayList<>(eVar.d()) : null;
        ArrayList arrayList4 = this.f4283e.d() != null ? new ArrayList(this.f4283e.d()) : null;
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList5 = new ArrayList<>();
        String str3 = this.f4283e.f6613e;
        this.j.unlock();
        int i2 = 1;
        if (arrayList4 != null) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar2 = (com.adobe.creativesdk.foundation.internal.storage.model.resources.b) it.next();
                int a2 = a(arrayList3, bVar2.f6611c);
                if (a2 == -1) {
                    this.f4282d.a(bVar2, this);
                    str2 = str3;
                    arrayList2 = arrayList3;
                } else {
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar3 = arrayList3.get(a2);
                    if (Za.a(bVar2.f6615g, bVar3.f6615g) && (adobeCollaborationType = bVar3.k) == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE) {
                        if (bVar2.k != adobeCollaborationType || bVar3.l != bVar2.l) {
                            this.f4282d.c(bVar3, this);
                        }
                        i = a2;
                        str2 = str3;
                        arrayList = arrayList3;
                        bVar = bVar3;
                    } else if (bVar3.f6616h) {
                        C0231f a3 = C0231f.a(bVar3.f6610b, (String) r13, (String) r13, (Aa) r13);
                        try {
                            reentrantLock.lock();
                            sa.f4234a += i2;
                            reentrantLock.unlock();
                            arrayList = arrayList3;
                            bVar = bVar3;
                            i = a2;
                            str2 = str3;
                            this.f4281c.a(a3, new Wa(this, bVar2, bVar3, this, reentrantLock, sa, newCondition), null);
                        } finally {
                        }
                    } else {
                        i = a2;
                        str2 = str3;
                        arrayList = arrayList3;
                        bVar = bVar3;
                        this.f4282d.c(bVar, this);
                    }
                    arrayList5.add(bVar);
                    arrayList2 = arrayList;
                    arrayList2.remove(i);
                }
                arrayList3 = arrayList2;
                str3 = str2;
                i2 = 1;
                r13 = 0;
            }
        }
        String str4 = str3;
        ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> arrayList6 = arrayList3;
        if (arrayList6 != null) {
            Iterator<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                com.adobe.creativesdk.foundation.internal.storage.model.resources.b next = it2.next();
                if (next.f6616h) {
                    C0231f a4 = C0231f.a(next.f6610b, (String) null, (String) null, (Aa) null);
                    try {
                        reentrantLock.lock();
                        sa.f4234a++;
                        reentrantLock.unlock();
                        this.f4281c.a(a4, new Xa(this, next, this, arrayList5, sa, reentrantLock, newCondition), null);
                    } finally {
                    }
                } else {
                    this.f4282d.b(next, this);
                    arrayList5.add(next);
                }
            }
        }
        reentrantLock.lock();
        while (sa.f4234a > 0) {
            try {
                newCondition.await();
            } finally {
            }
        }
        reentrantLock.unlock();
        eVar.a(arrayList5);
        this.j.lock();
        String str5 = this.i;
        if (str5 != null && str5.equals(str)) {
            if (this.f4284f || Za.a(str4, eVar.f6613e)) {
                z = true;
            } else {
                z = true;
                this.f4284f = true;
            }
            this.f4283e = eVar;
            if (sa.f4235b) {
                e();
            }
            return z;
        }
        this.j.unlock();
        return false;
    }
}
