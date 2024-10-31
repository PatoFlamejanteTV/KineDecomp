package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.fa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0232fa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4371a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4372b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4373c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4374d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0232fa(Aa aa, nb nbVar, String str, Aa aa2) {
        this.f4374d = aa;
        this.f4371a = nbVar;
        this.f4372b = str;
        this.f4373c = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4371a != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsDeleteOfCompositeWithID for compositeID= " + this.f4372b);
            Za.a("csdk_android_dcx", "AdobeDCXController.assetWasDeleted", "controllerRequestsDeleteOfCompositeWithID", this.f4372b);
            this.f4371a.d(this.f4373c, this.f4372b);
        }
    }
}
