package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0239j implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ qb f4394a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4395b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4396c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0239j(qb qbVar, C0231f c0231f, Aa aa) {
        this.f4394a = qbVar;
        this.f4395b = c0231f;
        this.f4396c = aa;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        qb qbVar = this.f4394a;
        if (qbVar != null) {
            qbVar.a(c0233g);
        }
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pullComposite succeeded for compositeId = ");
        C0231f c0231f = this.f4395b;
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        this.f4396c.b(this.f4395b, (AdobeCSDKException) null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        qb qbVar = this.f4394a;
        if (qbVar != null) {
            qbVar.a(c0233g, adobeCSDKException);
        }
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pullComposite failed for compositeId = ");
        C0231f c0231f = this.f4395b;
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        this.f4396c.b(this.f4395b, adobeCSDKException);
    }
}
