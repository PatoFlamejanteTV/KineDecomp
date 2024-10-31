package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class J implements C0324c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.E f4186a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f4187b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ K f4188c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(K k, com.adobe.creativesdk.foundation.internal.net.E e2, C0225c c0225c) {
        this.f4188c = k;
        this.f4186a = e2;
        this.f4187b = c0225c;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0324c.a
    public void a() {
        if (this.f4186a.d()) {
            return;
        }
        AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
        K k = this.f4188c;
        M m = k.f4194d;
        if (m.f4202d) {
            m.f4203e.a(this.f4187b, m.f4200b, k.f4193c, (String) null, adobeNetworkException);
        }
        M m2 = this.f4188c.f4194d;
        m2.f4204f.a(this.f4187b, null, m2.f4200b, adobeNetworkException);
    }
}
