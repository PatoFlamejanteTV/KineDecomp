package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class D implements C0324c.a {

    /* renamed from: a */
    final /* synthetic */ C f4134a;

    public D(C c2) {
        this.f4134a = c2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0324c.a
    public void a() {
        this.f4134a.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled));
    }
}
