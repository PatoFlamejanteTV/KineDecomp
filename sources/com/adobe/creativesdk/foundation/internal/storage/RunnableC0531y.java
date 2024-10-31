package com.adobe.creativesdk.foundation.internal.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0531y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0532z f6800a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f6801b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f6802c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f6803d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0532z f6804e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0531y(C0532z c0532z, C0532z c0532z2, List list, int i, Handler handler) {
        this.f6804e = c0532z;
        this.f6800a = c0532z2;
        this.f6801b = list;
        this.f6802c = i;
        this.f6803d = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Map] */
    @Override // java.lang.Runnable
    public void run() {
        C0517p c0517p;
        WeakReference weakReference;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        C0532z.a(this.f6804e, 0);
        C0532z.b(this.f6804e, 0);
        C0532z.c(this.f6804e, 0);
        C0532z.d(this.f6804e, 0);
        boolean[] zArr = {false};
        HashMap hashMap = new HashMap();
        WeakReference weakReference2 = new WeakReference(this.f6800a);
        C0517p c0517p2 = new C0517p(this);
        Iterator it = this.f6801b.iterator();
        while (it.hasNext()) {
            C0578la c0578la = (C0578la) it.next();
            c0578la.a(this.f6802c, new C0525s(this, weakReference2, c0578la, c0517p2, reentrantLock, newCondition, hashMap, zArr));
            it = it;
            c0517p2 = c0517p2;
            weakReference2 = weakReference2;
            hashMap = hashMap;
        }
        C0517p c0517p3 = c0517p2;
        WeakReference weakReference3 = weakReference2;
        HashMap hashMap2 = hashMap;
        reentrantLock.lock();
        while (C0532z.a(this.f6804e) < this.f6801b.size()) {
            try {
                newCondition.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        reentrantLock.unlock();
        Iterator it2 = C0532z.i((C0532z) weakReference3.get()).values().iterator();
        boolean z = true;
        while (it2.hasNext() && ((z = z & ((C0516o) it2.next()).h()))) {
        }
        if (!zArr[0] || (C0532z.a(this.f6804e) == C0532z.c(this.f6804e) && C0532z.a(this.f6804e) != C0532z.e(this.f6804e))) {
            c0517p = c0517p3;
            weakReference = weakReference3;
        } else {
            c0517p = c0517p3;
            Collections.sort(((C0532z) weakReference3.get()).f6578f, c0517p);
            ha e3 = this.f6804e.e();
            if (e3 != null) {
                weakReference = weakReference3;
                this.f6803d.post(new RunnableC0526t(this, e3, weakReference));
            } else {
                weakReference = weakReference3;
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0532z.class.getSimpleName(), "Loaded more data but there is no delegate");
            }
            if (e3 != null) {
                this.f6803d.post(new RunnableC0527u(this, e3));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0532z.class.getSimpleName(), "Finished loading data but there is no delegate");
            }
        }
        if (z && (C0532z.a(this.f6804e) != C0532z.c(this.f6804e) || C0532z.a(this.f6804e) == C0532z.e(this.f6804e))) {
            Collections.sort(((C0532z) weakReference.get()).f6578f, c0517p);
            ha e4 = this.f6804e.e();
            if (e4 != null) {
                ((C0532z) weakReference.get()).f6579g = false;
                this.f6803d.post(new RunnableC0528v(this, e4));
            }
        }
        if (hashMap2.size() > 0) {
            ha e5 = this.f6804e.e();
            if (C0532z.a(this.f6804e) == C0532z.c(this.f6804e) && C0532z.g(this.f6804e) > 0) {
                AdobeAssetException adobeAssetException = new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorOffline);
                if (e5 != null) {
                    this.f6803d.post(new RunnableC0529w(this, e5, adobeAssetException));
                }
            } else {
                for (C0578la c0578la2 : hashMap2.keySet()) {
                    ?? r3 = hashMap2;
                    AdobeAssetException adobeAssetException2 = (AdobeAssetException) r3.get(c0578la2);
                    if (e5 != null) {
                        this.f6803d.post(new RunnableC0530x(this, e5, adobeAssetException2));
                    }
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0532z.class.getSimpleName(), String.format("Failed to list product packages in %s: %s", c0578la2.getHref(), adobeAssetException2));
                    hashMap2 = r3;
                }
            }
        }
        ((C0532z) weakReference.get()).f6579g = false;
    }
}
