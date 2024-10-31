package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Xa implements vb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.b f4269a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ya f4270b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ArrayList f4271c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Sa f4272d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Lock f4273e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Condition f4274f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ya f4275g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(Ya ya, com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, Ya ya2, ArrayList arrayList, Sa sa, Lock lock, Condition condition) {
        this.f4275g = ya;
        this.f4269a = bVar;
        this.f4270b = ya2;
        this.f4271c = arrayList;
        this.f4272d = sa;
        this.f4273e = lock;
        this.f4274f = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, AdobeCSDKException adobeCSDKException) {
        if (fVar != null && adobeCSDKException == null) {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar = this.f4269a;
            bVar.f6613e = fVar.f6613e;
            this.f4275g.f4282d.b(bVar, this.f4270b);
            synchronized (this.f4271c) {
                this.f4271c.add(this.f4269a);
            }
        }
        if (adobeCSDKException != null && (adobeCSDKException instanceof AdobeAssetException) && ((AdobeAssetException) adobeCSDKException).getHttpStatusCode().intValue() == 600) {
            this.f4272d.f4235b = true;
        }
        this.f4273e.lock();
        try {
            Sa sa = this.f4272d;
            int i = sa.f4234a - 1;
            sa.f4234a = i;
            if (i == 0) {
                this.f4274f.signal();
            }
        } finally {
            this.f4273e.unlock();
        }
    }
}
