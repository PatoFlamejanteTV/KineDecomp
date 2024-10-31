package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class I implements ib {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f4177a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(K k) {
        this.f4177a = k;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib
    public void a(C0225c c0225c, AdobeCSDKException adobeCSDKException) {
        K k = this.f4177a;
        M m = k.f4194d;
        if (m.f4202d) {
            m.f4203e.a(c0225c, m.f4200b, m.i, k.f4193c, adobeCSDKException);
        }
        K k2 = this.f4177a;
        M m2 = k2.f4194d;
        m2.f4204f.a(c0225c, k2.f4193c, m2.f4200b, adobeCSDKException);
    }
}
