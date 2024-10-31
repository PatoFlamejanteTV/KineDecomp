package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Tb implements sd<com.adobe.creativesdk.foundation.internal.storage.model.resources.f, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa f7127a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f7128b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb f7129c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ub f7130d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tb(Ub ub, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb pbVar) {
        this.f7130d = ub;
        this.f7127a = fa;
        this.f7128b = fVar;
        this.f7129c = pbVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f7129c.a(_b.a(this.f7127a, this.f7130d.f7141b.c(), this.f7128b), null);
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f7129c.a(null, adobeCSDKException);
    }
}
