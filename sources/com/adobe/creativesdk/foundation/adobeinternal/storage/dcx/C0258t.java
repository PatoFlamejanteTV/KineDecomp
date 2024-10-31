package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0258t implements kb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4453a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zb f4454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0258t(C0231f c0231f, zb zbVar) {
        this.f4453a = c0231f;
        this.f4454b = zbVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.kb
    public Fa a(Fa fa) throws AdobeCSDKException {
        if (this.f4453a.r() != null) {
            return this.f4454b.a(fa, this.f4453a);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorCompositeHrefUnassigned, (String) null);
    }
}
