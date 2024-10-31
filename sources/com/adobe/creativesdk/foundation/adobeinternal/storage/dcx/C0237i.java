package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0237i implements C0324c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f4389a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f4390b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f4391c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0237i(Lock lock, B b2, Condition condition) {
        this.f4389a = lock;
        this.f4390b = b2;
        this.f4391c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0324c.a
    public void a() {
        this.f4389a.lock();
        this.f4390b.f4126c = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
        B b2 = this.f4390b;
        b2.f4125b = null;
        b2.f4124a = true;
        this.f4391c.signal();
        this.f4389a.unlock();
    }
}
