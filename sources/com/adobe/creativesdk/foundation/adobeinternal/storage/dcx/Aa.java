package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeDCXController.java */
/* loaded from: classes.dex */
public class Aa implements wb, Observer {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<nb> f4108a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f4109b;

    /* renamed from: c, reason: collision with root package name */
    private Ya f4110c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4111d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f4112e;

    /* renamed from: f, reason: collision with root package name */
    private AdobeDCXControllerMode f4113f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f4114g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, eb> f4115h;
    private EnumSet<AdobeNetworkReachability.AdobeNetworkStatusCode> i;
    private boolean j;
    private long k;
    private AdobeNetworkReachability o;
    private int p;
    private int l = 1;
    private com.adobe.creativesdk.foundation.internal.net.k m = null;
    private boolean n = false;
    private boolean q = false;
    private final String r = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();

    private void i() {
        WeakReference<nb> weakReference = this.f4108a;
        this.m.execute(new RunnableC0261ua(this, this, weakReference != null ? weakReference.get() : null));
    }

    private void j() {
        WeakReference<nb> weakReference = this.f4108a;
        this.m.execute(new RunnableC0254qa(this, this, weakReference != null ? weakReference.get() : null));
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(Ya ya) {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(Ya ya, boolean z) {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void b(Ya ya) {
    }

    protected void finalize() {
        e();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        a(((AdobeNetworkReachability.a) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("AdobeNetworkReachabilityStatusKey")).f4071a);
    }

    private static String e(String str) {
        String[] split = str.split("/");
        String str2 = null;
        for (int length = split.length - 1; length >= 0; length--) {
            str2 = split[length];
            if (str2.length() > 0) {
                break;
            }
        }
        return str2;
    }

    private void f() {
        synchronized (this) {
            Iterator<Map.Entry<String, eb>> it = this.f4115h.entrySet().iterator();
            while (it.hasNext()) {
                eb value = it.next().getValue();
                if ((value.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePull || value.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePush) && value.f4361g != null) {
                    if (value.f4361g.d()) {
                        value.k = true;
                    }
                    value.f4361g.a();
                    value.f4361g = null;
                }
                value.j = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        boolean z;
        boolean z2;
        synchronized (this) {
            if (this.f4112e) {
                if (this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing) {
                    Iterator<Map.Entry<String, eb>> it = this.f4115h.entrySet().iterator();
                    z2 = false;
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        eb value = it.next().getValue();
                        if (value.f4358d) {
                            if (value.f4357c != AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync) {
                                z2 = true;
                            }
                        } else if (value.f4357c != AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = true;
                    z2 = false;
                }
                if (z || !this.j) {
                    if (z && !z2 && this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing) {
                        synchronized (this) {
                            this.f4114g = true;
                        }
                    }
                    this.f4112e = false;
                    nb nbVar = this.f4108a != null ? this.f4108a.get() : null;
                    if (nbVar != null) {
                        a(new RunnableC0257sa(this, nbVar, this));
                    }
                    i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this) {
            if (!this.f4112e) {
                this.f4112e = true;
                nb nbVar = this.f4108a != null ? this.f4108a.get() : null;
                if (nbVar != null) {
                    a(new RunnableC0255ra(this, nbVar, this));
                }
            }
        }
    }

    public int b() {
        int i;
        synchronized (this) {
            i = this.p;
        }
        return i;
    }

    void c(String str) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null) {
                ebVar.l = 0L;
            }
        }
    }

    public boolean d() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, com.adobe.creativesdk.foundation.internal.net.E e2) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null) {
                if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePull) {
                    if (this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing && this.j && !ebVar.f4358d) {
                        ebVar.i = false;
                        ebVar.f4361g = e2;
                    } else {
                        if (e2.d()) {
                            ebVar.k = true;
                        }
                        e2.a();
                        g();
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, Aa.class.getSimpleName(), "pullComposite was called unexpectedly on composite with ID = " + str + ".  The pull request will not be tracked by its controller.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(c0231f.n());
            if (ebVar != null) {
                if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhaseResolve) {
                    ebVar.j = false;
                    ebVar.k = false;
                    ebVar.l = 0L;
                    if (adobeCSDKException != null) {
                        ebVar.f4360f = adobeCSDKException;
                        d(ebVar);
                        g();
                    } else {
                        ebVar.f4360f = null;
                        if (c0231f.I()) {
                            this.f4110c.a(this.f4110c.a(c0231f), false);
                        }
                        if (ebVar.i) {
                            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePull;
                            c(ebVar);
                        } else if (ebVar.f4362h) {
                            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePush;
                            c(ebVar);
                        } else {
                            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync;
                            g();
                        }
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, Aa.class.getSimpleName(), "resolvePullWithBranch:withError was called unexpectedly on composite with ID = " + c0231f.n() + ".  The result of this operation will not be tracked by its controller.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        Handler handler = this.f4109b;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, com.adobe.creativesdk.foundation.internal.net.E e2) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null) {
                if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePush) {
                    if (this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing && this.j && !ebVar.f4358d) {
                        ebVar.f4362h = false;
                        ebVar.f4361g = e2;
                    } else {
                        if (e2.d()) {
                            ebVar.k = true;
                        }
                        e2.a();
                        g();
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, Aa.class.getSimpleName(), "pushComposite was called unexpectedly on composite with ID = " + str + ".  The push request will not be tracked by its controller.");
                }
            }
        }
    }

    public void e() {
        if (this.n) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this);
        synchronized (this) {
            if (this.o != null) {
                com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
                this.o = null;
            }
        }
        this.m.shutdown();
        C0231f.b();
        this.n = true;
    }

    public void a() {
        this.f4110c.b();
    }

    void a(int i, eb ebVar) {
        Timer timer = ebVar.m;
        if (timer != null) {
            timer.cancel();
            ebVar.m = null;
        }
        ebVar.m = new Timer();
        ebVar.m.schedule(new C0240ja(this, new WeakReference(ebVar)), i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            this.f4114g = false;
            if (ebVar == null) {
                ebVar = new eb();
                ebVar.f4355a = str;
                ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync;
                this.f4115h.put(str, ebVar);
            }
            if (b() > 0) {
                a(b(), ebVar);
            } else {
                a(ebVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(c0231f.n());
            if (ebVar != null && ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePull) {
                ebVar.f4361g = null;
                ebVar.j = false;
                ebVar.k = false;
                ebVar.l = 0L;
                if (adobeCSDKException != null) {
                    ebVar.f4360f = adobeCSDKException;
                    d(ebVar);
                    g();
                } else if (c0231f.A() == null) {
                    ebVar.f4360f = null;
                    ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync;
                    b(ebVar);
                } else {
                    ebVar.f4360f = null;
                    ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseResolve;
                    c(ebVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(c0231f.n());
            if (ebVar != null && ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePush) {
                ebVar.f4361g = null;
                ebVar.j = false;
                ebVar.k = false;
                ebVar.l = 0L;
                if (adobeCSDKException != null) {
                    ebVar.f4360f = adobeCSDKException;
                    d(ebVar);
                    g();
                } else if (c0231f.E() == null) {
                    ebVar.f4360f = null;
                    b(ebVar);
                } else {
                    ebVar.f4360f = null;
                    ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseAccept;
                    c(ebVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(eb ebVar) {
        if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync) {
            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePush;
            ebVar.f4361g = null;
            ebVar.l = 0L;
            c(ebVar);
            return;
        }
        if (this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing && this.j && !ebVar.f4358d) {
            ebVar.f4362h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long d(String str) {
        WeakReference<nb> weakReference = this.f4108a;
        nb nbVar = weakReference != null ? weakReference.get() : null;
        if (this.f4109b == null) {
            if (nbVar != null) {
                return nbVar.e(this, str);
            }
            return 0L;
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        C0242ka c0242ka = new C0242ka(this);
        new Thread(new RunnableC0265wa(this, nbVar, c0242ka, this, str, reentrantLock, newCondition)).start();
        reentrantLock.lock();
        while (!c0242ka.f4402b) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXController.bytesConsumedByCompositeWithID", e2.getMessage());
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return c0242ka.f4401a;
    }

    private void c(eb ebVar) {
        if (!ebVar.f4358d && this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing && this.j) {
            WeakReference<nb> weakReference = this.f4108a;
            nb nbVar = weakReference != null ? weakReference.get() : null;
            if (nbVar == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Aa.class.getSimpleName(), "The delegate inside DCX Controller is null");
            }
            String str = ebVar.f4355a;
            ebVar.j = true;
            int i = C0238ia.f4393b[ebVar.f4357c.ordinal()];
            if (i == 1) {
                ebVar.f4362h = false;
                h();
                a(new RunnableC0221aa(this, nbVar, str, this));
                return;
            }
            if (i == 2) {
                h();
                a(new RunnableC0226ca(this, nbVar, str, this));
                return;
            }
            if (i == 3) {
                ebVar.i = false;
                h();
                a(new RunnableC0224ba(this, nbVar, str, this, ebVar.f4356b));
            } else if (i == 4) {
                h();
                a(new RunnableC0228da(this, nbVar, str, this));
            } else if (i != 5) {
                ebVar.j = false;
            } else {
                h();
                a(new RunnableC0230ea(this, nbVar, str, this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, com.adobe.creativesdk.foundation.internal.net.E e2) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null) {
                ebVar.f4359e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null && ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhaseResolve) {
                ebVar.j = false;
                ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePull;
                c(ebVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, AdobeCSDKException adobeCSDKException) {
        synchronized (this) {
            eb ebVar = this.f4115h.get(str);
            if (ebVar != null) {
                ebVar.f4359e = false;
                c(str);
                c(ebVar);
            }
        }
    }

    private void b(eb ebVar) {
        if (ebVar.i) {
            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePull;
            c(ebVar);
        } else if (ebVar.f4362h) {
            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePush;
            c(ebVar);
        } else {
            ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:            if (r1.getHttpStatusCode().intValue() == 409) goto L57;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb r9) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa.d(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.eb):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.b a2;
        synchronized (this) {
            eb ebVar = this.f4115h.get(c0231f.n());
            if (ebVar != null) {
                if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhaseAccept) {
                    ebVar.j = false;
                    ebVar.k = false;
                    ebVar.l = 0L;
                    if (adobeCSDKException != null) {
                        ebVar.f4360f = adobeCSDKException;
                        d(ebVar);
                        g();
                    } else {
                        ebVar.f4360f = null;
                        if (c0231f.I() && (a2 = this.f4110c.a(c0231f)) != null && this.f4111d) {
                            this.f4110c.a(a2, false);
                        }
                        b(ebVar);
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, Aa.class.getSimpleName(), "acceptPushWithError was called unexpectedly on composite with ID = " + c0231f.n() + ".  The result of this operation will not be tracked by its controller.");
                }
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void b(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        String e2 = e(bVar.f6610b.toString());
        if (e2 != null) {
            synchronized (this) {
                eb ebVar = new eb();
                ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePull;
                ebVar.f4355a = e2;
                ebVar.f4356b = bVar.f6610b.toString();
                this.f4114g = false;
                this.f4115h.put(e2, ebVar);
                c(ebVar);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void c(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        String e2 = e(bVar.f6610b.toString());
        if (e2 != null) {
            synchronized (this) {
                eb ebVar = this.f4115h.get(e2);
                if (ebVar != null) {
                    this.f4114g = false;
                    if (ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync && !ebVar.f4359e) {
                        ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhasePull;
                        c(ebVar);
                    } else {
                        ebVar.i = true;
                    }
                }
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya) {
        String e2 = e(bVar.f6610b.toString());
        if (e2 != null) {
            Za.a("csdk_android_dcx", "AdobeDCXController.assetWasDeleted", "Composite was deleted on server " + Arrays.toString(Thread.currentThread().getStackTrace()), e2);
            synchronized (this) {
                eb ebVar = this.f4115h.get(e2);
                if (ebVar != null) {
                    if ((ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePush || ebVar.f4357c == AdobeDCXSyncPhase.AdobeDCXSyncPhasePull) && ebVar.f4361g != null) {
                        if (ebVar.f4361g.d()) {
                            ebVar.k = true;
                        }
                        ebVar.f4361g.a();
                    }
                    ebVar.f4357c = AdobeDCXSyncPhase.AdobeDCXSyncPhaseDelete;
                    this.f4114g = false;
                    if (this.f4113f == AdobeDCXControllerMode.AdobeDCXControllerSyncing && this.j && !ebVar.f4358d && !ebVar.f4359e) {
                        ebVar.j = true;
                        nb nbVar = this.f4108a.get();
                        h();
                        a(new RunnableC0232fa(this, nbVar, e2, this));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.r;
    }

    private void a(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        synchronized (this) {
            nb nbVar = this.f4108a.get();
            if (this.i.contains(adobeNetworkStatusCode) && !this.j) {
                this.j = true;
                if (nbVar != null) {
                    a(new RunnableC0234ga(this, nbVar, this, adobeNetworkStatusCode));
                    a();
                    j();
                }
            } else if (!this.i.contains(adobeNetworkStatusCode) && this.j) {
                this.j = false;
                f();
                if (nbVar != null) {
                    a(new RunnableC0236ha(this, nbVar, this, adobeNetworkStatusCode));
                    g();
                }
            }
        }
    }
}
