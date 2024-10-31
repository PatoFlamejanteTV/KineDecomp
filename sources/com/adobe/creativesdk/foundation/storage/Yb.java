package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Yb extends FutureTask<com.adobe.creativesdk.foundation.internal.net.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f7177a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e f7178b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Handler f7179c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0324c f7180d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Yb(Callable callable, boolean[] zArr, com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar, Handler handler, C0324c c0324c) {
        super(callable);
        this.f7177a = zArr;
        this.f7178b = eVar;
        this.f7179c = handler;
        this.f7180d = c0324c;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        if (!isCancelled() || this.f7177a[0]) {
            return;
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar = this.f7178b;
        if (eVar != null) {
            _b.a(eVar, this.f7179c, new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled, null));
        }
        this.f7180d.e();
        C0324c c0324c = this.f7180d;
        c0324c.a(c0324c.g());
    }
}
