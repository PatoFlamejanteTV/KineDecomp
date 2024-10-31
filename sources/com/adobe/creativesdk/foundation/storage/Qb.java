package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Qb implements com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f7098a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Lb f7099b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.imageservice.t f7100c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qb(com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar) {
        this.f7098a = raVar;
        this.f7099b = lb;
        this.f7100c = tVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa, boolean z, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb pbVar) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = this.f7098a.b(fa, this.f7099b.c());
        b2.a(fa.q().getBytes(org.apache.commons.io.a.f29306f));
        try {
            return this.f7100c.a(this.f7099b.d(), b2, _b.a(this.f7099b.c().r().toString()), z, new Ob(this, fa, b2, pbVar), (Handler) null);
        } catch (Exception unused) {
            System.out.print("\"Hello\"");
            return null;
        }
    }
}
