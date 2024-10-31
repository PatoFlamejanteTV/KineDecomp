package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Ob implements sd<com.adobe.creativesdk.foundation.internal.storage.model.resources.f, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa f7078a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f7079b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb f7080c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Qb f7081d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ob(Qb qb, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb pbVar) {
        this.f7081d = qb;
        this.f7078a = fa;
        this.f7079b = fVar;
        this.f7080c = pbVar;
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
        this.f7080c.a(_b.a(this.f7078a, this.f7081d.f7099b.c(), this.f7079b), null);
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f7080c.a(null, adobeCSDKException);
    }
}
