package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0247n implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ qb f4415a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4416b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0231f f4417c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0247n(qb qbVar, Aa aa, C0231f c0231f) {
        this.f4415a = qbVar;
        this.f4416b = aa;
        this.f4417c = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        qb qbVar = this.f4415a;
        if (qbVar != null) {
            qbVar.a(c0233g);
        }
        this.f4416b.b(this.f4417c, (AdobeCSDKException) null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        qb qbVar = this.f4415a;
        if (qbVar != null) {
            qbVar.a(c0233g, adobeCSDKException);
        }
        this.f4416b.b(this.f4417c, adobeCSDKException);
    }
}
