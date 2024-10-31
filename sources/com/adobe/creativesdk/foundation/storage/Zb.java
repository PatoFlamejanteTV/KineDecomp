package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class Zb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e f7187a;

    /* renamed from: b */
    final /* synthetic */ AdobeCSDKException f7188b;

    public Zb(com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar, AdobeCSDKException adobeCSDKException) {
        this.f7187a = eVar;
        this.f7188b = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar = this.f7187a;
        if (eVar != null) {
            eVar.a(this.f7188b);
        }
    }
}
