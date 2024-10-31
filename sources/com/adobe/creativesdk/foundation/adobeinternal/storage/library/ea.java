package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
class ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4602a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ fa f4603b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(fa faVar, AdobeCSDKException adobeCSDKException) {
        this.f4603b = faVar;
        this.f4602a = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4603b.f4610e.a((sd) this.f4602a);
    }
}
