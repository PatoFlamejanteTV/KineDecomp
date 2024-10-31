package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class X implements pb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f4266a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ B f4267b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f4268c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(Lock lock, B b2, Condition condition) {
        this.f4266a = lock;
        this.f4267b = b2;
        this.f4268c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb
    public void a(Fa fa, AdobeCSDKException adobeCSDKException) {
        this.f4266a.lock();
        B b2 = this.f4267b;
        b2.f4126c = adobeCSDKException;
        b2.f4125b = fa;
        b2.f4124a = true;
        this.f4268c.signal();
        this.f4266a.unlock();
    }
}
