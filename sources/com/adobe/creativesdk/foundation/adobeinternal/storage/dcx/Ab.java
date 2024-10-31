package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class Ab {

    /* renamed from: a, reason: collision with root package name */
    private Lock f4116a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    private Condition f4117b = this.f4116a.newCondition();

    /* renamed from: c, reason: collision with root package name */
    private Integer f4118c = 0;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<AdobeCSDKException> f4119d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Ka> f4120e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Ka> f4121f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private Qa f4122g;

    /* renamed from: h, reason: collision with root package name */
    private C0324c f4123h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ab(Qa qa, C0324c c0324c) {
        this.f4122g = qa;
        this.f4123h = c0324c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f4116a.lock();
        try {
            Integer num = this.f4118c;
            this.f4118c = Integer.valueOf(this.f4118c.intValue() + 1);
        } finally {
            this.f4116a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(C0225c c0225c, String str, C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        Ka ka = (c0225c == null || !c0225c.getClass().equals(Ka.class)) ? null : (Ka) c0225c;
        if (adobeCSDKException == null) {
            this.f4122g.a(ka, str, str != null ? C0333c.a(c0225c, c0231f, str, true).f6610b.toString() : null);
        }
        this.f4116a.lock();
        try {
            if (adobeCSDKException != null) {
                this.f4119d.add(adobeCSDKException);
                a(adobeCSDKException);
            } else {
                ka.g("unmodified");
                this.f4120e.add(ka);
            }
            Integer num = this.f4118c;
            this.f4118c = Integer.valueOf(this.f4118c.intValue() - 1);
            this.f4117b.signal();
        } finally {
            this.f4116a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f4123h.h();
        this.f4123h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f4116a.lock();
        while (this.f4118c.intValue() > 0) {
            try {
                try {
                    this.f4117b.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer.waitImpl", e2.getMessage());
                }
            } finally {
                this.f4116a.unlock();
            }
        }
    }

    void a(AdobeCSDKException adobeCSDKException) {
        if (adobeCSDKException.getClass().equals(AdobeCSDKException.class)) {
            AdobeNetworkException adobeNetworkException = (AdobeNetworkException) adobeCSDKException;
            if ((adobeNetworkException.getStatusCode().intValue() == 507 || adobeNetworkException.getStatusCode().intValue() == 403) && !this.f4123h.c()) {
                this.f4123h.a();
                return;
            }
            return;
        }
        if (adobeCSDKException.getClass().equals(AdobeAssetException.class)) {
            AdobeAssetException adobeAssetException = (AdobeAssetException) adobeCSDKException;
            if (adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorExceededQuota) {
                if (this.f4123h.c()) {
                    return;
                }
                this.f4123h.a();
            } else if (adobeAssetException.getData() != null) {
                int intValue = adobeAssetException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey) ? ((Integer) adobeAssetException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue() : 0;
                if ((intValue == 507 || intValue == 403) && !this.f4123h.c()) {
                    this.f4123h.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(C0225c c0225c) {
        this.f4116a.lock();
        try {
            if (!this.f4122g.b(c0225c)) {
                this.f4122g.f(c0225c);
            }
            this.f4121f.add(c0225c.i());
        } finally {
            this.f4116a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0225c c0225c, String str, C0231f c0231f, AdobeCSDKException adobeCSDKException) {
        b(c0225c, str, c0231f, adobeCSDKException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0225c c0225c) {
        this.f4122g.g(c0225c);
        Ka i = c0225c.i();
        i.g("committedDelete");
        this.f4120e.add(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ArrayList<AdobeCSDKException> b() {
        if (this.f4119d.size() == 0) {
            return null;
        }
        return this.f4119d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0225c c0225c, AdobeCSDKException adobeCSDKException) {
        if (adobeCSDKException == null) {
            this.f4122g.f(c0225c);
        }
        this.f4116a.lock();
        try {
            if (adobeCSDKException != null) {
                this.f4119d.add(adobeCSDKException);
                a(adobeCSDKException);
            } else {
                Ka i = c0225c.i();
                i.g("committedDelete");
                this.f4121f.add(i);
            }
            Integer num = this.f4118c;
            this.f4118c = Integer.valueOf(this.f4118c.intValue() - 1);
            this.f4117b.signal();
        } finally {
            this.f4116a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fa fa, C0231f c0231f) {
        Iterator<Ka> it = this.f4120e.iterator();
        while (it.hasNext()) {
            try {
                fa.f(it.next());
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Y.class.getSimpleName(), null, e2);
            }
        }
        Iterator<Ka> it2 = this.f4121f.iterator();
        while (it2.hasNext()) {
            c0231f.a(it2.next(), fa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        return this.f4122g.a(str);
    }
}
