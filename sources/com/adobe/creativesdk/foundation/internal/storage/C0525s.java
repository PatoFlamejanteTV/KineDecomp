package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.Ya;
import com.adobe.creativesdk.foundation.storage.qd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0525s implements qd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f6779a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0578la f6780b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Comparator f6781c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f6782d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Condition f6783e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Map f6784f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean[] f6785g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6786h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0525s(RunnableC0531y runnableC0531y, WeakReference weakReference, C0578la c0578la, Comparator comparator, ReentrantLock reentrantLock, Condition condition, Map map, boolean[] zArr) {
        this.f6786h = runnableC0531y;
        this.f6779a = weakReference;
        this.f6780b = c0578la;
        this.f6781c = comparator;
        this.f6782d = reentrantLock;
        this.f6783e = condition;
        this.f6784f = map;
        this.f6785g = zArr;
    }

    @Override // com.adobe.creativesdk.foundation.storage.qd
    public void a(ArrayList<C0533a> arrayList, int i) {
        ArrayList<Ya> arrayList2 = new ArrayList(arrayList);
        C0516o c0516o = (C0516o) C0532z.i((C0532z) this.f6779a.get()).get(this.f6780b.getGUID());
        if (c0516o == null) {
            c0516o = new C0516o();
            c0516o.i = this.f6780b.getGUID();
            c0516o.j = this.f6780b.getHref();
        }
        if (arrayList2.size() == 0) {
            c0516o.m = true;
        } else {
            c0516o.k = ((C0533a) arrayList2.get(0)).getModificationDate();
            c0516o.l = ((C0533a) arrayList2.get(arrayList2.size() - 1)).getModificationDate();
            c0516o.m = !this.f6780b.c();
        }
        C0532z.i((C0532z) this.f6779a.get()).put(this.f6780b.getGUID(), c0516o);
        int[] iArr = {0};
        ArrayList arrayList3 = new ArrayList();
        if (arrayList2.size() > 0) {
            for (Ya ya : arrayList2) {
                ya.a(new C0524q(this, ya, arrayList3, iArr, arrayList2), new r(this, iArr, arrayList2, arrayList3));
            }
        } else {
            this.f6782d.lock();
            C0532z.d(this.f6786h.f6804e);
            C0532z.f(this.f6786h.f6804e);
            C0532z.b(this.f6786h.f6804e);
            this.f6783e.signal();
            this.f6782d.unlock();
        }
        this.f6785g[0] = true;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f6782d.lock();
        if (adobeAssetException.getHttpStatusCode().intValue() != 404) {
            if (adobeAssetException.getErrorCode() != AdobeAssetErrorCode.AdobeAssetErrorTimeout && adobeAssetException.getErrorCode() != AdobeAssetErrorCode.AdobeAssetErrorOffline) {
                if (adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse) {
                    C0532z.f(this.f6786h.f6804e);
                }
            } else {
                C0532z.h(this.f6786h.f6804e);
            }
            this.f6784f.put(this.f6780b, adobeAssetException);
        } else {
            if (!com.adobe.creativesdk.foundation.adobeinternal.net.a.c()) {
                C0532z.h(this.f6786h.f6804e);
                this.f6784f.put(this.f6780b, adobeAssetException);
            }
            if (adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse) {
                C0532z.f(this.f6786h.f6804e);
            }
        }
        C0532z.d(this.f6786h.f6804e);
        C0532z.b(this.f6786h.f6804e);
        this.f6783e.signal();
        this.f6782d.unlock();
    }
}
