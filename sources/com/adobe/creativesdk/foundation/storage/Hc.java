package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Hc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7006a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar) {
        this.f7007b = adobePhotoCatalog;
        this.f7006a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f7006a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        }
    }
}
