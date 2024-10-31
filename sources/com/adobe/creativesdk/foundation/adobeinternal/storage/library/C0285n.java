package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0285n implements pb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f4648a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0278g f4649b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f4650c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0287p f4651d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0285n(C0287p c0287p, Lock lock, C0278g c0278g, Condition condition) {
        this.f4651d = c0287p;
        this.f4648a = lock;
        this.f4649b = c0278g;
        this.f4650c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb
    public void a(Fa fa, AdobeCSDKException adobeCSDKException) {
        this.f4648a.lock();
        try {
            this.f4649b.f4616c = adobeCSDKException;
            this.f4649b.f4615b = fa;
            this.f4649b.f4614a = true;
            this.f4650c.signal();
        } finally {
            this.f4648a.unlock();
        }
    }
}
