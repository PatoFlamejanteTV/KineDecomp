package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class W implements pb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f5354a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ca f5355b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f5356c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5357d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(ra raVar, Lock lock, ca caVar, Condition condition) {
        this.f5357d = raVar;
        this.f5354a = lock;
        this.f5355b = caVar;
        this.f5356c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb
    public void a(Fa fa, AdobeCSDKException adobeCSDKException) {
        this.f5354a.lock();
        try {
            this.f5355b.f5385c = adobeCSDKException;
            this.f5355b.f5384b = fa;
            this.f5355b.f5383a = true;
            this.f5356c.signal();
        } finally {
            this.f5354a.unlock();
        }
    }
}
