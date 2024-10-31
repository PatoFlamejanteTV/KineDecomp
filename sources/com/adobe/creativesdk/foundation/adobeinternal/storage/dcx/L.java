package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class L implements C0324c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.E f4195a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4196b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ M f4197c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(M m, com.adobe.creativesdk.foundation.internal.net.E e2, String str) {
        this.f4197c = m;
        this.f4195a = e2;
        this.f4196b = str;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0324c.a
    public void a() {
        if (this.f4195a.d()) {
            return;
        }
        AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
        M m = this.f4197c;
        if (m.f4202d) {
            m.f4203e.a(m.f4199a, m.f4200b, this.f4196b, (String) null, adobeNetworkException);
        }
        M m2 = this.f4197c;
        m2.f4204f.a(m2.f4199a, null, m2.f4200b, adobeNetworkException);
    }
}
