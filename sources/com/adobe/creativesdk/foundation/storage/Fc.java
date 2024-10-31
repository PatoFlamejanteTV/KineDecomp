package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Fc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6981a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6982b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar) {
        this.f6982b = adobePhotoCatalog;
        this.f6981a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f6981a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        }
    }
}
