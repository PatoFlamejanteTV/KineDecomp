package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class N implements mb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f5326a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5327b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f5328c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5329d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(ra raVar, Lock lock, E e2, Condition condition) {
        this.f5329d = raVar;
        this.f5326a = lock;
        this.f5327b = e2;
        this.f5328c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f5326a.lock();
        E e2 = this.f5327b;
        e2.f5300b = adobeCSDKException;
        e2.f5299a = true;
        this.f5328c.signal();
        this.f5326a.unlock();
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(C0231f c0231f) {
        this.f5326a.lock();
        this.f5327b.f5299a = true;
        this.f5328c.signal();
        this.f5326a.unlock();
    }
}
