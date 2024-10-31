package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.Ya;
import com.adobe.creativesdk.foundation.storage.qd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0506e implements qd {

    /* renamed from: a, reason: collision with root package name */
    final int[] f6567a = {0};

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<C0533a> f6568b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ WeakReference f6569c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0507f f6570d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0506e(C0507f c0507f, WeakReference weakReference) {
        this.f6570d = c0507f;
        this.f6569c = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Collections.sort(this.f6568b, new C0356b(this));
        C0507f c0507f = (C0507f) this.f6569c.get();
        if (c0507f != null) {
            if (c0507f.f6580h) {
                c0507f.f6578f.clear();
                c0507f.f6580h = false;
            }
            c0507f.f6578f.addAll(this.f6568b);
            ha e2 = this.f6570d.e();
            if (e2 != null) {
                e2.a(c0507f.f6578f.size());
            }
            if (e2 != null) {
                e2.c();
            }
            c0507f.f6579g = false;
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.qd
    public void a(ArrayList<C0533a> arrayList, int i) {
        C0507f c0507f = (C0507f) this.f6569c.get();
        if (c0507f != null) {
            if (c0507f.f6578f == null) {
                c0507f.f6578f = new ArrayList<>(i);
            }
            if (arrayList.size() == 0) {
                ha e2 = this.f6570d.e();
                if (e2 != null) {
                    e2.c();
                }
                c0507f.f6578f.clear();
                c0507f.f6579g = false;
            }
            Iterator<C0533a> it = arrayList.iterator();
            while (it.hasNext()) {
                C0533a next = it.next();
                if (next instanceof Ya) {
                    Ya ya = (Ya) next;
                    ya.a(new C0357c(this, ya, arrayList), new C0505d(this, arrayList));
                }
            }
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        ha e2 = this.f6570d.e();
        if (e2 != null) {
            e2.a(adobeAssetException);
            e2.c();
        }
        C0507f c0507f = (C0507f) this.f6569c.get();
        if (c0507f != null) {
            c0507f.f6579g = false;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetDataSource.loadNextPage", String.format("Failed to list product packages: %s", adobeAssetException.getMessage()));
    }
}
