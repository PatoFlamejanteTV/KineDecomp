package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class U implements pb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f5347a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ P f5348b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f5349c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5350d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(ra raVar, Lock lock, P p, Condition condition) {
        this.f5350d = raVar;
        this.f5347a = lock;
        this.f5348b = p;
        this.f5349c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb
    public void a(Fa fa, AdobeCSDKException adobeCSDKException) {
        this.f5347a.lock();
        P p = this.f5348b;
        p.f5335c = adobeCSDKException;
        p.f5334b = fa;
        p.f5333a = true;
        this.f5349c.signal();
        this.f5347a.unlock();
    }
}
