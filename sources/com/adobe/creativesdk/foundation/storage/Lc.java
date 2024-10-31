package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
public class Lc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lc(c.a.a.a.c cVar) {
        this.f7052a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f7052a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, AdobePhotoCatalog.class.getSimpleName(), "Failed to list the catalogs");
        }
    }
}
