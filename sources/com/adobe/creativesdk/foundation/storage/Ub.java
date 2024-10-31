package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Ub implements com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f7140a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Lb f7141b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.imageservice.t f7142c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ub(com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar) {
        this.f7140a = raVar;
        this.f7141b = lb;
        this.f7142c = tVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa, boolean z, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb pbVar) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = this.f7140a.b(fa, this.f7141b.c());
        b2.a(fa.q().getBytes(org.apache.commons.io.a.f29306f));
        return this.f7142c.a(this.f7141b.d(), b2, _b.a(this.f7141b.c().r().toString()), z, new Tb(this, fa, b2, pbVar), (Handler) null);
    }
}
