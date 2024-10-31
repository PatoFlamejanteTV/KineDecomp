package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.qq.e.comm.constants.ErrorCode;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f5142a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f5143b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(A a2, F f2) {
        this.f5143b = a2;
        this.f5142a = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5142a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, Integer.valueOf(ErrorCode.NetWorkError.QUEUE_FULL_ERROR));
            this.f5142a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorServiceDisconnected, hashMap));
        }
    }
}
