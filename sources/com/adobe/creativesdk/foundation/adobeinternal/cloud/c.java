package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCloudManager.java */
/* loaded from: classes.dex */
public class c implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f3945a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f3946b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, c.a.a.a.c cVar) {
        this.f3946b = dVar;
        this.f3945a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        Za.a(d.class.getSimpleName(), "refreshClouds", "onError", null);
        c.a.a.a.c cVar = this.f3945a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, d.class.getSimpleName(), "Failed to refresh the cloud manager", adobeCSDKException);
        }
    }
}
