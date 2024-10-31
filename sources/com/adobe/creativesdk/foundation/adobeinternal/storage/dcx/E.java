package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class E implements C0324c.a {

    /* renamed from: a, reason: collision with root package name */
    C0225c f4136a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ab f4137b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4138c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(C0225c c0225c, Ab ab, C0231f c0231f) {
        this.f4137b = ab;
        this.f4138c = c0231f;
        this.f4136a = c0225c;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.C0324c.a
    public void a() {
        this.f4137b.a(this.f4136a, null, this.f4138c, new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled));
    }
}
