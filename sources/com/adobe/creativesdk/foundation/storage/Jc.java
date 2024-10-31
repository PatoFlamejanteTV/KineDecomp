package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Jc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7030a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7031b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jc(c.a.a.a.c cVar, String str) {
        this.f7030a = cVar;
        this.f7031b = str;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f7030a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCatalog.class.getSimpleName(), "Failed to create catalog " + this.f7031b);
    }
}
