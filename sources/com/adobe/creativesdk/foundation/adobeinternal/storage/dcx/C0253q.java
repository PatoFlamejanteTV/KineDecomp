package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0253q implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ qb f4432a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4433b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4434c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0253q(qb qbVar, Aa aa, String str) {
        this.f4432a = qbVar;
        this.f4433b = aa;
        this.f4434c = str;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        qb qbVar = this.f4432a;
        if (qbVar != null) {
            qbVar.a(c0233g);
        }
        this.f4433b.a(this.f4434c, (AdobeCSDKException) null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        qb qbVar = this.f4432a;
        if (qbVar != null) {
            qbVar.a(c0233g, adobeCSDKException);
        }
        this.f4433b.a(this.f4434c, adobeCSDKException);
    }
}
