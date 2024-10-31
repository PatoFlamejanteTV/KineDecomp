package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class H implements mb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f5311a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0346p f5312b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f5313c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5314d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(ra raVar, Lock lock, C0346p c0346p, Condition condition) {
        this.f5314d = raVar;
        this.f5311a = lock;
        this.f5312b = c0346p;
        this.f5313c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f5311a.lock();
        C0346p c0346p = this.f5312b;
        c0346p.f5461c = adobeCSDKException;
        c0346p.f5459a = true;
        this.f5313c.signal();
        this.f5311a.unlock();
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(C0231f c0231f) {
        this.f5311a.lock();
        try {
            this.f5312b.f5460b = c0231f;
            this.f5312b.f5459a = true;
            this.f5313c.signal();
        } finally {
            this.f5311a.unlock();
        }
    }
}
