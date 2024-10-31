package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f5135a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f5136b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f5137c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ A f5138d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(A a2, F f2, l lVar, E e2) {
        this.f5138d = a2;
        this.f5135a = f2;
        this.f5136b = lVar;
        this.f5137c = e2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5135a != null) {
            int g2 = this.f5136b.g();
            if (this.f5136b.j()) {
                AdobeNetworkException.AdobeNetworkErrorCode adobeNetworkErrorCode = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoEnoughDeviceStorage;
                HashMap hashMap = new HashMap();
                hashMap.put(AdobeNetworkException.getKeyForResponse(), this.f5136b);
                this.f5135a.a(new AdobeNetworkException(adobeNetworkErrorCode, hashMap));
            } else if (g2 < 400) {
                if (this.f5136b.i()) {
                    AdobeNetworkException.AdobeNetworkErrorCode adobeNetworkErrorCode2 = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorFileDoesNotExist;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(AdobeNetworkException.getKeyForResponse(), this.f5136b);
                    this.f5135a.a(new AdobeNetworkException(adobeNetworkErrorCode2, hashMap2));
                } else {
                    this.f5135a.a(this.f5136b);
                }
            } else {
                AdobeNetworkException.AdobeNetworkErrorCode adobeNetworkErrorCode3 = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest;
                if (g2 == 401) {
                    adobeNetworkErrorCode3 = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorAuthenticationFailed;
                } else if (g2 != 403) {
                    if (g2 == 600) {
                        adobeNetworkErrorCode3 = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorOffline;
                    } else if ((this.f5136b.f() != null && (this.f5136b.f() instanceof SocketTimeoutException)) || (this.f5136b.f() instanceof ConnectException)) {
                        adobeNetworkErrorCode3 = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorTimeout;
                    }
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put(AdobeNetworkException.getKeyForResponse(), this.f5136b);
                this.f5135a.a(new AdobeNetworkException(adobeNetworkErrorCode3, hashMap3));
            }
        }
        this.f5137c.e();
    }
}
