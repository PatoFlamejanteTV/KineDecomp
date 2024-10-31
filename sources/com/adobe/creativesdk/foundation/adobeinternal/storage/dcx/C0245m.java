package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0245m implements kb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4411a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zb f4412b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0245m(C0231f c0231f, zb zbVar) {
        this.f4411a = c0231f;
        this.f4412b = zbVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.kb
    public Fa a(Fa fa) throws AdobeCSDKException {
        if (this.f4411a.r() != null) {
            return this.f4412b.a(fa, this.f4411a);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorCompositeHrefUnassigned, (String) null);
    }
}
